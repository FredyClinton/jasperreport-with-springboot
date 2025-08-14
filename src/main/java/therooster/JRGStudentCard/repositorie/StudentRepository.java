package therooster.JRGStudentCard.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import therooster.JRGStudentCard.entite.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
