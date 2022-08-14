package com.surepay.reports.interfaces;

import com.surepay.reports.TransactionRecord;
import java.io.File;
import java.util.List;

public interface IFileReader {

  List<TransactionRecord> readFile(File file);

}