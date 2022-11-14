package com.obinna.FashionBlog.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class APIResponse {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
//        map.put("date", localDate);
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map, status);

    }
}
