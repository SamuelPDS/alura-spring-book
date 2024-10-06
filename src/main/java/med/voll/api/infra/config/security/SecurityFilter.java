package med.voll.api.infra.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJwt = getToken(request);

        filterChain.doFilter(request, response);
    }

    private Object getToken(HttpServletRequest request) {
        var tokenAuthorization = request.getHeader("Authorization");
        if(tokenAuthorization == null) {
            throw new RuntimeException("token not sended");
        }

        return tokenAuthorization.replace("Bearer", "");
    }
}
