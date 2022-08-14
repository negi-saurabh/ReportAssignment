package com.surepay.reports.classes;

import com.surepay.reports.TransactionRecord;
import com.surepay.reports.interfaces.IFileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class CSVFileReader implements IFileReader {

  @Override
  public List<TransactionRecord> readFile(File file) {
    System.out.println("Inside CSVFileReader class");
    try {
      // generate the report
      // call the validation service inside generate report
      String line = "";
      String splitBy = ",";
      BufferedReader br = new BufferedReader(new FileReader(file));
      while ((line = br.readLine()) != null)   //returns a Boolean value
      {
        String[] transaction = line.split(splitBy);    // use comma as separator
        System.out.println(
            "Employee [First Name=" + transaction[0] + ", Last Name=" + transaction[1]
                + ", Designation=" + transaction[2] + ", Contact=" + transaction[3] + ", Salary= "
                + transaction[4] + ", City= " + transaction[5] + "]");
      }
    }
    catch ( Exception e){
      e.printStackTrace();
    }
    return null;
  }
}
