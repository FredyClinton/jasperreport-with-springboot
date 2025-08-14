package therooster.JRGStudentCard.utils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportUtil {
    public static  <T> byte[] generateReport(
            List<T> data,
            String JasperPath,
            Map<String, Object> parameters
    ) throws JRException , IOException {
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(JasperPath);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);


        if(parameters == null){
            parameters = new HashMap<>();
        }
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ){
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            return outputStream.toByteArray();
        }
    }
}
