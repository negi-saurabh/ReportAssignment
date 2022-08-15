package com.surepay.reports;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.exceptions.CSVFileReadException;
import com.surepay.reports.exceptions.JSONFileReadException;
import com.surepay.reports.exceptions.WrongFileExtensionException;
import com.surepay.reports.exceptions.WrongOutputReportFormatException;
import com.surepay.reports.exceptions.WrongProcessorException;
import com.surepay.reports.factories.ProcessorFactory;
import com.surepay.reports.factories.ReaderFactory;
import com.surepay.reports.factories.ReporterGeneratorFactory;
import com.surepay.reports.factories.ValidatorFactory;
import com.surepay.reports.interfaces.IFileReader;
import com.surepay.reports.interfaces.IProcessor;
import com.surepay.reports.interfaces.IReporter;
import com.surepay.reports.interfaces.IValidationRule;
import com.surepay.reports.utilities.Constants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Given a file with bank transaction records, create a validation service
 * that reads the file and gives a report with the invalid records.
 */

public class ReportGeneratorService {

  public static void main(String[] args) throws JSONFileReadException {
    List<String> listOfValidations = new ArrayList<>();
    listOfValidations.add(Constants.VALIDATION_UNIQUE_REF);
    listOfValidations.add(Constants.VALIDATION_BALANCE_CHECK);

    try {
      File file = new File(Constants.DATA_FILE);

      IFileReader fileReader = ReaderFactory.getReader(file);
      List<TransactionRecord> allRecords = fileReader.readFile(file);

      IReporter reporter = ReporterGeneratorFactory.getGenerator(Constants.REPORT_TYPE_CSV);
      List<IValidationRule> validatorsList = new ArrayList<>();

      for (int i = 0; i < listOfValidations.size(); i++) {
        IValidationRule validator = ValidatorFactory.getValidator(listOfValidations.get(i));
        validatorsList.add(validator);
      }

      IProcessor processor = ProcessorFactory.getProcessor(Constants.FAILED_RECORD_PROCESSOR, allRecords, reporter, validatorsList);
      processor.process();
      processor.generateReport(Constants.DATA_FILE);

    } catch (IOException | WrongFileExtensionException | WrongOutputReportFormatException | WrongProcessorException | CSVFileReadException ex) {
          ex.printStackTrace();
    }
  }
}
