package com.pearson.grid.dao;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.pearson.grid.dao.domain.Course;
import com.pearson.grid.dao.domain.Greeting;

public class CassandraDao {

	private static Cluster cluster;
	private static Session session;

	private static final String keyspace ="las";

	public static void setupCassandra() {
		try {

			cluster = Cluster.builder().addContactPoints(InetAddress.getLocalHost()).build();

			session = cluster.connect(keyspace);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static Cluster getCluster() {
		return cluster;
	}

	public static Session getSession() {
		return session;
	}

	public void insertGreeting(Greeting greeting) {
		try {
			CassandraOperations cassandraOps = new CassandraTemplate(session);

			cassandraOps.insert(greeting);

		} catch(Exception e) {
			System.out.println("ERROR INSERTING GREETING: " + e);
		}
	}

	public Greeting getGreeting(long id) {
		Greeting greeting = null;
		try {
			CassandraOperations cassandraOps = new CassandraTemplate(session);

			Select s = QueryBuilder.select().from("greeting");
			s.where(QueryBuilder.eq("id", id));

			//LOG.info(cassandraOps.queryForObject(s, Person.class).getId());

			greeting = cassandraOps.queryForObject(s, Greeting.class);

			cassandraOps.truncate("greeting");

		} catch(Exception e) {
			System.out.println("EXCEPTION GETTING GREETING: " + e);
		}
		return greeting;
	}
	
	public void insertCourse(Course course) {
		try {
			CassandraOperations cassandraOps = new CassandraTemplate(session);

			cassandraOps.insert(course);
		} catch(Exception e) {
			System.out.println("ERROR INSERTING COURSE: " + e);
		}
	}
}
