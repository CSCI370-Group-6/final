package com.group6;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAdd2()
    {
        // assertTrue( true );
        assertEquals(4, new App().add2(2, 2));
    }
}
