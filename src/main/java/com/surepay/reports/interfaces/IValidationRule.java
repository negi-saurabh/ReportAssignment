package com.surepay.reports.interfaces;

import com.surepay.reports.beans.TransactionRecord;

public interface IValidationRule {

  boolean isValid(TransactionRecord record);

}
