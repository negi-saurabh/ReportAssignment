package com.surepay.reports.factories;

import com.surepay.reports.exceptions.WrongFileExtensionException;
import com.surepay.reports.interfaces.IFileReader;
import com.surepay.reports.readers.CSVFileReader;
import com.surepay.reports.readers.JSONFileReader;
import java.io.File;
import java.io.FileNotFoundException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReaderFactory {
  private static final Logger logger = LogManager.getLogger(ReaderFactory.class);

  public static IFileReader getReader(File currentFile)
      throws WrongFileExtensionException, FileNotFoundException {
    logger.log(Level.INFO, "Inside ReaderFactory");
    if (currentFile != null) {
      String fileExtension = currentFile.getName().toLowerCase().split("\\.")[1];
      switch (fileExtension){
        case "csv" :
          System.out.println("CSV");
          return new CSVFileReader(currentFile);
        case "json" :
          System.out.println("JSON");
          return new JSONFileReader(currentFile);
        default :
          throw new WrongFileExtensionException("The given file extension "+ fileExtension +  " is not supported" );
      }
    } else{
      throw new FileNotFoundException(currentFile.getName());
    }
  }
}
