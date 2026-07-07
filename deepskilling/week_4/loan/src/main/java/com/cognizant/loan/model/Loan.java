package com.cognizant.loan.model;

public record Loan(String number, String type, int loan, int emi, int tenure) {
}
