package com.surepay.reports.factories;

import com.surepay.reports.classes.BalanceCheckValidation;
import com.surepay.reports.classes.UniqueTransactionReferencesValidation;
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
      return new UniqueTransactionReferencesValidation();
    }
    else {
      throw new IllegalArgumentException("File has some issues  " + currentFile.getName());
    }
  }

}
