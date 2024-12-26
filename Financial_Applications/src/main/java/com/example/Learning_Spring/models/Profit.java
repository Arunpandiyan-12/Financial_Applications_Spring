package com.example.Learning_Spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profit_reports")
public class Profit {

    @Id
    private String id;
    private int year;
    private int quarter;
    private int halfYear;
    private String projectId;
    private double companyProfit;
    private double taxPaid;

    // Getters and Setters

    public Profit(double companyProfit, int halfYear, String id, String projectId, int quarter, double taxPaid, int year) {
        this.companyProfit = companyProfit;
        this.halfYear = halfYear;
        this.id = id;
        this.projectId = projectId;
        this.quarter = quarter;
        this.taxPaid = taxPaid;
        this.year = year;
    }

    public double getCompanyProfit() {
        return companyProfit;
    }

    public void setCompanyProfit(double companyProfit) {
        this.companyProfit = companyProfit;
    }

    public int getHalfYear() {
        return halfYear;
    }

    public void setHalfYear(int halfYear) {
        this.halfYear = halfYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public double getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(double taxPaid) {
        this.taxPaid = taxPaid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Profit() {
    }
}

