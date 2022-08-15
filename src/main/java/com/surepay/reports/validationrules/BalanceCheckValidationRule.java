package com.surepay.reports.validationrules;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IValidationRule;

public class BalanceCheckValidationRule implements IValidationRule {

  private String reasonMessage = "The Final Balance is wrong";

  @Override
  public boolean isValid(TransactionRecord record) {
    return false;
  }

  public String getReason() {
    return reasonMessage;
  }
}
