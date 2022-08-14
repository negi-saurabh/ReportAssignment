package com.surepay.reports.utilities;

/*
 * A utility to read all the files from the folder
 * Take file path as input and returns List of Files
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataFilesReader {

  public static List<File> getFilesFromPath(String Path) throws IOException {
    List<File> dataFiles = new ArrayList<>();
    File [] files = new File(Path).listFiles(obj -> obj.isFile());
    for (int i = 0; i < files.length; i++) {
      System.out.println(files[i].getName());
      dataFiles.add(files[i]);
    }
    return dataFiles;
  }

}
