package com.surepay.reports;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.exceptions.WrongFileExtensionException;
import com.surepay.reports.factories.ProcessorFactory;
import com.surepay.reports.factories.ReaderFactory;
import com.surepay.reports.factories.ReporterGeneratorFactory;
import com.surepay.reports.factories.ValidatorFactory;
import com.surepay.reports.interfaces.IFileReader;
import com.surepay.reports.interfaces.IProcessor;
import com.surepay.reports.interfaces.IReporter;
import com.surepay.reports.interfaces.IValidationRule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Given a file with bank transaction records, create a validation service
 * that reads the file and gives a report with the invalid records.
 */

public class ReportGeneratorService {

  private static final String DATA_FILE = "./files/records.csv";
  private static final String REPORT_TYPE = "EXCEL";

  public static void main(String[] args) {

    try {
        File file = new File(DATA_FILE);
        IFileReader fileReader = ReaderFactory.getReader(file);
        List<TransactionRecord> allRecords = fileReader.readFile(file);
        IReporter reporter = ReporterGeneratorFactory.getGenerator(REPORT_TYPE);
        List<IValidationRule> validatorsList = new ArrayList<>();
        IValidationRule validator = ValidatorFactory.getValidator("UNIQUE_REF");
        validatorsList.add(validator);
        IProcessor processor = ProcessorFactory.getProcessor("BASIC_PROCESSOR", allRecords, reporter, validatorsList);
        processor.process();
        processor.generateReport(DATA_FILE);
    } catch (WrongFileExtensionException | IOException ex) {
      ex.printStackTrace();
    }
  }
}
