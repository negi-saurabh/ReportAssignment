package com.surepay.reports.factories;

import com.surepay.reports.exceptions.WrongFileExtensionException;
import com.surepay.reports.interfaces.IFileReader;
import com.surepay.reports.readers.CSVFileReader;
import com.surepay.reports.readers.JSONFileReader;
import java.io.File;
import java.io.FileNotFoundException;


//can make static factory
public class ReaderFactory {

  public static IFileReader getReader(File currentFile)
      throws WrongFileExtensionException, FileNotFoundException {
    if (currentFile != null) {
      String fileExtension = currentFile.getName().toLowerCase().split(".")[1];
      switch (fileExtension){
        case "csv" :
          System.out.println("CSV");
          return new CSVFileReader();
          case "json" :
          System.out.println("JSON");
          return new JSONFileReader();
         default :
           throw new WrongFileExtensionException("The given file extension is not supported" + fileExtension);
      }
    } else{
        throw new FileNotFoundException(currentFile.getName());
    }
  }
}
