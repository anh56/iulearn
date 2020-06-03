package com.iu.iulearn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        //create  cors config and add to security
        http.cors();
        // remove csrf filter
        http.csrf().disable()
                .antMatcher("/api/**").authorizeRequests()  // requests with /api need to be checked for authorization
                .antMatchers("/api/user/login", "/api/user/register", "/api/category/**","/api/course/**").permitAll() //skip check for these requests
                .antMatchers("/api/video/**","/api/material/**").hasAnyRole("STUDENT","ADMIN","TA") // example authenticate, only student can access url with these
                .antMatchers("/api/course/add").hasAnyRole("ADMIN", "TA")
                .antMatchers("/api/category/add").hasAnyRole("ADMIN", "TA")
                .antMatchers("/api/lesson/add").hasAnyRole("ADMIN", "TA")
                .antMatchers("/api/material/add").hasAnyRole("ADMIN", "TA")
                .antMatchers("/api/video/add").hasAnyRole("ADMIN", "TA")
                .antMatchers("/api/user/all","/api/user/page", "/api/user/{id}").hasAnyRole("ADMIN")
                .anyRequest().authenticated(); // the rest need to be login to use

        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), userDetailsService));
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // ignore these from the security wrapper
        //super.configure(web);
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                "/upload/**");
    }


}
