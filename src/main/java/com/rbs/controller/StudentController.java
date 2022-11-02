package com.rbs.controller;

import java.util.ArrayList;
import java.util.List;

import com.rbs.entity.Student;
import com.rbs.service.StudentService;
import com.rbs.support.Container;
import com.rbs.support.MarketData;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;


@RestController
public class StudentController
{
    @Autowired
    StudentService studentService;

    @Autowired
    Container container;

    @GetMapping("/student")
    @RateLimiter(name = "getAllStudent", fallbackMethod = "getAllStudentFallBack")
    public ResponseEntity<List<Student>> getAllStudent()
    {
        System.out.println("Service called::::");
        MarketData marketData =container.listOfMktData.pop();
        System.out.println(container.listOfMktData.size());
        List<Student> asli=studentService.getAllStudent();
        return ResponseEntity.ok().body(asli);
    }
    public ResponseEntity getAllStudentFallBack(RequestNotPermitted ex) {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Retry-After", "1");

        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .headers(responseHeaders)
                .body("Too many request - No further calls are accepted");
    }

    @PostMapping("/student")
    private int saveStudent(@RequestBody Student student)
    {
        studentService.saveOrUpdate(student);
        System.out.println("vijay:debug recntly added");
        return student.getId();
    }
}
