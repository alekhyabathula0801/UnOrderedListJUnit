package com.unorderedlist;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvConstraintViolationException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFileAndLinkedList <E extends Comparable<E>> {

    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\arun kumar\\IdeaProjects\\UnOrderedList\\src\\main\\resources\\data.csv";

    public  SinglyLinkedList<E> readCsvFileToLinkedList() throws ListException {
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] records = csvReader.readNext();
            for (String record : records) {
                singlyLinkedList.add(record);
            }
        } catch (IOException e) {
            System.out.println("No record found");
        }
        return singlyLinkedList;
    }

    public void writeInCsvFile(SinglyLinkedList<E> singlyLinkedList) throws ListException{

        try {
            Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVWriter csvWriter = new CSVWriter(writer);
            String[] data = singlyLinkedList.toString().split(",");
            csvWriter.writeNext(data);
            csvWriter.flush();
            csvWriter.close();
            readCsvFileToLinkedList();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}


