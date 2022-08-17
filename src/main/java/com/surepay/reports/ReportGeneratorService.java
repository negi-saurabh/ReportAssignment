package com.surepay.reports;

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
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReportGeneratorService {

  private static final Logger logger = LogManager.getLogger(ReportGeneratorService.class);

  public static void main(String[] args) throws JSONFileReadException {
    List<String> listOfValidations = new ArrayList<>();
    listOfValidations.add(Constants.VALIDATION_UNIQUE_REF);
    listOfValidations.add(Constants.VALIDATION_BALANCE_CHECK);

    try {
      File file = new File(Constants.JSON_DATA_FILE);
      logger.log(Level.INFO, "getting file reader based on provided file type");
      IFileReader fileReader = ReaderFactory.getReader(file);

      logger.log(Level.INFO, "getting reporter to get the format of output file");
      IReporter reporter = ReporterGeneratorFactory.getGenerator(Constants.REPORT_TYPE_CSV, Constants.OUTPUT_FILE_PATH);

      logger.log(Level.INFO, "getting all the validations that are need to be applied");
      List<IValidationRule> validatorsList = new ArrayList<>();
      for (int i = 0; i < listOfValidations.size(); i++) {
        IValidationRule validator = ValidatorFactory.getValidator(listOfValidations.get(i));
        validatorsList.add(validator);
      }

      logger.log(Level.INFO, Constants.FAILED_RECORD_PROCESSOR+ "has been chosen as processor");
      IProcessor processor = ProcessorFactory.getProcessor(Constants.FAILED_RECORD_PROCESSOR, fileReader, reporter, validatorsList);
      processor.process();
      processor.generateReport();

      // logger success
    } catch (IOException | WrongFileExtensionException | WrongOutputReportFormatException | WrongProcessorException | CSVFileReadException ex) {
      logger.log(Level.ERROR, "Exception", ex.getMessage());
      ex.printStackTrace();
    }
  }
}
