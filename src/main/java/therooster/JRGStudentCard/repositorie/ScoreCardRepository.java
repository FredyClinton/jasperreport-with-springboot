package therooster.JRGStudentCard.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import therooster.JRGStudentCard.entite.ScoreCard;

import java.util.List;

public interface ScoreCardRepository extends JpaRepository<ScoreCard, Integer> {

    List<ScoreCard> findByStudent_RollNumber(Integer studentRollNumber);
}
