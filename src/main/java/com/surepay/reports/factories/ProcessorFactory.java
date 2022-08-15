package com.surepay.reports.factories;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.exceptions.WrongProcessorException;
import com.surepay.reports.interfaces.IProcessor;
import com.surepay.reports.interfaces.IReporter;
import com.surepay.reports.interfaces.IValidationRule;
import com.surepay.reports.processors.FailedRecordProcessor;
import java.util.List;

public class ProcessorFactory {

  public static IProcessor getProcessor(String processorType, List<TransactionRecord> allCollectedRecords, IReporter reporter, List<IValidationRule> validatorsList)
      throws WrongProcessorException {
    IProcessor processor = null;
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
