package com.surepay.reports.factories;

import com.surepay.reports.validationrules.BalanceCheckValidation;
import com.surepay.reports.validationrules.UniqueTransactionReferencesValidationRule;
import com.surepay.reports.interfaces.IValidationRule;
import java.io.File;

public class ValidationFactory {
  public IValidationRule validate(File currentFile)
  {
    if (currentFile == null)
      return null;
    else if(currentFile.getName().endsWith(".csv")) {
      return new BalanceCheckValidation();
    }
    else if(currentFile.getName().endsWith(".json"))
    {
      return new UniqueTransactionReferencesValidationRule();
    }
    else {
      throw new IllegalArgumentException("File has some issues  " + currentFile.getName());
    }
  }

}
