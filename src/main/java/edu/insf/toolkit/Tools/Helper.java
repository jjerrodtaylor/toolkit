package edu.insf.toolkit.Tools;

import edu.insf.toolkit.Tools.Pattern;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


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

    public static ArrayList<Pattern<Double>> turnListToPattern(ArrayList<String> listOfStrings)
    {
        //I'm just going to assume that they are all integers for right now.
        StringTokenizer st;
        ArrayList<Pattern<Double>> patterns = new ArrayList<Pattern<Double>>();

        for(String s:listOfStrings)
        {
            st = new StringTokenizer(s,",");
            int numberOfTokens = st.countTokens();
            //create a new input pattern
            Pattern<Double> patternSet = new Pattern<Double>();

            for(int i = 0; i< numberOfTokens;i++)
            {
                //get the values for the input set
                if(i <= numberOfTokens-2)
                {
                    //set the input pattern
                    patternSet.getInputSet().add(Double.parseDouble(st.nextToken()));
                }

                if(i == numberOfTokens-1)
                {
                    patternSet.getOutputSet().add(Double.parseDouble(st.nextToken()));
                }
            }

            //add the pattern to the list
            patterns.add(patternSet);
        }

        return patterns;
    }
}
