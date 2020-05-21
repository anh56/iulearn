package com.iu.iulearn.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private UserDetailsService _userDetailsService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager,
                                  UserDetailsService userDetailsService ){
        super(authenticationManager);
        _userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        super.doFilterInternal(request, response, chain);
        final String JWT_SECRET = "!*&!1nt3ll3ctu@LUn1vErs3S3cr$tKey!*&!";

        //get token from request header
        String tokenBearer = request.getHeader("Authorization");

        //check for token validity: token must start with bearer
        if (tokenBearer !=null &&tokenBearer.startsWith("Bearer")){
            //replace "bearer" with "" to get the exact token
            String token = tokenBearer.replace("Bearer", "");
            //decode the token
            String email = Jwts.parser()
                    .setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            // get user from db
            UserDetails userDetails = _userDetailsService.loadUserByUsername(email);
            // if this is valid, forward the info to the security context
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        chain.doFilter(request, response);
    }
}
