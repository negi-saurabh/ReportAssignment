package com.surepay.reports.factories;

import com.surepay.reports.exceptions.WrongOutputReportFormatException;
import com.surepay.reports.outputreports.ExcelReporter;
import com.surepay.reports.interfaces.IReporter;
import com.surepay.reports.outputreports.JSONReporter;

public class ReporterGeneratorFactory {
  public static IReporter getGenerator(String reportType, String outputPath) throws WrongOutputReportFormatException {
    IReporter reporter = null;
    switch (reportType) {
      case "CSV" :
        reporter = new ExcelReporter(outputPath);
        break;
      case "JSON" :
        // no implementation yet
        reporter = new JSONReporter(outputPath);
        break;
      default:
        throw  new WrongOutputReportFormatException("The output report cannot be generated in" + reportType+ " format");
    }
    return reporter;
  }
}
