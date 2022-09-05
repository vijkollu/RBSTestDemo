package com.rbs.service;

import java.util.ArrayList;
import java.util.List;
import com.rbs.entity.Student;
import com.rbs.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;
    public List<Student> getAllStudent()
    {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }
    public Student getStudentById(int id)
    {
        return studentRepository.findById(id).get();
    }
    public void saveOrUpdate(Student student)
    {
        studentRepository.save(student);
    }
    public void delete(int id)
    {
        studentRepository.deleteById(id);
    }
}