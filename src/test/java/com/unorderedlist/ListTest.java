package com.unorderedlist;

import org.junit.Assert;
import org.junit.Test;

public class ListTest {
    @Test
    public <E extends Comparable> void checkEmptyList() {
        List<E> list = new List();
        Assert.assertEquals(null, list.head);
    }

    @Test
    public <E extends Comparable> void givenData_whenAdded_ShouldReturn1() throws ListException{
        List<E> list = new List<>();
        list.add(2);
        Assert.assertEquals(1, list.count);
    }

    @Test
    public <E extends Comparable> void given3Items_whenAdded_ShouldReturn3() throws ListException{
        List<E> list = new List<>();
        list.add(265);
        list.add("Apple");
        list.add('d');
        Assert.assertEquals(3, list.count);
    }

    @Test
    public <E extends Comparable> void givenNull_ShouldThrowException() {
        List<E> list = new List<>();
        try {
            list.add(null);
        } catch(Exception e) {
            Assert.assertEquals("Entered Null", e.getMessage());
        }
    }

    @Test
    public <E extends Comparable> void givenEmpty_ShouldThrowException() {
        List<E> list = new List<>();
        try {
            list.add("");
        } catch(Exception e) {
            Assert.assertEquals("Entered Empty", e.getMessage());
        }
    }

    @Test
    public <E extends Comparable> void given3Items_when2ndItemRemoved_ShouldReturn2() throws ListException{
        List<E> list = new List<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        Assert.assertEquals(2, list.count);
    }

    @Test
    public <E extends Comparable> void given4Items_when4thItemRemoved_ShouldReturn3() throws ListException{
        List<E> list = new List<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Custurd");
        list.add("Mango");
        list.remove("Mango");
        Assert.assertEquals(3, list.count);
    }

    @Test
    public <E extends Comparable> void given3Items_when1stItemRemoved_ShouldReturn2() throws ListException{
        List<E> list = new List<>();
        list.add('e');
        list.add('a');
        list.add('d');
        list.remove('e');
        Assert.assertEquals(2, list.count);
    }

    @Test
    public <E extends Comparable> void givenData_whenRemoveElementNotFound_ShouldThrowException() throws ListException {
        List<E> list = new List<>();
        try {
            list.add(5);
            list.remove(4);
        } catch(Exception e) {
            Assert.assertEquals("Element entered is not found in list", e.getMessage());
        }
    }

    @Test
    public <E extends Comparable> void givenRemoveItemAsNull_ShouldThrowException() {
        List<E> list = new List<>();
        try {
            list.add(5);
            list.remove(null);
        } catch(Exception e) {
            Assert.assertEquals("Entered Null", e.getMessage());
        }
    }

    @Test
    public <E extends Comparable> void givenRemoveItemAsEmpty_ShouldThrowException() {
        List<E> list = new List<>();
        try {
            list.add(4);
            list.remove("");
        } catch(Exception e) {
            Assert.assertEquals("Entered Empty", e.getMessage());
        }
    }

    @Test
    public <E extends Comparable> void given1stItemForSearch_whenFound_ShouldReturnTrue() throws ListException {
        List<E> list = new List<>();
        list.add(2);
        list.add(4);
        list.add(5);
        Boolean result = list.search(2);
        Assert.assertTrue(result);
    }

    @Test
    public <E extends Comparable> void given2ndItemForSearch_whenFound_ShouldReturnTrue() throws ListException {
        List<E> list = new List<>();
        list.add("sunday");
        list.add("Apple");
        list.add("banana");
        list.add("Ant");
        Boolean result = list.search("Apple");
        Assert.assertTrue(result);
    }

    @Test
    public <E extends Comparable> void givenLastItemForSearch_whenFound_ShouldReturnTrue() throws ListException {
        List<E> list = new List<>();
        list.add('a');
        list.add('w');
        list.add('d');
        Boolean result = list.search('d');
        Assert.assertTrue(result);
    }

    @Test
    public <E extends Comparable> void givenItemForSearch_whenNotFound_ShouldReturnFalse() throws ListException {
        List<E> list = new List<>();
        list.add("Grapes");
        list.add("Apple");
        list.add("Sweet");
        Boolean result = list.search("alex");
        Assert.assertFalse(result);
    }

    @Test
    public <E extends Comparable> void givenNullForSearch_ShouldThrowException() {
        List<E> list = new List<>();
        try {
            list.add(5);
            list.search(null);
        } catch(Exception e) {
            Assert.assertEquals("Entered Null", e.getMessage());
        }
    }

    @Test
    public <E extends Comparable> void givenEmptyForSearch_ShouldThrowException() {
        List<E> list = new List<>();
        try {
            list.add(4);
            list.search("");
        } catch(Exception e) {
            Assert.assertEquals("Entered Empty", e.getMessage());
        }
    }

    @Test
    public <E extends Comparable> void givenNoitems_shouldReturnTrue() {
        List<E> list = new List<>();
        Boolean result = list.isEmpty();
        Assert.assertTrue(result);
    }

    @Test
    public <E extends Comparable> void givenitems_shouldReturnFalse() throws ListException {
        List<E> list = new List<>();
        list.add(1);
        Boolean result = list.isEmpty();
        Assert.assertFalse(result);
    }

    @Test
    public <E extends Comparable> void given2items_shouldReturn2() throws ListException{
        List<E> list = new List<>();
        list.add(1);
        list.add("Ball");
        int result = list.size();
        Assert.assertEquals(2,result);
    }

    @Test
    public <E extends Comparable> void given1ElementToAddAnd2ElementsToAppend_shouldReturn3() throws ListException{
        List<E> list = new List<>();
        list.add(5);
        list.append(1,2);
        int result = list.size();
        Assert.assertEquals(3,result);
    }

    @Test
    public <E extends Comparable> void givenElementToFindIndex_shouldReturn2() throws ListException{
        List<E> list = new List<>();
        list.add(5);
        list.append(1,2);
        int result = list.index(2);
        Assert.assertEquals(2,result);
    }

    @Test
    public <E extends Comparable> void given2ndElementToFindIndex_shouldReturn1() throws ListException{
        List<E> list = new List<>();
        list.add(5);
        list.append(3,2);
        int result = list.index(3);
        Assert.assertEquals(1,result);
    }

    @Test
    public <E extends Comparable> void given1stElementToFindIndex_shouldReturn0() throws ListException{
        List<E> list = new List<>();
        list.add(5);
        list.append(3,2);
        int result = list.index(5);
        Assert.assertEquals(0,result);
    }

    @Test
    public <E extends Comparable> void givenElementToFindIndex_whenNotFound_shouldReturnminus1() throws ListException{
        List<E> list = new List<>();
        list.add(5);
        list.append(3,2);
        int result = list.index(7);
        Assert.assertEquals(-1,result);
    }

    @Test
    public <E extends Comparable> void given3Elements_whenLastElementRemoved_shouldReturn2() throws ListException{
        List<E> list = new List<>();
        list.add(5);
        list.append(3,2);
        list.pop();
        Assert.assertEquals(2,list.size());
    }
    
}
