package com.example.springderbywebserver.service.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "any")
public class SqlFromXml {
  @JacksonXmlProperty(localName = "sql")
  String sql;
}