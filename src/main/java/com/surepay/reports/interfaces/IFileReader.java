package com.surepay.reports.interfaces;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.exceptions.CSVFileReadException;
import com.surepay.reports.exceptions.JSONFileReadException;
import java.io.File;
import java.util.List;

public interface IFileReader {

  List<TransactionRecord> readFile() throws CSVFileReadException, JSONFileReadException;

}
