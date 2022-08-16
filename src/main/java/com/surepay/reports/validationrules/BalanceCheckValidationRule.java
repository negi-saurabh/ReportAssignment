package com.surepay.reports.validationrules;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IValidationRule;
import java.util.ArrayList;
import java.util.List;

public class BalanceCheckValidationRule implements IValidationRule {


  private String reasonMessage = "Wrong Transaction Reference";


  @Override
  public boolean isValid(TransactionRecord record) {
    if(record.getEndBalance() == record.getStartBalance()+record.getMutation()){
      return true;
    }else{
      return false;
    }
  }

  public String getReason() {
    return reasonMessage;
  }
}
