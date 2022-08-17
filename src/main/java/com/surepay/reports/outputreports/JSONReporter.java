package com.surepay.reports.outputreports;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IReporter;
import java.util.Map;

/*
 * Creates output report in as an JSON
 * filled with failed records
 */

public class JSONReporter implements IReporter {

  private String outputFilePath;
  public JSONReporter(String outputFilePath){
    this.outputFilePath = outputFilePath;
  }
  @Override
  public void generateReport(Map<TransactionRecord, String> failedRecords) {
        // write implementation
  }
}
