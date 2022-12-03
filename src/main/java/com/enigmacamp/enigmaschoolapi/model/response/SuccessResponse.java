package com.enigmacamp.enigmaschoolapi.model.response;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class SuccessResponse<T> extends CommonResponse {
    T data;

    public SuccessResponse(String message, T data) {
        super.setCode("2XX");
        super.setMessage(message);
        super.setStatus(HttpStatus.OK.name());
        this.data = data;
    }
}
