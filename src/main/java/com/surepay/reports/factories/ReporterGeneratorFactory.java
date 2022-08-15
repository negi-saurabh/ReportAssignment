package com.surepay.reports.factories;

import com.surepay.reports.reportformats.ReportAsExcel;
import com.surepay.reports.interfaces.IReporter;

public class ReporterGeneratorFactory {
  public static IReporter getGenerator(String reportType) {
    IReporter reporter = null;
    switch (reportType) {
      case "EXCEL" :
        reporter = new ReportAsExcel();
    }
    return reporter;
  }
}
