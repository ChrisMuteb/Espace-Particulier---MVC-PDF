package org.gouv.finances.surf_pdf.Espace.Particulier.model;

/**
 * POJO hold the user's data
 * Jasper will read the fields from this object to fill the PDF
 */
public class TaxDeclaration {
    private String fullName;
    private String fiscalNumber;
    private Double annualIncome;
    private Double taxAmount;
    private String year;

    public TaxDeclaration() {
    }

    public TaxDeclaration(String fullName, String fiscalNumber, Double annualIncome, Double taxAmount, String year) {
        this.fullName = fullName;
        this.fiscalNumber = fiscalNumber;
        this.annualIncome = annualIncome;
        this.taxAmount = taxAmount;
        this.year = year;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFiscalNumber() {
        return fiscalNumber;
    }

    public void setFiscalNumber(String fiscalNumber) {
        this.fiscalNumber = fiscalNumber;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
