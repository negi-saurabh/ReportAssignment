package com.surepay.reports.reportformats;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IReporter;
import java.util.Map;

public class ReportAsJSON implements IReporter {

  public ReportAsJSON(String savePath){

  }
  @Override
  public void generateReport(Map<TransactionRecord, String> failedRecords, String path) {
        // write implementation
  }
}
