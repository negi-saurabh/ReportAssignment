package com.surepay.reports.processors;

import com.surepay.reports.exceptions.CSVFileReadException;
import com.surepay.reports.exceptions.JSONFileReadException;
import com.surepay.reports.interfaces.IFileReader;
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
  IFileReader fileReader;
  IReporter reporter;
  List<IValidationRule> validatorsList;

  public FailedRecordProcessor(IFileReader fileReader, IReporter reporter, List<IValidationRule> validatorsList) {
    this.fileReader = fileReader;
    this.reporter = reporter;
    this.validatorsList = validatorsList;
  }

  @Override
  public void process() throws JSONFileReadException, CSVFileReadException {
    List<TransactionRecord> allRecords = fileReader.readFile();
    for (int i = 0; i < allRecords.size(); i++) {
      TransactionRecord currentRecord = allRecords.get(i);
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
