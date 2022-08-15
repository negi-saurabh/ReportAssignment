package com.surepay.reports.interfaces;

import com.surepay.reports.beans.TransactionRecord;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface IReporter {

  void generateReport(Map<TransactionRecord, String> failedRecords, String path)
      throws IOException;
}
