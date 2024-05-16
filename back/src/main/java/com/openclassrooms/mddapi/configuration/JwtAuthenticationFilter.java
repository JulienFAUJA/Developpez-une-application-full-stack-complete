package com.openclassrooms.mddapi.configuration;



import java.io.IOException;

import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.openclassrooms.mddapi.services.JWTokenService;
import com.openclassrooms.mddapi.services.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component 
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JWTokenService jwtService;
    private final UserService userService;
    private UsernamePasswordAuthenticationToken authToken;


    public JwtAuthenticationFilter(JWTokenService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    /**
     * Execute un filtre à chaque requête
     */
    protected void doFilterInternal(
             @NonNull HttpServletRequest request,
             @NonNull HttpServletResponse response,
             @NonNull FilterChain filterChain)
            throws ServletException, IOException {
    	
    	if (request.getServletPath().contains("/api/auth/register")) {
    	      filterChain.doFilter(request, response);
    	      return;
    	    }

        String authHeader = request.getHeader("Authorization");
        // Vérifie si le Header existe et s'il contient le Token
        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request,response);
            return;
        }

        String token = authHeader.substring(7);
        String email = jwtService.extractEmail(token);
        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userService.loadUserByUsername(email);
            if(jwtService.isValid(token, email)) {
            	if(authToken==null) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,null, userDetails.getAuthorities());
                	authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            	else if(authToken!=null && authToken.getDetails()==null) {
            		setDetailContext(request, authToken);
            	}
            }
        }
        filterChain.doFilter(request, response);
    }

	private void setDetailContext(HttpServletRequest request, UsernamePasswordAuthenticationToken authToken) {
		authToken.setDetails(
		        new WebAuthenticationDetailsSource().buildDetails(request)
		);
		SecurityContextHolder.getContext().setAuthentication(authToken);
	}
}
