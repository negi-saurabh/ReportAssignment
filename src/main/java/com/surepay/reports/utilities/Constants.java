package com.surepay.reports.utilities;

public class Constants {
  //path of the input data file
  public static final String CSV_DATA_FILE = "./input/records.csv";
  public static final String JSON_DATA_FILE = "./input/records.json";
  public static final String OUTPUT_FILE_PATH = "./output";

  //type of output reports
  public static final String REPORT_TYPE_CSV = "CSV";
  public static final String REPORT_TYPE_JSON = "JSON";

  //type of validations
  public static final String VALIDATION_UNIQUE_REF = "UNIQUE_REF";
  public static final String VALIDATION_BALANCE_CHECK = "BALANCE_CHECK";

  //type of processor
  public static final String FAILED_RECORD_PROCESSOR = "FAILED_RECORD_PROCESSOR";
  public static final String PASSED_RECORD_PROCESSOR = "PASSED_RECORD_PROCESSOR";

}
