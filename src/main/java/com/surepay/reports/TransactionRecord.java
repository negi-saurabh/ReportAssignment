package com.surepay.reports;

import java.math.BigDecimal;

public class TransactionRecord {
  private String reference;
  private String accountNumber;
  private String description;
  private BigDecimal startBalance;
  private BigDecimal mutation;
  private BigDecimal endBalance;

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getStartBalance() {
    return startBalance;
  }

  public void setStartBalance(BigDecimal startBalance) {
    this.startBalance = startBalance;
  }

  public BigDecimal getMutation() {
    return mutation;
  }

  public void setMutation(BigDecimal mutation) {
    this.mutation = mutation;
  }

  public BigDecimal getEndBalance() {
    return endBalance;
  }

  public void setEndBalance(BigDecimal endBalance) {
    this.endBalance = endBalance;
  }

  public TransactionRecord(String reference, String accountNumber, String description,
      BigDecimal startBalance, BigDecimal mutation, BigDecimal endBalance) {
    this.reference = reference;
    this.accountNumber = accountNumber;
    this.description = description;
    this.startBalance = startBalance;
    this.mutation = mutation;
    this.endBalance = endBalance;
  }
}
