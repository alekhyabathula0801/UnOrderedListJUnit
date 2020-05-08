package com.unorderedlist;

import org.junit.Assert;
import org.junit.Test;

public class ListTest {
    @Test
    public <E> void checkEmptyList() {
        List<E> list = new List();
        Assert.assertEquals(0,list.count);
    }

    @Test
    public <E> void givenData_whenAdded_ShouldReturn1() throws ListException{
        List<E> list = new List<>();
        list.add(2);
        Assert.assertEquals(1,list.count);
    }

    @Test
    public <E> void givenData_whenAdded_ShouldReturn3() throws ListException{
        List<E> list = new List<>();
        list.add(2);
        list.add("Apple");
        list.add('d');
        Assert.assertEquals(3,list.count);
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
            list.add(null);
        } catch(Exception e) {
            Assert.assertEquals("Entered Null", e.getMessage());
        }
    }
}
