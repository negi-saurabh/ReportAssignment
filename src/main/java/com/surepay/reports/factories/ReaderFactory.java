package com.surepay.reports.factories;

import com.surepay.reports.interfaces.IFileReader;
import com.surepay.reports.classes.CSVFileReader;
import com.surepay.reports.classes.JSONFileReader;
import java.io.File;

public class ReaderFactory {
  public IFileReader readFile(File currentFile)
  {
    if (currentFile == null)
      return null;
    else if(currentFile.getName().endsWith(".csv")) {
      return new CSVFileReader();
    }
    else if(currentFile.getName().endsWith(".json"))
    {
      return new JSONFileReader();
    }
   else {
      throw new IllegalArgumentException("File has some issues  " + currentFile.getName());
    }
  }
}
