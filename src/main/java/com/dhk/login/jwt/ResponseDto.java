package com.dhk.login.jwt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseDto {

    private boolean result;
    private String message;
    private Object object;

    @Builder
    public ResponseDto(boolean result, String message, Object object) {
        this.result = result;
        this.message = message;
        this.object = object;
    }
}
