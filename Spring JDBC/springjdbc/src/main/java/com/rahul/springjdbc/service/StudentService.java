package com.rahul.springjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.springjdbc.model.Student;
import com.rahul.springjdbc.repository.StudentRepo;

@Service
public class StudentService {

    private StudentRepo repo;



    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }



    public void addStudent(Student s){
        repo.save(s);
    }

    public List<Student> getStudents(){
        return repo.findAll();

        // return List.of(new Student(),new Student(),new Student());
    }

}
