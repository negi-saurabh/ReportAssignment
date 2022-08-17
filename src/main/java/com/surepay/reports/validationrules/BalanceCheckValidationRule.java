package com.surepay.reports.validationrules;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IValidationRule;

/*
 * Checks if the end value after transaction is correct
 * Based on the start value and the mutation involved
 */

public class BalanceCheckValidationRule implements IValidationRule {
  private final String reasonMessage = "The Final Balance is wrong";

  @Override
  public boolean isValid(TransactionRecord record) {
    if(getFormat(record.getEndBalance()).equals(getFormat(record.getStartBalance()+record.getMutation()))){
      return true;
    }else{
      return false;
    }
  }

  private String getFormat(Double amount) {
    return String.format("%.2f",amount);
  }

  @Override
  public String getReason() {
    return reasonMessage;
  }
}
