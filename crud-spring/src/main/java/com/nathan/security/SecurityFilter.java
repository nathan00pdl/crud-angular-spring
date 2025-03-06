package com.nathan.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nathan.Repository.UserRepository;
import com.nathan.Service.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * Notes:
 * 
 * This class is a custom filter and aims to validate the JWT token sent by the client in the HTTP request and setting authentication in the `SecurityContextHolder`.
 * The @Component annotation has the function of signaling to SpringBoot that it will be responsible for managing the filter lifecycle.
 * `UsernamePasswordAuthenticationToken` is an internal filter defined by Spring Security.
 */

@Component
public class SecurityFilter extends OncePerRequestFilter {
    private TokenService tokenService;
    private UserRepository userRepository;

    public SecurityFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request); 
        var login = tokenService.validateToken(token); // Variable name -> validateToken returns the user login associated with the generated token

        if (token != null) {
            UserDetails userDetails = userRepository.findByLogin(login);    
            var userAuthenticated = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            
            SecurityContextHolder.getContext().setAuthentication(userAuthenticated);
        }
        
        filterChain.doFilter(request, response); // Passing the request to the next filter in the chain
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");  
    }
}
