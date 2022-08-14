package com.surepay.reports.interfaces;

import com.surepay.reports.TransactionRecord;
import java.util.Map;

public interface IReport {

  void generateReport(Map<TransactionRecord, String> failedRecords);
}
