package therooster.JRGStudentCard.controller;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import therooster.JRGStudentCard.entite.Student;
import therooster.JRGStudentCard.service.StudentService;
import therooster.JRGStudentCard.utils.ReportUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/reports")
@RequiredArgsConstructor
public class ReportController {
    private final StudentService studentService;


    @GetMapping("/student/{rollNumber}")
    public ResponseEntity<byte[]> generateStudentReport(@PathVariable Integer rollNumber)  throws IOException {
        try{
            // Fetch student with givent roll number

            List<Student> students = null;
            if(rollNumber != null){
                students = List.of(studentService.getStudentById(rollNumber));
            }else {
                students.add(new Student());
            }

            // Path to the compiled.jasper file
            String jasperPath = new File("src/main/resources/reports/StudentCardReport.jasper").getAbsolutePath();

            // Parameters for the report
            HashMap<String, Object> parameters = new HashMap<>();
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students.get(0).getScroreCard());
            parameters.put("TABLE_DATA_SOURCE", dataSource);

            // Generated the PDF report
            byte[] pdfData = ReportUtil.generateReport(students, jasperPath, parameters);

            // Return the PDF as a response
            return  ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=student_report.pdf")
                    .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                    .body(pdfData);

        } catch (JRException e) {
            throw new RuntimeException( "Error generated  the ll  compilation report", e);
        }
    }



}
