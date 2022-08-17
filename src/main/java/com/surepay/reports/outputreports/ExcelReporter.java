package com.surepay.reports.outputreports;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IReporter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Creates output report in as an Excel
 * filled with failed records
 */

public class ExcelReporter implements IReporter {
  private static final Logger logger = LogManager.getLogger(ExcelReporter.class);
  private String outputFilePath;
  public ExcelReporter(String outputFilePath){
    this.outputFilePath = outputFilePath;
  }

  @Override
  public void generateReport(Map<TransactionRecord, String> failedRecords)
      throws IOException {
    logger.log(Level.INFO, "Creating output file using failed records");
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet spreadsheet = workbook.createSheet("Failed Records");
    int rowno = 0;

    // setting header
    XSSFRow headerRow= spreadsheet.createRow(rowno++);
    headerRow.createCell(0).setCellValue("Transaction Reference");
    headerRow.createCell(1).setCellValue("Description ");
    headerRow.createCell(2).setCellValue("Reason");

    for(HashMap.Entry entry:failedRecords.entrySet()) {
      XSSFRow row= spreadsheet.createRow(rowno++);
      TransactionRecord failedTransaction = (TransactionRecord)entry.getKey();
      row.createCell(0).setCellValue(failedTransaction.getReference());
      row.createCell(1).setCellValue(failedTransaction.getDescription());
      row.createCell(2).setCellValue((String)entry.getValue());
    }

    // writing the workbook into the file...
    FileOutputStream file = new FileOutputStream( new File(outputFilePath+"/"+"failedRecord.xlsx"));
    workbook.write(file);
    logger.log(Level.INFO, "Created output file at " + outputFilePath);
    file.close();
  }
}
