package com.example.sms;


import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository //to tell this is the repository class, the functions are helpful for database connection
public class StudentRepository {

    HashMap<Integer,Student> studentDb = new HashMap<>();

    String addStudentToDb(Student student){
        int key = student.id;
        studentDb.put(key,student);

        return "Successfully added";
    }

    Student getStudentFromDb(int id){
        if(studentDb.containsKey(id))
            return studentDb.get(id);
        else
            return null;
    }
    Student getStudentFromDb(String searchName){
        for(Student student : studentDb.values()){
            if(student.name.equals(searchName))
                return student;
        }
        return null;
    }

    Student updateStudentInDb(Student student){
        int key = student.id;
        if(studentDb.containsKey(key)){
            studentDb.put(key,student);
            return student;
        }
        else
            return null;
    }

    String deleteStudentInDb(int id){
        studentDb.remove(id);
        return "Successfully removed";
    }
}
