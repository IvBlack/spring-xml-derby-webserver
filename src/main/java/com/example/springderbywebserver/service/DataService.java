package com.example.springderbywebserver.service;

import com.example.springderbywebserver.controller.dto.DataResponse;
import com.example.springderbywebserver.service.dto.SqlFromXml;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Slf4j
@Service
@RequiredArgsConstructor
public class DataService {

  private final NamedParameterJdbcTemplate myJdbcTemplate;

  public String parseExtrenalXml() throws IOException {
    var fileSystemResource = new FileSystemResource("any-sql.xml");
    XmlMapper xmlMapper = new XmlMapper();
    var sqlFromXml = xmlMapper.readValue(fileSystemResource.getFile(), SqlFromXml.class);
    log.info("Sql from xml {}", sqlFromXml);
    return sqlFromXml.getSql();
  }

  public DataResponse getDataById(int id) {

    try {
      var sql = parseExtrenalXml();
      if (sql == null) {
        return DataResponse.builder()
                .data(null)
                .request(id)
                .response("SQL not found in config")
                .build();
      }


      var resultN = myJdbcTemplate.getJdbcTemplate().queryForMap(sql, id);
      return DataResponse.builder()
              .data(resultN)
              .request(id)
              .response("ok")
              .build();

    } catch (Exception ex) {
      log.error("Error while get data, {}", ex.getMessage());
      return DataResponse.builder()
              .data(null)
              .request(id)
              .response(ex.getLocalizedMessage())
              .build();
    }
  }
}