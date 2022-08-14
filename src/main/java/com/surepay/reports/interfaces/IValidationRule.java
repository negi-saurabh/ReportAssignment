package com.surepay.reports.interfaces;

import com.surepay.reports.TransactionRecord;

public interface IValidationRule {

  boolean isValid(TransactionRecord record);

}
