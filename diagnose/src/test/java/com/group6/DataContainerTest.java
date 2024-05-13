package com.group6;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataContainerTest {

    @Test
    public void bootstrapWithoutError(){
        DataContainer data = new DataContainer(2,13);
        assertEquals(2, data.getRows());
        data = new DataContainer(10,13);
        assertEquals(10, data.getRows());
        data = new DataContainer(0,13);
        assertEquals(0, data.getRows());
        data = new DataContainer(9999999,13);
        assertEquals(9999999, data.getRows());

    }
    
}
