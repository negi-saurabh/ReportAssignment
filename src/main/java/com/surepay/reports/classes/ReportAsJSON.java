package com.surepay.reports.classes;

import com.surepay.reports.TransactionRecord;
import com.surepay.reports.interfaces.IReport;
import java.util.Map;

public class ReportAsJSON implements IReport {

  @Override
  public void generateReport(Map<TransactionRecord, String> failedRecords) {

  }
}
