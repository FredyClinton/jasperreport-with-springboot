package therooster.JRGStudentCard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import therooster.JRGStudentCard.entite.ScoreCard;
import therooster.JRGStudentCard.repositorie.ScoreCardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreCardService {
    private final ScoreCardRepository scoreCardRepository;

    public List<ScoreCard> getAllScoreCards() {
        return scoreCardRepository.findAll();
    }

    public List<ScoreCard>  getScoreCardByStudentId(Integer rollNumber) {
        return scoreCardRepository.findByStudent_RollNumber(rollNumber);
    }
}
