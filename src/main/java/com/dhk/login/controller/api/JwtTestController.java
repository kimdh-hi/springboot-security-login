package com.dhk.login.controller.api;

import com.dhk.login.jwt.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class JwtTestController {

    @PostMapping("/api/test")
    public ResponseDto test() {
        return new ResponseDto(true, "Test", null);
    }
}
