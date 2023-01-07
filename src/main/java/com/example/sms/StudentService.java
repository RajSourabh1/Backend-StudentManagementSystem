package com.example.sms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //this is the way of telling java --> this is a service layer
public class StudentService {

    // option 1 to create an object myself
    // do not used to do it because of Autowired
    // StudentRepository obj = new StudentRepository();

    @Autowired // this is used to connect different classes via obj present in IOC container
    StudentRepository studentRepository; // Assume object is created

    String addStudent(Student student){
        return studentRepository.addStudentToDb(student);
    }

    Student getStudentById(int id){
        // this call the repository layer
       return studentRepository.getStudentFromDb(id);
    }

    Student getStudentByName(String name){
        return studentRepository.getStudentFromDb(name);
    }

    Student updateStudent(Student student){
        return studentRepository.updateStudentInDb(student);
    }

    String deleteStudent(int id){
        return studentRepository.deleteStudentInDb(id);
    }
}
