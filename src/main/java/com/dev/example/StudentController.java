package com.dev.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "hello world";
//    }

    @PostMapping("/post")
    public String post(
           @RequestBody String message
    ) {
        return "Post request " + message;
    }

    @PostMapping("/post-order")
    public String post(
           @RequestBody Order order
    ) {
        return "Post request " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(
            @RequestBody OrderRecord order
    ) {
        return "Post request " + order.toString();
    }

//    @GetMapping("/hello/{user-name}")
//    public String pathVar(
//            @PathVariable("user-name") String userName
//    ) {
//        return "path variable: " + userName;
//    }

    @GetMapping("/hello")
    public String paramsVar(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastname") String userLastName
    ) {
        return "path variable: " + userName + ' ' + userLastName;
    }

    //start for student
    @PostMapping("/student")
    public Student createStudent(
            @RequestBody StudentDto dto
    ) {
        var student = toStudent(dto);
        return repository.save(student);
    }

    private Student toStudent(StudentDto dto) {
        var student = new Student();
        student.setFirstName(dto.firstname());
        student.setLastName(dto.lastname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }

    @GetMapping("/students")
    public List<Student> findAllStudent(
    ) {
        return repository.findAll();
    }

    @GetMapping("/student/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id") Integer id
    ) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/student/search/{student-name}")
    public List<Student> findStudentByName(
            @PathVariable("student-name") String name
    ) {
        return repository.findAllByFirstNameContaining(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
        repository.deleteById(id);
    }
}
