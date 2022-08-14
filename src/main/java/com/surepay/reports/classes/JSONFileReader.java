package com.surepay.reports.classes;

import com.surepay.reports.TransactionRecord;
import com.surepay.reports.interfaces.IFileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileReader implements IFileReader {

  @Override
  public List<TransactionRecord> readFile(File file) {
    System.out.println("Inside JSONFileReader class");
    {
      //Creating a JSONParser object
      JSONParser jsonParser = new JSONParser();
      //JSONDeserializer<Transaction> deserializer = new JSONDeserializer<Transaction>();

      try {
        // Read file into a string
        JSONArray array = (JSONArray) jsonParser.parse(new FileReader(file));

        for (Object o : array) {
          JSONObject jsonObject = (JSONObject) o;
          String accountNumber = (String) jsonObject.get("accountNumber");
          String description = (String) jsonObject.get("description");
          Double startBalance = Double.parseDouble(jsonObject.get("startBalance").toString());
          Double mutation = (Double) jsonObject.get("mutation");
          Double endBalance = (Double) jsonObject.get("endBalance");

          //Forming URL
          System.out.println("Contents of the JSON are: ");
          System.out.println("ID :" + accountNumber);
          System.out.println("First name: " + description);
          System.out.println("Last name: " + startBalance);
          System.out.println("Date of birth: " + mutation);
          System.out.println("Place of birth: " + endBalance);
          System.out.println(" ");
        }

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    return null;
  }
}
