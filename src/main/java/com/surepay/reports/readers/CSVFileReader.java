package com.surepay.reports.readers;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.exceptions.CSVFileReadException;
import com.surepay.reports.interfaces.IFileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader implements IFileReader {
  private File file;
  public CSVFileReader(File file){
    this.file = file;
  }
  @Override
  public List<TransactionRecord> readFile() throws CSVFileReadException {
    List<TransactionRecord> transactionRecordList = new ArrayList<>();
    try {
      String line = "";
      String splitBy = ",";
      BufferedReader br = new BufferedReader(new FileReader(file));
      while ((line = br.readLine()) != null)
      {
        String[] transaction = line.split(splitBy);
        TransactionRecord transactionRecord = new TransactionRecord(transaction[0], transaction[1], transaction[2],
                                                Double.parseDouble(transaction[3]),  Double.parseDouble(transaction[4]),  Double.parseDouble(transaction[5]));
        transactionRecordList.add(transactionRecord);
      }
    }
    catch (Exception e){
      throw new CSVFileReadException("Exception while reading the csv file: " + file + " " + e.getMessage());
    }
    return transactionRecordList;
  }
}
