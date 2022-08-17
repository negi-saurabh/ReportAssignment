package com.surepay.reports.factories;

import com.surepay.reports.exceptions.WrongProcessorException;
import com.surepay.reports.interfaces.IFileReader;
import com.surepay.reports.interfaces.IProcessor;
import com.surepay.reports.interfaces.IReporter;
import com.surepay.reports.interfaces.IValidationRule;
import com.surepay.reports.processors.FailedRecordProcessor;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Returns processor based on processorType Input
 */
public class ProcessorFactory {
  private static final Logger logger = LogManager.getLogger(ProcessorFactory.class);

  public static IProcessor getProcessor(String processorType, IFileReader allCollectedRecords, IReporter reporter, List<IValidationRule> validatorsList)
      throws WrongProcessorException {

    logger.log(Level.INFO, "Inside ProcessorFactory");
    IProcessor processor = null;
    // we can change method definition and instead of passing 4 we can pass 1 parameter
    switch (processorType) {
      case "FAILED_RECORD_PROCESSOR" :
        processor = new FailedRecordProcessor(allCollectedRecords,  reporter, validatorsList);
        break;
      case "PASSED_RECORD_PROCESSOR" :
        // implementation
        break;
      default:
        throw new WrongProcessorException("The provided processor "+ processorType + " does not exist");
    }
    return processor;
  }
}
