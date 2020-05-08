package com.unorderedlist;

import org.junit.Assert;
import org.junit.Test;

public class ListTest {
    @Test
    public void checkEmptyList() {
        List<Integer> list = new List();
        Assert.assertEquals(0,list.count);
    }
}
