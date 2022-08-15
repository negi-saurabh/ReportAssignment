package com.surepay.reports.interfaces;

import java.io.IOException;

public interface IProcessor {

  public void process();

  public void generateReport(String path) throws IOException;

}
