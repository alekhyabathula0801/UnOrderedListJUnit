package com.unorderedlist;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvFileData<E extends Comparable<E>> {

    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\arun kumar\\IdeaProjects\\UnOrderedList\\src\\main\\resources\\data.csv";

    public List<E> readCsvFileToLinkedList() throws ListException {
        List<E> list = new List<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] records = csvReader.readNext();
            for (String record : records) {
                list.add(record);
            }
        } catch (IOException e) {
            System.out.println("No record found");
        }
        return list;
    }

    public void writeInCsvFile(List<E> list) throws ListException {

        try {
            Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVWriter csvWriter = new CSVWriter(writer);
            String[] data = list.toString().split(",");
            csvWriter.writeNext(data);
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addDataToCsvFile(E data) throws ListException {
        List<E> list = readCsvFileToLinkedList();
        Boolean result = list.search(data);
        if (result == false)
            list.add(data);
        writeInCsvFile(list);
    }

}


