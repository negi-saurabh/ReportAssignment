package com.surepay.reports.validationrules;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IValidationRule;
import java.util.HashSet;
import java.util.Set;

public class UniqueTransactionReferencesValidationRule implements IValidationRule {
  private final String reasonMessage = "Wrong Transaction Reference";
  private Set<String> referenceSet = new HashSet<>();

  @Override
  public boolean isValid(TransactionRecord record) {
    if(!referenceSet.add(record.getReference())){
      return false;
    }else{
      return true;
    }
  }

  @Override
  public String getReason() {
    return reasonMessage;
  }
}
