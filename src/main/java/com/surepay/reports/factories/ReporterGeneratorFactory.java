package com.surepay.reports.factories;

import com.surepay.reports.exceptions.WrongOutputReportFormatException;
import com.surepay.reports.reportformats.ReportAsExcel;
import com.surepay.reports.interfaces.IReporter;
import com.surepay.reports.reportformats.ReportAsJSON;

public class ReporterGeneratorFactory {
  public static IReporter getGenerator(String reportType) throws WrongOutputReportFormatException {
    IReporter reporter = null;
    switch (reportType) {
      case "CSV" :
        reporter = new ReportAsExcel();
        break;
      case "JSON" :
        // no implementation yet
        reporter = new ReportAsJSON();
        break;
      default:
        throw  new WrongOutputReportFormatException("The output report cannot be generated in" + reportType+ " format");
    }
    return reporter;
  }
}
