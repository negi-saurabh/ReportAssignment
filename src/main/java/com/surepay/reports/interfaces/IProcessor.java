package com.surepay.reports.interfaces;

import com.surepay.reports.exceptions.CSVFileReadException;
import com.surepay.reports.exceptions.JSONFileReadException;
import java.io.IOException;

public interface IProcessor {

  public void process() throws JSONFileReadException, CSVFileReadException;

  public void generateReport() throws IOException;

}
