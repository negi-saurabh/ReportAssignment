package com.surepay.reports;

import com.surepay.reports.classes.BalanceCheckValidation;
import com.surepay.reports.classes.ReportAsExcel;
import com.surepay.reports.classes.ReportAsJSON;
import com.surepay.reports.classes.UniqueTransactionReferencesValidation;
import com.surepay.reports.factories.ReaderFactory;
import com.surepay.reports.factories.ValidationFactory;
import com.surepay.reports.interfaces.IFileReader;
import com.surepay.reports.interfaces.IReport;
import com.surepay.reports.interfaces.IValidationRule;
import com.surepay.reports.utilities.DataFilesReader;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a file with bank transaction records, create a validation service
 * that reads the file and gives a report with the invalid records.
 */

public class ReportGeneratorService {

  private static final String DATA_FILES_PATH = "./files";

  public static void main(String[] args) {
    Map<TransactionRecord, String> failedRecords = new HashMap<>();
    try {
      List<File> dataFiles = DataFilesReader.getFilesFromPath(DATA_FILES_PATH);
      for (int i = 0; i < dataFiles.size() ; i++) {
        File currentFile = dataFiles.get(i);
        ReaderFactory readerFactory = new ReaderFactory();
        IFileReader fileReader = readerFactory.readFile(currentFile);
        List<TransactionRecord>  allRecords =  fileReader.readFile(currentFile);

        for (int j = 0; j < allRecords.size(); j++) {
          TransactionRecord currentRecord = allRecords.get(i);
          IValidationRule rule1 = new BalanceCheckValidation();
          IValidationRule rule2 = new UniqueTransactionReferencesValidation();
          if(!rule1.isValid(currentRecord)){
            failedRecords.put(currentRecord, "Wrong Balance");

          }if(!rule2.isValid(currentRecord)){
            failedRecords.put(currentRecord, "Wrong Transaction Reference");
          }

        }

        new ReportAsExcel().generateReport(failedRecords);
        new ReportAsJSON().generateReport(failedRecords);
      }
      // strategy pattern
      // ReporterGenerator reporter = ReporterGenerator.getInstance().getGenerator();
      //Report report = reporter.generateReport();
     // Validators validator = ReporterGenerator.getInstance().getGenerator();
     // Processor processRules = ProcessorFactory.getInstance().getProcessor(reporter);
     // Report report = processRules.process();
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
}
