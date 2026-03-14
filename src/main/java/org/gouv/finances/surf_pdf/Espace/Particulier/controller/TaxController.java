package org.gouv.finances.surf_pdf.Espace.Particulier.controller;

import org.gouv.finances.surf_pdf.Espace.Particulier.model.TaxDeclaration;
import org.gouv.finances.surf_pdf.Espace.Particulier.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaxController {
    @Autowired
    private TaxService taxService;

    // Mock data the tutorial
    private TaxDeclaration getMockData(){
        return new TaxDeclaration("Jean Dupont", "1 02 75 92 123 456", 45000.0, 5200.0, "2023");
    }

    @GetMapping("/tax-info")
    public String viewTaxInfo(Model model){
        model.addAttribute("tax", getMockData());
        return "taxView";
    }

    @GetMapping("/tax-download")
    public ResponseEntity<byte[]> downloadPdf() throws Exception {
        byte[] pdfContent = taxService.generateTaxPdf(getMockData());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);

        // "inline" opens it in the browser tab
        // "attachment" forces a direct download
        headers.setContentDispositionFormData("filename", "declaration_imports_2023.pdf");

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }
}
