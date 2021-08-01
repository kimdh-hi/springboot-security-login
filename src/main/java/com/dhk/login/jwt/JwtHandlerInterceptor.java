package com.dhk.login.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtHandlerInterceptor implements HandlerInterceptor {

    private final JwtServiceImpl jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String token = request.getHeader("Authorization");
        log.info("preHandle token = {}", token);
        try{
            if (token == null) {
                return responseError(response, "Token is invalid");
            }
            jwtService.isValid(token);
            return true;
        } catch(Exception e) {
            return responseError(response, e.getMessage());
        }
    }

    private boolean responseError(HttpServletResponse response, String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ResponseDto dto = ResponseDto.builder()
                .result(false)
                .message(message)
                .object(null)
                .build();
        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(mapper.writeValueAsString(dto));
        return false;
    }
}
