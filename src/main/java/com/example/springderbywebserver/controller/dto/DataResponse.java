package com.example.springderbywebserver.controller.dto;


import com.example.springderbywebserver.entity.DataTable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataResponse {
  private final Object data;
  private final String response;
  private final Integer request;
}
