package com.pearson.grid.dao.domain;

import java.util.Date;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Course {

	@PrimaryKey
	String key;
	@Column
	String course_book_id;
	@Column
	String course_code;
	@Column
	String title;
	@Column
	String description;
	@Column
	String thumbnail;
	@Column
	Date start_date;
	@Column
	Date end_date;
	@Column
	String ams_calendar_id;
	@Column
	String author;
	@Column
	Date created_at;
	@Column
	Date updated_at;
	@Column
	int version;
	@Column
	String metadata_map;
	@Column
	String socrates_id;
	@Column
	String course_status;
	@Column
	String registrar_course_id;
	@Column
	String course_ready_message_id;
	
	public Course() {
		key = null;
	}

	public String getKey() {
		return key;
	}

	public String getCourse_book_id() {
		return course_book_id;
	}

	public String getCourse_code() {
		return course_code;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public Date getStart_date() {
		return start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public String getAms_calendar_id() {
		return ams_calendar_id;
	}

	public String getAuthor() {
		return author;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public int getVersion() {
		return version;
	}

	public String getMetadata_map() {
		return metadata_map;
	}

	public String getSocrates_id() {
		return socrates_id;
	}

	public String getCourse_status() {
		return course_status;
	}

	public String getRegistrar_course_id() {
		return registrar_course_id;
	}

	public String getCourse_ready_message_id() {
		return course_ready_message_id;
	}	
	
}
