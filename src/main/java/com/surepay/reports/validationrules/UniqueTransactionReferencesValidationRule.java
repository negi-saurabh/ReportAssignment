package com.surepay.reports.validationrules;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IValidationRule;
import java.util.HashSet;
import java.util.Set;

/*
 * Checks if the reference value of transaction is Unique
 * if encounters another value with same reference it flags
 * the second transaction as incorrect record
 */

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
