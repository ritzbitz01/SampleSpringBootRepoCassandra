package com.pearson.grid.dao.domain;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Greeting {

	@PrimaryKey
    private final long id;
	
	@Column(value = "content")
	private final String content;
    
    public Greeting() {
    	id = 0;
    	content = null;
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    
    @Override
    public String toString() {
    	return "Greeting [id=" + id + ", content=" + content + "]"; 
    }
}
