package com.pearson.grid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pearson.grid.dao.CassandraDao;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		CassandraDao.setupCassandra();

		SpringApplication.run(Application.class, args);
	}

}
