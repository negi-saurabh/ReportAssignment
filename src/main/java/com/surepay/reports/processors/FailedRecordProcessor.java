package com.surepay.reports.processors;

import com.surepay.reports.exceptions.CSVFileReadException;
import com.surepay.reports.exceptions.JSONFileReadException;
import com.surepay.reports.interfaces.IFileReader;
import com.surepay.reports.interfaces.IProcessor;
import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IReporter;
import com.surepay.reports.interfaces.IValidationRule;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FailedRecordProcessor implements IProcessor {

  Map<TransactionRecord, String> failedRecords = new HashMap<>();
  private IFileReader fileReader;
  private IReporter reporter;
  private List<IValidationRule> validatorsList;

  public FailedRecordProcessor(IFileReader fileReader, IReporter reporter, List<IValidationRule> validatorsList) {
    this.fileReader = fileReader;
    this.reporter = reporter;
    this.validatorsList = validatorsList;
  }

  @Override
  public void process() throws JSONFileReadException, CSVFileReadException {

    //logger
    List<TransactionRecord> allRecords = fileReader.readFile();
    for (int i = 0; i < allRecords.size(); i++) {
      TransactionRecord currentRecord = allRecords.get(i);
      for (int j = 0; j < validatorsList.size() ; j++) {
        IValidationRule rule = validatorsList.get(j);
        if(!rule.isValid(currentRecord)) {
          // logger
          failedRecords.put(currentRecord, rule.getReason());
        }
      }
    }
  }

  @Override
  public void generateReport() throws IOException {
    reporter.generateReport(failedRecords);
  }
}
