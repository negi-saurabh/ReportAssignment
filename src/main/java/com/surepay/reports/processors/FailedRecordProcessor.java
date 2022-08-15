package com.surepay.reports.processors;

import com.surepay.reports.interfaces.IProcessor;
import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IReporter;
import com.surepay.reports.interfaces.IValidationRule;
import com.surepay.reports.reportformats.ReportAsExcel;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FailedRecordProcessor implements IProcessor {

  Map<TransactionRecord, String> failedRecords = new HashMap<>();
  List<TransactionRecord> allCollectedRecords;
  IReporter reporter;
  List<IValidationRule> validatorsList;

  public FailedRecordProcessor(List<TransactionRecord> allCollectedRecords, IReporter reporter, List<IValidationRule> validatorsList) {
    this.allCollectedRecords = allCollectedRecords;
    this.reporter = reporter;
    this.validatorsList = validatorsList;
  }

  @Override
  public void process() {
    for (int i = 0; i < allCollectedRecords.size(); i++) {
      TransactionRecord currentRecord = allCollectedRecords.get(i);
      for (int j = 0; j < validatorsList.size() ; j++) {
        IValidationRule rule = validatorsList.get(j);
        if(!rule.isValid(currentRecord)) {
          failedRecords.put(currentRecord, "Wrong Balance");
        }
      }
    }
  }

  @Override
  public void generateReport(String path) throws IOException {
    reporter.generateReport(failedRecords, path);
  }
}
