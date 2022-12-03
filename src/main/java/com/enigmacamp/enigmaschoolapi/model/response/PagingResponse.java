package com.enigmacamp.enigmaschoolapi.model.response;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class PagingResponse<T> extends CommonResponse {

    private List<T> data;
    private long count;
    private int totalPage;
    private int page;
    private int size;

    public PagingResponse(String message, Page<T> page) {
        super.setCode("2XX");
        super.setMessage(message);
        super.setStatus(HttpStatus.OK.name());
        this.data = page.getContent();
        this.count = page.getTotalElements();
        this.totalPage = page.getTotalPages();
        this.page = page.getNumber() + 1;
        this.size = page.getSize();
    }
}
