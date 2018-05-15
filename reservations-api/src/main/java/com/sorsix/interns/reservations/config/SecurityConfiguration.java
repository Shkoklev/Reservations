package com.sorsix.interns.reservations.config;

import com.sorsix.interns.reservations.service.OwnerService;
import com.sorsix.interns.reservations.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Configuration
    @Order(1)
    public static class AdminSecurity extends WebSecurityConfigurerAdapter {

        private final AuthenticationSuccessHandler successHandler;
        private final AuthenticationFailureHandler failureHandler;
        private final LogoutSuccessHandler logoutSuccessHandler;
        private final AuthenticationEntryPoint authenticationEntryPoint;
        private final OwnerService ownerService;
        private final PasswordEncoder passwordEncoder;

        public AdminSecurity(AuthenticationSuccessHandler successHandler, AuthenticationFailureHandler failureHandler, LogoutSuccessHandler logoutSuccessHandler, AuthenticationEntryPoint authenticationEntryPoint, OwnerService ownerService, PasswordEncoder passwordEncoder) {
            this.successHandler = successHandler;
            this.failureHandler = failureHandler;
            this.logoutSuccessHandler = logoutSuccessHandler;
            this.authenticationEntryPoint = authenticationEntryPoint;
            this.ownerService = ownerService;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(ownerService).passwordEncoder(passwordEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .httpBasic().disable()
                    .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPoint);

            http.antMatcher("/api/owner/**")
                    .authorizeRequests()
                    .antMatchers("/api/owner/register")
                    .permitAll()
                    .antMatchers("/api/owner/**")
                    .hasAuthority("ADMIN")
                    .and()
                    .formLogin()
                    .loginProcessingUrl("/api/owner/login")
                    .successHandler(successHandler)
                    .failureHandler(failureHandler)
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/api/logout")
                    .logoutSuccessHandler(logoutSuccessHandler)
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                    .and()
                    .headers()
                    .frameOptions()
                    .disable();
        }
    }

    @Configuration
    @Order(2)
    public static class UserSecurity extends WebSecurityConfigurerAdapter {

        private final AuthenticationSuccessHandler successHandler;
        private final AuthenticationFailureHandler failureHandler;
        private final LogoutSuccessHandler logoutSuccessHandler;
        private final AuthenticationEntryPoint authenticationEntryPoint;
        private final UserService userService;
        private final PasswordEncoder passwordEncoder;

        public UserSecurity(AuthenticationSuccessHandler successHandler, AuthenticationFailureHandler failureHandler, LogoutSuccessHandler logoutSuccessHandler, AuthenticationEntryPoint authenticationEntryPoint, UserService userService, PasswordEncoder passwordEncoder) {
            this.successHandler = successHandler;
            this.failureHandler = failureHandler;
            this.logoutSuccessHandler = logoutSuccessHandler;
            this.authenticationEntryPoint = authenticationEntryPoint;
            this.userService = userService;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .httpBasic().disable()
                    .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPoint);

            http.formLogin()
                    .loginProcessingUrl("/api/login")
                    .successHandler(successHandler)
                    .failureHandler(failureHandler)
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/api/logout")
                    .logoutSuccessHandler(logoutSuccessHandler)
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                    .and()
                    .headers()
                    .frameOptions()
                    .disable();


            http.authorizeRequests()
                    .antMatchers("/api/user/loggedUser", "/api/reserve")
                    .hasAuthority("USER")
                    .antMatchers("api/user/register")
                    .permitAll();
        }
    }

    @Bean
    public AuthenticationSuccessHandler getSuccessHandler() {
        return (request, response, authentication) -> {
            response.setStatus(HttpStatus.OK.value());
        };
    }

    @Bean
    public AuthenticationFailureHandler failureHandler() {
        return (request, response, exception) -> {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        };
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) ->
                response.setStatus(HttpStatus.OK.value());
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPoint() {
            /**
             * Always returns a 401 error code to the client.
             */
            @Override
            public void commence(HttpServletRequest request,
                                 HttpServletResponse response,
                                 AuthenticationException authenticationException) throws IOException,
                    ServletException {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
            }
        };
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
