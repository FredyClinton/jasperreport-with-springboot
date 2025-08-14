package therooster.JRGStudentCard.entite;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScoreCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private  String subjectName;
    private Double totalMarks;
    private Double marksObtained;

    @ManyToOne
     @JoinColumn(name = "roll_number", nullable = false)
    private  Student student;
}
