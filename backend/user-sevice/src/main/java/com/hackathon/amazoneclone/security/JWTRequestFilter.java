package com.hackathon.amazoneclone.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author danyls ngongang
 * @Created 13/09/2021-11:56
 * @Project user-service
 */
@Service
@RequiredArgsConstructor
public class JWTRequestFilter extends OncePerRequestFilter {

//    private final UserService userService;
//    private final JWTUtils jwtUtils;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorization = request.getHeader("Authorization");
//
//        if(authorization!=null && authorization.startsWith("Bearer ")){
//            final String bearerToken = authorization.replaceFirst("Bearer ","");
//
//            final String userEmail = jwtUtils.extractSubject(bearerToken);
//            // get security context
//            SecurityContext context = SecurityContextHolder.getContext();
//            if(userEmail!=null && context.getAuthentication()==null){
//                UserDetails userDetails = userService.loadUserByUsername(userEmail);
//                if(jwtUtils.validateToken(bearerToken,userDetails)){
//                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(
//                            userDetails,null,userDetails.getAuthorities()
//                    );
//                    usernamePasswordAuthenticationToken.setDetails(
//                            new WebAuthenticationDetailsSource().buildDetails(request)
//                    );
//                    context.setAuthentication(usernamePasswordAuthenticationToken);
//                }
//            }
//        }
//

        filterChain.doFilter(request, response);
    }
}
