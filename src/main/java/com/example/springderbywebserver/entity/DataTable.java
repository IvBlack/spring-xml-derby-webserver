package com.example.springderbywebserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DATA_TABLE")
public class DataTable {
    @Id
    @Column(name = "ID")
    int ID;
    @Column(name = "VALUE")
    String VALUE;
}
