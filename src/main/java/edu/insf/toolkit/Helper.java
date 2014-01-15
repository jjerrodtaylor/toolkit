package edu.insf.toolkit;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * A class containing helper functions for things that aren't directly related to neural networks
 **/
public class Helper {


    public Helper()
    {
        super();
    }


    /**
     * Generates a random double between the min and the max parameters
     * @param min
     * @param max
     * @return double
     */
    public static double generateRandomDouble(int min, int max)
    {
        return min + (double)(Math.random() * ((max - min) + 1));
    }


    /**
     *
     * @param s
     * @return
     */
    public String[] splitString(String s)
    {
        return s.split("(?!^)");
    }


}
