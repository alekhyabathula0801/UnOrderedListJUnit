package com.unorderedlist;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvFileData {

    public <E extends Comparable> List<E> readCsvFileToLinkedList(String path, E type) throws ListException {
        List<E> list = new List<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(path));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] records = csvReader.readNext();
            switch (type.getClass().getSimpleName()) {
                case "Integer" :
                    for (String record : records) {
                        list.add(Integer.parseInt(record));
                    }
                    break;
                case "Double" :
                    for (String record : records) {
                        list.add(Double.parseDouble(record));
                    }
                    break;
                case "Character" :
                    for (String record : records) {
                        list.add(record.charAt(0));
                    }
                    break;
                default:
                    for (String record : records) {
                        list.add(record);
                    }
                    break;
            }
        } catch (IOException e) {
            System.out.println("No record found");
        }
        return list;
    }

    public <E extends Comparable> void writeInCsvFile(List<E> list, String path) {
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(path));
            CSVWriter csvWriter = new CSVWriter(writer);
            String[] data = list.toString().split(",");
            csvWriter.writeNext(data);
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <E extends Comparable> void addOrRemoveDataInCsvFile(E data, String path, E type) throws ListException {
        List<E> list = readCsvFileToLinkedList(path, type);
        if(list.search(data))
            list.remove(data);
        else
            list.add(data);
        writeInCsvFile(list,path);
    }

}