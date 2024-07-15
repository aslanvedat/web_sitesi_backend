package com.papps.shopping.security;

import com.papps.shopping.share.Constants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author : Onur TALANTIMUR
 * @mailto : onurta@netas.com.tr
 * @created : 12.07.2024, Friday
 **/

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JpaUserService jpaUserService;
    private final JwtUtils jwtUtils;


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        var uri = request.getRequestURI();
        return uri.startsWith("/api/auth");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {


        var authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith(Constants.JWT.BEARER_PREFIX)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized access");
        } else {
            var token = authHeader.replace(Constants.JWT.BEARER_PREFIX, "");
            var mail = jwtUtils.extractUsername(token);

            if (mail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                var userDetails = jpaUserService.loadUserByUsername(mail);

                if (jwtUtils.validateToken(token, userDetails)) {
                    var authToken = new UsernamePasswordAuthenticationToken(mail, null,
                            userDetails.getAuthorities());

                    authToken.setDetails(new WebAuthenticationDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }

            }
            filterChain.doFilter(request, response);

        }


    }
}
