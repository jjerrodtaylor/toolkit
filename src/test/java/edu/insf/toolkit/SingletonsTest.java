package edu.insf.toolkit;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import edu.insf.toolkit.DesignPatterns.Singletons.SingletonBufferedReader;
import edu.insf.toolkit.DesignPatterns.Singletons.SingletonBufferedWriter;

public class SingletonsTest
{
    public BufferedReader br1;
    public BufferedReader br2;

    public BufferedWriter bw1;
    public BufferedWriter bw2;

    @Before
    public void setUp()
    {
        br1 = SingletonBufferedReader.getBufferedReader("");
        br2 = SingletonBufferedReader.getBufferedReader("");

        bw1 = SingletonBufferedWriter.getBufferedWritter("");
        bw2 = SingletonBufferedWriter.getBufferedWritter("");
    }

    @Test
    public void testSingleton()
    {
        assertTrue(br1 == br2);
        assertTrue(bw1 == bw2);
    }
}
