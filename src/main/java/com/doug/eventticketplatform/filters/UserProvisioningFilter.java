package com.doug.eventticketplatform.filters;

import com.doug.eventticketplatform.model.User;
import com.doug.eventticketplatform.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class UserProvisioningFilter  extends OncePerRequestFilter {

    private final UserRepository userRepository;

    public UserProvisioningFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
          Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
          if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof Jwt jwt) {
              UUID keyCloakId = UUID.fromString(jwt.getSubject());

              if (!userRepository.existsById(keyCloakId)){
                  User newUser = new User();
                   newUser.setId(keyCloakId);
                   newUser.setName(jwt.getClaimAsString("name"));
                   newUser.setEmail(jwt.getClaimAsString("email"));
                   userRepository.save(newUser);
              }
          }

          filterChain.doFilter(request, response);

    }
}
