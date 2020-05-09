package com.unorderedlist;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvFileAndLinkedList {
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\arun kumar\\IdeaProjects\\UnOrderedList\\src\\main\\resources\\data.csv";
    public static <E > void readCsvFileToLinkedList() throws ListException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] records = csvReader.readNext();
            SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
            for (String record : records) {
                singlyLinkedList.add(record);
            }
            singlyLinkedList.displayItems();
        } catch (IOException e) {
            System.out.println("No record found");
        }
    }
}


