package com.example.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController //Telling the java application --> this class will contain API annotation
public class StudentController {

    @Autowired // Automatically take care of the StudentService object creation
    StudentService studentService; // object has been created

    // database

    // add student
    @PostMapping("/add_student")
    public ResponseEntity<String> addStudent(@RequestBody() Student student){

        // calling the
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    // get student
    @GetMapping("get_student_by_id")
    public ResponseEntity<Student> getStudentById(@RequestParam("id")Integer id){

        // call the service layer
        Student student = studentService.getStudentById(id);
        if(student==null)
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(student,HttpStatus.OK);
    }

    //get student by name
    @GetMapping("/get_student_by_name")
    public ResponseEntity<Student> getStudentByName(@RequestParam("name")String searchName){
        Student student = studentService.getStudentByName(searchName);
        if(student==null)
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(student,HttpStatus.OK);
    }

    // get by path variable
    @GetMapping("/get_by_path/{id}")
    public ResponseEntity<Student> getByPath(@PathVariable("id")Integer id){

        Student student = studentService.getStudentById(id);
        if(student==null)
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(student,HttpStatus.OK);
    }

    // update student
    @PutMapping("/update_student")
    public ResponseEntity<Student> updateStudent(@RequestBody()Student student){
        Student s = studentService.updateStudent(student);
        if(s==null)
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(s,HttpStatus.OK);
    }

    // delete student
    @DeleteMapping("/delete_student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") Integer id){
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }
}
