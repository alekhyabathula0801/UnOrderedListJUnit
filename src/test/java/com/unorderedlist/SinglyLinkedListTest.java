package com.unorderedlist;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {
    @Test
    public <E> void checkEmptyList() {
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList();
        Assert.assertEquals(0, singlyLinkedList.count);
    }

    @Test
    public <E> void givenData_whenAdded_ShouldReturn1() throws ListException{
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(2);
        Assert.assertEquals(1, singlyLinkedList.count);
    }

    @Test
    public <E> void given3Items_whenAdded_ShouldReturn3() throws ListException{
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(265);
        singlyLinkedList.add("Apple");
        singlyLinkedList.add('d');
        Assert.assertEquals(3, singlyLinkedList.count);
    }

    @Test
    public <E> void givenNull_ShouldThrowException() {
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        try {
            singlyLinkedList.add(null);
        } catch(Exception e) {
            Assert.assertEquals("Entered Null", e.getMessage());
        }
    }

    @Test
    public <E> void givenEmpty_ShouldThrowException() {
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        try {
            singlyLinkedList.add("");
        } catch(Exception e) {
            Assert.assertEquals("Entered Empty", e.getMessage());
        }
    }

    @Test
    public <E> void given3Items_when2ndItemRemoved_ShouldReturn2() throws ListException{
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(2);
        singlyLinkedList.add("Apple");
        singlyLinkedList.add('d');
        singlyLinkedList.remove("Apple");
        Assert.assertEquals(2, singlyLinkedList.count);
    }

    @Test
    public <E> void given4Items_when2ItemRemoved_ShouldReturn2() throws ListException{
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(2);
        singlyLinkedList.add("Apple");
        singlyLinkedList.add('d');
        singlyLinkedList.add(34);
        singlyLinkedList.remove("Apple");
        singlyLinkedList.remove(34);
        Assert.assertEquals(2, singlyLinkedList.count);
    }

    @Test
    public <E> void given3Items_when1stItemRemoved_ShouldReturn2() throws ListException{
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(2);
        singlyLinkedList.add("Apple");
        singlyLinkedList.add('d');
        singlyLinkedList.remove(2);
        Assert.assertEquals(2, singlyLinkedList.count);
    }

    @Test
    public <E> void givenRemoveItemAsNull_ShouldThrowException() {
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        try {
            singlyLinkedList.add(5);
            singlyLinkedList.remove(null);
        } catch(Exception e) {
            Assert.assertEquals("Entered Null", e.getMessage());
        }
    }

    @Test
    public <E> void givenRemoveItemAsEmpty_ShouldThrowException() {
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        try {
            singlyLinkedList.add(4);
            singlyLinkedList.remove("");
        } catch(Exception e) {
            Assert.assertEquals("Entered Empty", e.getMessage());
        }
    }


    @Test
    public <E> void given1stItemForSearch_whenFound_ShouldReturnTrue() throws ListException{
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(2);
        singlyLinkedList.add("Apple");
        singlyLinkedList.add('d');
        Boolean result = singlyLinkedList.search(2);
        Assert.assertTrue(result);
    }

    @Test
    public <E> void given2ndItemForSearch_whenFound_ShouldReturnTrue() throws ListException{
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(2);
        singlyLinkedList.add("Apple");
        singlyLinkedList.add('d');
        singlyLinkedList.add(34);
        Boolean result = singlyLinkedList.search("Apple");
        Assert.assertTrue(result);
    }

    @Test
    public <E> void givenLastItemForSearch_whenFound_ShouldReturnTrue() throws ListException{
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(2);
        singlyLinkedList.add("Apple");
        singlyLinkedList.add('d');
        Boolean result = singlyLinkedList.search('d');
        Assert.assertTrue(result);
    }

    @Test
    public <E> void givenItemForSearch_whenNotFound_ShouldReturnFalse() throws ListException{
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(2);
        singlyLinkedList.add("Apple");
        singlyLinkedList.add('d');
        Boolean result = singlyLinkedList.search("alex");
        Assert.assertFalse(result);
    }

    @Test
    public <E> void givenNullForSearch_ShouldThrowException() {
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        try {
            singlyLinkedList.add(5);
            singlyLinkedList.search(null);
        } catch(Exception e) {
            Assert.assertEquals("Entered Null", e.getMessage());
        }
    }

    @Test
    public <E> void givenEmptyForSearch_ShouldThrowException() {
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        try {
            singlyLinkedList.add(4);
            singlyLinkedList.search("");
        } catch(Exception e) {
            Assert.assertEquals("Entered Empty", e.getMessage());
        }
    }

    @Test
    public <E> void givenNoitems_shouldReturnTrue() {
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        Boolean result = singlyLinkedList.isEmpty();
        Assert.assertTrue(result);
    }

    @Test
    public <E> void givenitems_whenNoItems_shouldReturnFalse() throws ListException{
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        Boolean result = singlyLinkedList.isEmpty();
        Assert.assertFalse(result);
    }

    @Test
    public <E> void givenitems_shouldReturnSizeOfList() throws ListException{
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add("Ball");
        int result = singlyLinkedList.size();
        Assert.assertEquals(2,result);
    }

}

