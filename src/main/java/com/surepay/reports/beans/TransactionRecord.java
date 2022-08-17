package com.surepay.reports.beans;

/*
 * A simple POJO
 */

public class TransactionRecord {
  private String reference;
  private String accountNumber;
  private String description;
  private Double startBalance;
  private Double mutation;
  private Double endBalance;

  public String getReference() {
    return reference;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String getDescription() {
    return description;
  }

  public Double getStartBalance() {
    return startBalance;
  }

  public Double getMutation() {
    return mutation;
  }

  public Double getEndBalance() {
    return endBalance;
  }

  public TransactionRecord(String reference, String accountNumber, String description,
      Double startBalance, Double mutation, Double endBalance) {
    this.reference = reference;
    this.accountNumber = accountNumber;
    this.description = description;
    this.startBalance = startBalance;
    this.mutation = mutation;
    this.endBalance = endBalance;
  }
}
