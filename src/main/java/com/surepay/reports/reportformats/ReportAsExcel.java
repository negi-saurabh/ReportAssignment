package com.surepay.reports.reportformats;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IReporter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReportAsExcel implements IReporter {

  @Override
  public void generateReport(Map<TransactionRecord, String> failedRecords, String path)
      throws IOException {
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet spreadsheet = workbook.createSheet("Failed Records");
    Row row ;
    int rowid = 0;

    // writing the data into the sheets...
    Set<TransactionRecord> keyId = failedRecords.keySet();
    for (TransactionRecord key : keyId) {
      row = spreadsheet.createRow(rowid++);
      String objectArr = failedRecords.get(key.getReference());
      int cellid = 0;

      Cell cell = row.createCell(cellid++);
      cell.setCellValue(objectArr);
    }

    // .xlsx is the format for Excel Sheets...
    // writing the workbook into the file...
    FileOutputStream out = new FileOutputStream(
        new File(path+"/"+"failedRecord.xlsx"));

    workbook.write(out);
    out.close();
  }
}
