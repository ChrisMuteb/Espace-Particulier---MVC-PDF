package org.gouv.finances.surf_pdf.Espace.Particulier.service;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.gouv.finances.surf_pdf.Espace.Particulier.model.TaxDeclaration;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class TaxService {

    public byte[] generateTaxPdf(TaxDeclaration data) throws Exception {
        // 1. Load the compiled Jasper file
        InputStream reportStream = getClass().getResourceAsStream("/reports/tax_report.jasper");

        // 2. Map the data to Jasper's "DataSource"
        // We put our object in a list because Jasper expects a Collection
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(List.of(data));

        // 3. Add parameters (Title, logo, etc.)
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fullName", data.getFullName());

        // 4. Fill the report
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, parameters, dataSource);

        // 5. Export to PDF byte array
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
