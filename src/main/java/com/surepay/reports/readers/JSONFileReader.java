package com.surepay.reports.readers;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.exceptions.JSONFileReadException;
import com.surepay.reports.interfaces.IFileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileReader implements IFileReader {
  private static final Logger logger = LogManager.getLogger(JSONFileReader.class);
  private File file;

  public JSONFileReader(File file){
    this.file = file;
  }

  @Override
  public List<TransactionRecord> readFile() throws JSONFileReadException {
    logger.log(Level.INFO, "Reading input JSON file");
    List<TransactionRecord> transactionRecordList = new ArrayList<>();
    {
      //Creating a JSONParser object
      JSONParser jsonParser = new JSONParser();
      try {
        JSONArray array = (JSONArray) jsonParser.parse(new FileReader(file));
        for (Object object : array) {
          JSONObject jsonObject = (JSONObject) object;
          String reference = (String) jsonObject.get("reference");
          String accountNumber = (String) jsonObject.get("accountNumber");
          String description = (String) jsonObject.get("description");
          Double startBalance = Double.parseDouble(jsonObject.get("startBalance").toString());
          Double mutation = Double.parseDouble(jsonObject.get("mutation").toString());
          Double endBalance = Double.parseDouble(jsonObject.get("endBalance").toString());

          TransactionRecord transactionRecord = new TransactionRecord(reference, accountNumber, description,
              startBalance,  mutation, endBalance);
          transactionRecordList.add(transactionRecord);
        }

      } catch (IOException | ParseException e) {
        e.printStackTrace();
      } catch (Exception e){
        throw new JSONFileReadException("Exception while reading the json file " + file);
      }
    }
    return transactionRecordList;
  }
}
