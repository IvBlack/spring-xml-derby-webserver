package com.example.springderbywebserver.repo;

import com.example.springderbywebserver.entity.DataTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DataRepository extends CrudRepository<DataTable, Integer> {

}
