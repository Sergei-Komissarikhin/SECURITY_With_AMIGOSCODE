package com.example.demo.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagmentController {

    private static List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping
    public List<Student> getAllStudents(){
        return STUDENTS;
    }

    @PostMapping()
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student + " was add.");
    }
    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println(studentId + " was deleted");
    }
    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable Integer studentId,
                              @RequestBody Student student){
        System.out.println(String.format("%s %d", student, studentId));
    }
}