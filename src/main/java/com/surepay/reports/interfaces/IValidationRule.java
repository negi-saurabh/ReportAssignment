package com.surepay.reports.interfaces;

import com.surepay.reports.beans.TransactionRecord;

public interface IValidationRule {
  String getReason();
  boolean isValid(TransactionRecord record);

}
