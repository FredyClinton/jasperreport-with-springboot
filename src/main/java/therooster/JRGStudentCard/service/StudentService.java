package therooster.JRGStudentCard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import therooster.JRGStudentCard.entite.Student;
import therooster.JRGStudentCard.repositorie.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public  Student getStudentById(Integer rollNumber){
        return studentRepository.findById(rollNumber).orElseThrow(
                () -> new RuntimeException("Student with roll number " + rollNumber + " not found")
        );
    }

}
