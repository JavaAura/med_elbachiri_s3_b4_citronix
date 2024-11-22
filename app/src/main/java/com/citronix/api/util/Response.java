package com.citronix.api.util;

import java.util.List;

import lombok.*;

@Data
@Builder
public class Response {
    int code;
    String status;
    List<String> errors;
}
