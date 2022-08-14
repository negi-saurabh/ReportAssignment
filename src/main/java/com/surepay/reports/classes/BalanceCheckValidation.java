package com.surepay.reports.classes;

import com.surepay.reports.TransactionRecord;
import com.surepay.reports.interfaces.IValidationRule;

public class BalanceCheckValidation implements IValidationRule {

  private String failedValidation = "Wrong Balance";

  @Override
  public boolean isValid(TransactionRecord record) {
    return false;
  }

  public String getFailedValidation() {
    return failedValidation;
  }
}
