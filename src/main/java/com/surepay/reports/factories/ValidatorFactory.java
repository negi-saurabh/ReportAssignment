package com.surepay.reports.factories;

import com.surepay.reports.validationrules.UniqueTransactionReferencesValidationRule;
import com.surepay.reports.interfaces.IValidationRule;

public class ValidatorFactory {

  public static IValidationRule getValidator(String rule) {
    IValidationRule validationRule = null;
    switch (rule) {
      case "UNIQUE_REF" :
        validationRule = new UniqueTransactionReferencesValidationRule();
    }
    return validationRule;
  }
}
