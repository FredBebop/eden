package com.bebop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @projectName: eden
 * @package: com.bebop.configuration
 * @className: SecurityConfig
 * @author: fredbebop
 * @description: TODO
 * @date: 2022/9/14 20:43
 * @version: 1.0
 */
@Configuration
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // H2DataBase的配置
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()// 放行 H2 的请求
                .and().csrf().ignoringAntMatchers("/h2-console/**")// 禁用 H2 控制台的 CSRF 防护
                .and().headers().frameOptions().sameOrigin();// 允许iframe加载同源的资源

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic(withDefaults());

        // 自定义实现UserDetailsService配置
        http.userDetailsService(userDetailsService)
                .formLogin();

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
