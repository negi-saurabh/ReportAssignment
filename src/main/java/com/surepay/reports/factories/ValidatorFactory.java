package com.surepay.reports.factories;

import com.surepay.reports.exceptions.CSVFileReadException;
import com.surepay.reports.exceptions.JSONFileReadException;
import com.surepay.reports.exceptions.WrongFileExtensionException;
import com.surepay.reports.exceptions.WrongOutputReportFormatException;
import com.surepay.reports.exceptions.WrongProcessorException;
import com.surepay.reports.interfaces.IFileReader;
import com.surepay.reports.interfaces.IProcessor;
import com.surepay.reports.interfaces.IReporter;
import com.surepay.reports.utilities.Constants;
import com.surepay.reports.validationrules.BalanceCheckValidationRule;
import com.surepay.reports.validationrules.UniqueTransactionReferencesValidationRule;
import com.surepay.reports.interfaces.IValidationRule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidatorFactory {

  public static IValidationRule getValidator(String rule) {
    IValidationRule validationRule = null;
    switch (rule) {
      case "UNIQUE_REF" :
        validationRule = new UniqueTransactionReferencesValidationRule();
        break;
      case "BALANCE_CHECK" :
        validationRule = new BalanceCheckValidationRule();
        break;
    }
    return validationRule;
  }


}
