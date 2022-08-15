package com.surepay.reports.validationrules;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IValidationRule;

public class UniqueTransactionReferencesValidationRule implements IValidationRule {
  private String reasonMessage = "Wrong Transaction Reference";

  @Override
  public boolean isValid(TransactionRecord record) {
    return false;
  }

  public String getReason() {
    return reasonMessage;
  }
}
