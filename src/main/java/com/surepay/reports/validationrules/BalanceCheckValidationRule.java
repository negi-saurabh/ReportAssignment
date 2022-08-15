package com.surepay.reports.validationrules;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IValidationRule;
import java.util.ArrayList;
import java.util.List;

public class BalanceCheckValidationRule implements IValidationRule {

  private String reasonMessage = "The Final Balance is wrong";
  private List<String> referenceList = new ArrayList<>();

  @Override
  public boolean isValid(TransactionRecord record) {
    if(referenceList.contains(record.getReference())){
      return false;
    }else{
      referenceList.add(record.getReference());
      return true;
    }
  }

  public String getReason() {
    return reasonMessage;
  }
}
