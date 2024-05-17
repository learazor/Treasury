package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utility.collection.ArrayList;


class ArrayListTest {

    private final ArrayList<String> list = new ArrayList<>();

    @Test
    public void testIfContains() {
        list.add("one");
        list.add("two");
        list.add("three");
        Assertions.assertTrue(list.contains("two"));
    }
    @Test
    public void testIfEmpty() {
        list.add("one");
        list.add("two");
        list.add("three");
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void testIfFull() {
        list.add("one");
        list.add("two");
        list.add("three");
        Assertions.assertTrue(list.isFull());
    }

    @Test
    public void testGet() {
        list.add("one");
        list.add("two");
        list.add("three");
        Assertions.assertEquals(list.get(0), "one");
    }

    @Test
    public void testIndexOf() {
        list.add("one");
        list.add("two");
        list.add("three");
        Assertions.assertEquals(list.indexOf("one"), 0);
    }


}