package com.unorderedlist;

import org.junit.Assert;
import org.junit.Test;

public class CsvFileTest {

    private static final String STRING_CSV_FILE_PATH = "C:\\Users\\arun kumar\\IdeaProjects\\UnOrderedList\\src\\main\\resources\\stringData.csv";
    private static final String INTEGER_CSV_FILE_PATH = "C:\\Users\\arun kumar\\IdeaProjects\\UnOrderedList\\src\\main\\resources\\integerData.csv";
    private static final String DOUBLE_CSV_FILE_PATH = "C:\\Users\\arun kumar\\IdeaProjects\\UnOrderedList\\src\\main\\resources\\doubleData.csv";
    private static final String CHAR_CSV_FILE_PATH = "C:\\Users\\arun kumar\\IdeaProjects\\UnOrderedList\\src\\main\\resources\\charData.csv";

    @Test
    public void givenStringData_whenNotFoundAddIt_shouldIncreaseSizeBy1() throws ListException {
        CsvFileData file = new CsvFileData();
        List<String> list = file.readCsvFileToLinkedList(STRING_CSV_FILE_PATH, "string");
        file.addOrRemoveDataInCsvFile("xyz",STRING_CSV_FILE_PATH,"string");
        List<String> updatedlist = file.readCsvFileToLinkedList(STRING_CSV_FILE_PATH, "string");
        Assert.assertEquals(list.size()+1,updatedlist.size());
    }

    @Test
    public void givenStringData_whenFoundRemoveIt_shouldDecreaseSizeBy1() throws ListException {
        CsvFileData file = new CsvFileData();
        List<String> list = file.readCsvFileToLinkedList(STRING_CSV_FILE_PATH, "string");
        file.addOrRemoveDataInCsvFile("ghi",STRING_CSV_FILE_PATH,"string");
        List<String> updatedlist = file.readCsvFileToLinkedList(STRING_CSV_FILE_PATH, "string");
        Assert.assertEquals(list.size()-1,updatedlist.size());
    }
    @Test
    public void givenInegerData_whenFoundRemoveIt_shouldDecreaseSizeBy1() throws ListException {
        CsvFileData file = new CsvFileData();
        List<Integer> list = file.readCsvFileToLinkedList(INTEGER_CSV_FILE_PATH, 1);
        file.addOrRemoveDataInCsvFile(1,INTEGER_CSV_FILE_PATH, 1);
        List<Integer> updatedlist = file.readCsvFileToLinkedList(INTEGER_CSV_FILE_PATH, 1);
        Assert.assertEquals(list.size()-1,updatedlist.size());
    }

    @Test
    public void givenInegerData_whenNotFoundAddIt_shouldIncreaseSizeBy1() throws ListException {
        CsvFileData file = new CsvFileData();
        List<Integer> list = file.readCsvFileToLinkedList(INTEGER_CSV_FILE_PATH, 1);
        file.addOrRemoveDataInCsvFile(9,INTEGER_CSV_FILE_PATH, 1);
        List<Integer> updatedlist = file.readCsvFileToLinkedList(INTEGER_CSV_FILE_PATH, 1);
        Assert.assertEquals(list.size()+1,updatedlist.size());
    }

    @Test
    public void givenDoubleData_whenFoundRemoveIt_shouldDecreaseSizeBy1() throws ListException {
        CsvFileData file = new CsvFileData();
        List<Double> list = file.readCsvFileToLinkedList(DOUBLE_CSV_FILE_PATH, 0.1);
        file.addOrRemoveDataInCsvFile(0.3,DOUBLE_CSV_FILE_PATH, 0.1);
        List<Double> updatedlist = file.readCsvFileToLinkedList(DOUBLE_CSV_FILE_PATH, 0.1);
        Assert.assertEquals(list.size()-1,updatedlist.size());
    }

    @Test
    public void givenDoubleData_whenNotFoundAddIt_shouldIncreaseSizeBy1() throws ListException {
        CsvFileData file = new CsvFileData();
        List<Double> list = file.readCsvFileToLinkedList(DOUBLE_CSV_FILE_PATH, 0.1);
        file.addOrRemoveDataInCsvFile(0.8,DOUBLE_CSV_FILE_PATH, 0.1);
        List<Double> updatedlist = file.readCsvFileToLinkedList(DOUBLE_CSV_FILE_PATH, 0.1);
        Assert.assertEquals(list.size()+1,updatedlist.size());
    }

    @Test
    public void givenCharData_whenFoundRemoveIt_shouldDecreaseSizeBy1() throws ListException {
        CsvFileData file = new CsvFileData();
        List<Character> list = file.readCsvFileToLinkedList(CHAR_CSV_FILE_PATH, 'z');
        file.addOrRemoveDataInCsvFile('d',CHAR_CSV_FILE_PATH, 'z');
        List<Character> updatedlist = file.readCsvFileToLinkedList(CHAR_CSV_FILE_PATH, 'z');
        Assert.assertEquals(list.size()-1,updatedlist.size());
    }

    @Test
    public void givenCharData_whenNotFoundAddIt_shouldIncreaseSizeBy1() throws ListException {
        CsvFileData file = new CsvFileData();
        List<Character> list = file.readCsvFileToLinkedList(CHAR_CSV_FILE_PATH, 'z');
        file.addOrRemoveDataInCsvFile('t',CHAR_CSV_FILE_PATH, 'z');
        List<Character> updatedlist = file.readCsvFileToLinkedList(CHAR_CSV_FILE_PATH, 'z');
        Assert.assertEquals(list.size()+1,updatedlist.size());
    }

}
