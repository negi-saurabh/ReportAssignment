package com.surepay.reports.factories;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IProcessor;
import com.surepay.reports.interfaces.IReporter;
import com.surepay.reports.interfaces.IValidationRule;
import com.surepay.reports.processors.FailedRecordProcessor;
import java.util.List;

public class ProcessorFactory {

  public static IProcessor getProcessor(String proc,
      List<TransactionRecord> allCollectedRecords, IReporter reporter,
      List<IValidationRule> validatorsList) {
    IProcessor processor = null;
    switch (proc) {
      case "BASIC_PROCESSOR" :
        processor = new FailedRecordProcessor(allCollectedRecords,  reporter, validatorsList);
        break;
//      case default:
//        break;
//        //throw exception

    }
    return processor;
  }

}
