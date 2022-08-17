package com.surepay.reports.factories;

import com.surepay.reports.interfaces.IValidationRule;
import com.surepay.reports.validationrules.BalanceCheckValidationRule;
import com.surepay.reports.validationrules.UniqueTransactionReferencesValidationRule;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Returns validation that can be applied based on input
 */

public class ValidatorFactory {
  private static final Logger logger = LogManager.getLogger(ValidatorFactory.class);

  public static IValidationRule getValidator(String rule) {
    logger.log(Level.INFO, "Inside ValidatorFactory");
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
