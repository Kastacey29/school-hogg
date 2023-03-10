package ru.hogwarts.schoolhog.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.hogwarts.schoolhog.model.Faculty;
import ru.hogwarts.schoolhog.model.Student;
import ru.hogwarts.schoolhog.repositories.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long studentID) {
        return studentRepository.findById(studentID).get();
    }

    public Student updateStudent(Long id, Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);

    }

    public Collection<Student> getStudentsByAge(Integer studentAge) {
        return studentRepository.findStudentByAge(studentAge);
    }

    public Collection<Student> findStudentsByAgeBetween(Integer minAge, Integer maxAge) {
        return studentRepository.findStudentsByAgeBetween(minAge, maxAge);
    }

    public Collection<Student> findStudentsByFacultyId(Long id) {
        return studentRepository.findStudentsByFacultyId(id);
    }

    public Faculty getFacultyByStudentId(Long id) {
        return getStudentById(id).getFaculty();
    }

    public Integer findCountOfStudent() {
        return studentRepository.findCountOfStudent();
    }

    public Double findAverageAge() {
        return studentRepository.findAverageAge();
    }

    public Collection<Student> findFiveLastStudents() {
        return studentRepository.findFiveLastStudents();
    }
}
