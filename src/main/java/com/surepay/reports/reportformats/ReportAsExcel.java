package com.surepay.reports.reportformats;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IReporter;
import java.util.Map;

public class ReportAsExcel implements IReporter {

  @Override
  public void generateReport(Map<TransactionRecord, String> failedRecords, String path) {

  }
}
