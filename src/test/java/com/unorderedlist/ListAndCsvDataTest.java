package com.unorderedlist;

import org.junit.Assert;
import org.junit.Test;

public class ListAndCsvDataTest {
    @Test
    public <E> void checkEmptyList() {
        List<E> list = new List();
        Assert.assertEquals(null, list.first);
    }

    @Test
    public <E> void givenData_whenAdded_ShouldReturn1() throws ListException{
        List<E> list = new List<>();
        list.add(2);
        Assert.assertEquals(1, list.count);
    }

    @Test
    public <E> void given3Items_whenAdded_ShouldReturn3() throws ListException{
        List<E> list = new List<>();
        list.add(265);
        list.add("Apple");
        list.add('d');
        Assert.assertEquals(3, list.count);
    }

    @Test
    public <E> void givenNull_ShouldThrowException() {
        List<E> list = new List<>();
        try {
            list.add(null);
        } catch(Exception e) {
            Assert.assertEquals("Entered Null", e.getMessage());
        }
    }

    @Test
    public <E> void givenEmpty_ShouldThrowException() {
        List<E> list = new List<>();
        try {
            list.add("");
        } catch(Exception e) {
            Assert.assertEquals("Entered Empty", e.getMessage());
        }
    }

    @Test
    public <E> void given3Items_when2ndItemRemoved_ShouldReturn2() throws ListException{
        List<E> list = new List<>();
        list.add(2);
        list.add("Apple");
        list.add('d');
        list.remove("Apple");
        Assert.assertEquals(2, list.count);
    }

    @Test
    public <E> void given4Items_when2ItemRemoved_ShouldReturn2() throws ListException{
        List<E> list = new List<>();
        list.add(2);
        list.add("Apple");
        list.add('d');
        list.add(34);
        list.remove("Apple");
        list.remove(34);
        Assert.assertEquals(2, list.count);
    }

    @Test
    public <E> void given3Items_when1stItemRemoved_ShouldReturn2() throws ListException{
        List<E> list = new List<>();
        list.add(2);
        list.add("Apple");
        list.add('d');
        list.remove(2);
        Assert.assertEquals(2, list.count);
    }

    @Test
    public <E> void givenData_whenNotFound_ShouldReturnSize2() throws ListException {
        List<E> list = new List<>();
        list.add(5);
        list.add(2);
        list.remove(6);
        Assert.assertEquals(2, list.size());
    }

    @Test
    public <E> void givenRemoveItemAsNull_ShouldThrowException() {
        List<E> list = new List<>();
        try {
            list.add(5);
            list.remove(null);
        } catch(Exception e) {
            Assert.assertEquals("Entered Null", e.getMessage());
        }
    }

    @Test
    public <E> void givenRemoveItemAsEmpty_ShouldThrowException() {
        List<E> list = new List<>();
        try {
            list.add(4);
            list.remove("");
        } catch(Exception e) {
            Assert.assertEquals("Entered Empty", e.getMessage());
        }
    }

    @Test
    public <E> void given1stItemForSearch_whenFound_ShouldReturnTrue() throws ListException {
        List<E> list = new List<>();
        list.add(2);
        list.add("Apple");
        list.add('d');
        Boolean result = list.search(2);
        Assert.assertTrue(result);
    }

    @Test
    public <E> void given2ndItemForSearch_whenFound_ShouldReturnTrue() throws ListException {
        List<E> list = new List<>();
        list.add(2);
        list.add("Apple");
        list.add('d');
        list.add(34);
        Boolean result = list.search("Apple");
        Assert.assertTrue(result);
    }

    @Test
    public <E> void givenLastItemForSearch_whenFound_ShouldReturnTrue() throws ListException {
        List<E> list = new List<>();
        list.add(2);
        list.add("Apple");
        list.add('d');
        Boolean result = list.search('d');
        Assert.assertTrue(result);
    }

    @Test
    public <E> void givenItemForSearch_whenNotFound_ShouldReturnFalse() throws ListException {
        List<E> list = new List<>();
        list.add(2);
        list.add("Apple");
        list.add('d');
        Boolean result = list.search("alex");
        Assert.assertFalse(result);
    }

    @Test
    public <E> void givenNullForSearch_ShouldThrowException() {
        List<E> list = new List<>();
        try {
            list.add(5);
            list.search(null);
        } catch(Exception e) {
            Assert.assertEquals("Entered Null", e.getMessage());
        }
    }

    @Test
    public <E> void givenEmptyForSearch_ShouldThrowException() {
        List<E> list = new List<>();
        try {
            list.add(4);
            list.search("");
        } catch(Exception e) {
            Assert.assertEquals("Entered Empty", e.getMessage());
        }
    }

    @Test
    public <E> void givenNoitems_shouldReturnTrue() {
        List<E> list = new List<>();
        Boolean result = list.isEmpty();
        Assert.assertTrue(result);
    }

    @Test
    public <E> void givenitems_shouldReturnFalse() throws ListException {
        List<E> list = new List<>();
        list.add(1);
        Boolean result = list.isEmpty();
        Assert.assertFalse(result);
    }

    @Test
    public <E> void given2items_shouldReturn2() throws ListException{
        List<E> list = new List<>();
        list.add(1);
        list.add("Ball");
        int result = list.size();
        Assert.assertEquals(2,result);
    }

    @Test
    public <E> void given1ElementToAddAnd2ElementsToAppend_shouldReturn3() throws ListException{
        List<E> list = new List<>();
        list.add(5);
        list.append(1,2);
        int result = list.size();
        Assert.assertEquals(3,result);
    }

    @Test
    public <E> void givenData_whenNotFoundAddIt_shouldIncreaseSizeBy1() throws ListException{
        CsvFileData<String> file = new CsvFileData<>();
        List<String> list = file.readCsvFileToLinkedList();
        file.addDataToCsvFile("Snigdha");
        List<String> updatedlist = file.readCsvFileToLinkedList();
        Assert.assertEquals(list.size()+1,updatedlist.size());
    }

}
