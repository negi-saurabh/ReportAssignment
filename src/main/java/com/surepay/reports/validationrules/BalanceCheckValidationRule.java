package com.surepay.reports.validationrules;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IValidationRule;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BalanceCheckValidationRule implements IValidationRule {
  private final String reasonMessage = "The Final Balance is wrong";

  @Override
  public boolean isValid(TransactionRecord record) {
    if(getInFormat(record.getEndBalance()).equals(getInFormat(record.getStartBalance()+record.getMutation()))){
      return true;
    }else{
      return false;
    }
  }

  private String getInFormat(Double amount) {
    return String.format("%.2f",amount);
  }

  @Override
  public String getReason() {
    return reasonMessage;
  }
}
