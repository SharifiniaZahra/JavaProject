package com.company.service;

import com.company.repository.StudentRepository;

public class StudentService {
    public void getAllStudents(){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.findAll();
    }
    public void creatStudent(int id,String name ,String family,int age){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.insert(id,name,family,age);
    }
    public void updateStudent(int id,String name ,String family,int age){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.update(id,name,family,age);
    }

    public void getStudentById(int id){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.findByID(id);
    }

    public void deleteStudentById(int id){
        StudentRepository studentRepository= new StudentRepository();
        studentRepository.deleteById(id);
    }
}
