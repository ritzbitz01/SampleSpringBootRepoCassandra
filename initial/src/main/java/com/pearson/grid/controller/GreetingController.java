package com.pearson.grid.controller;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.grid.dao.CassandraDao;
import com.pearson.grid.dao.domain.Course;
import com.pearson.grid.dao.domain.Greeting;
import com.pearson.grid.dao.domain.GreetingList;

@RestController
@EnableAutoConfiguration
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String dayTemplate = "Hello, these are the greetings from %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value="/{day}", method=RequestMethod.GET)
    public Greeting greetingDay(@PathVariable @DateTimeFormat(iso=ISO.DATE) Date day, Model model) {
    	return new Greeting(counter.incrementAndGet(),
    			String.format(dayTemplate, day.toString()));
    }
    
    @RequestMapping(value="/{user}", method=RequestMethod.GET)
    public Greeting greetingDay(@PathVariable String username, Model model) {
    	return new Greeting(counter.incrementAndGet(),
    			String.format(template, username));
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Greeting getGreeting(@PathVariable long id) {
    	CassandraDao dao = new CassandraDao();
    	return dao.getGreeting(id);
    }
    
    @RequestMapping(value="/{user}/greeting", method=RequestMethod.POST)
    public GreetingList createGreetingUser(@PathVariable String user,
    		@RequestBody GreetingList greetings, HttpServletRequest request,
    		HttpServletResponse response) {
    	for(Greeting g : greetings.getGreetings()) {
    		CassandraDao dao = new CassandraDao();
    		dao.insertGreeting(g);
    	}
    	return greetings;
    }
    
    @RequestMapping(value="/course", method=RequestMethod.POST)
    public Course createCourse(
    		@RequestBody Course course, HttpServletRequest request,
    		HttpServletResponse response) {
    	
    		CassandraDao dao = new CassandraDao();
    		dao.insertCourse(course);
    	
    	return course;
    }
    
//	@RequestMapping(value = "/courses/{courseId}/assignments", method = RequestMethod.POST)
//	public CourseAssignmentList createCourseAssignments(
//			@PathVariable(value = "courseId") String courseId,
//			@RequestBody CourseAssignmentList assignments,
//			HttpServletRequest request, HttpServletResponse response)
//			throws RestException {
//		return new CourseAssignmentList(createCourseAssignments(courseId,
//				assignments.getAssignments()));
//	}
}