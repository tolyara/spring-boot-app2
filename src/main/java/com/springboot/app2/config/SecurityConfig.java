package com.springboot.app2.config;

import com.springboot.app2.filter.jwt.JwtTokenFilter;
import com.springboot.app2.service.jwt.JwtConfigurer;
import com.springboot.app2.service.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//  https://docs.spring.io/spring-security/reference/5.8/migration/servlet/config.html

// TODO - try http.authorizeRequests().antMatchers("/").permitAll();

@Configuration
//@EnableWebSecurity

//public class SecurityConfig extends WebSecurityConfigurerAdapter {
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    private static final String ADMIN_ENDPOINT = "/admin/**";
    private static final String LOGIN_ENDPOINT = "/auth/login";
    private static final String TEST_ENDPOINT = "/test";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

//    @Bean
//    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .httpBasic().disable() // turn off basic auth
//                .csrf().disable()   // turn off csrf protection
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // don't create sessions
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers(LOGIN_ENDPOINT).permitAll()
//                .requestMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}







//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic().disable() // turn off basic auth
//                .csrf().disable()   // turn off csrf protection
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // don't create sessions
//                .and()
//                .authorizeRequests()
////                .antMatchers(LOGIN_ENDPOINT).permitAll()
////                .antMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
//                .requestMatchers(LOGIN_ENDPOINT).permitAll()
//                .requestMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .apply(new JwtConfigurer(jwtTokenProvider));
//    }
