package edu.insf.toolkit.Tools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *  The formalized pattern set.
 *  Pattern Set: S = {I,O}
 *  where I is a set of input patterns and O is a set of corresponding desired output patterns.
 *
 *  Input Set: I = {P k,j}
 *  where k is the input pattern number and j is the input pattern component.
 *
 *  Output Set: O = {O k,j}
 *  where k is the desired output pattern number and j is the desired output pattern component.
 *
 *  I use Generics so that your Pattern objects can hold any type.
 * @param <T>
 */
public class Pattern<T extends Comparable<T>> {

    public LinkedList<T> inputSet;
    public LinkedList<T> outputSet;

    /**
     * Constructor
     */
    public Pattern()
    {
        super();
        inputSet = new LinkedList<T>();
        outputSet = new LinkedList<T>();
    }

    /**
     * Returns the number of elements in the input pattern set.
     * @return int
     */
    public int getInputPatternSize() {
        return inputSet.size();
    }

    /**
     * Returns the number of elements in the output pattern set.
     * @return int
     */
    public int getOutputPatternSize() {
        return outputSet.size();
    }

    /**
     * Returns the input pattern set.
     * @return LinkedList<T>
     */
    public LinkedList<T> getInputSet() {
        return inputSet;
    }

    /**
     * Set the input pattern set.
     * @param inputSet
     */
    public void setInputSet(LinkedList<T> inputSet) {
        this.inputSet = inputSet;
    }

    /**
     * Returns the output pattern set.
     * @return LinkedList<T>
     */
    public LinkedList<T> getOutputSet() {
        return outputSet;
    }

    /**
     * Sets the output pattern set.
     * @param outputSet
     */
    public void setOutputSet(LinkedList<T> outputSet) {
        this.outputSet = outputSet;
    }

    /**
     * Allows you to get a value from a specific index from the input pattern set.
     * @param index
     * @return T
     */
    public T getInputPatternValue(int index)
    {
        return this.getInputSet().get(index);
    }

    /**
     * Allows you to set a value to the end of the input pattern set.
     * @param value
     */
    public void setInputPatternValue(T value)
    {
        this.getInputSet().add(value);
    }

    /**
     * Allows you to set a value at a specific index of the input pattern set.
     * @param value
     * @param index
     */
    public void setInputPatternValueAtIndex(T value, int index)
    {
        this.getInputSet().add(index,value);
    }

    /**
     * Allows you to get a value from a specific index from the output pattern set.
     * @param index
     * @return T
     */
    public T getOutputPatternValue(int index)
    {
        return this.getOutputSet().get(index);
    }

    /**
     * Allows you to set a value to the end of the output pattern set.
     * @param value
     */
    public void setOutputPatternValue(T value)
    {
        this.getOutputSet().add(value);
    }

    /**
     * Allows you to set a value at a specific index of the output pattern set.
     * @param value
     * @param index
     */
    public void setOutputPatternValueAtIndex(T value, int index)
    {
        this.getOutputSet().add(index, value);
    }

    public ArrayList<Pattern<Double>> turnListToPattern(ArrayList<String> listOfStrings)
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

    /**
     *
     * @param percentToPartition
     * @param dataSet
     * @return
     */
    public ArrayList<Pattern<Double>> partitionDataSet(Double percentToPartition, ArrayList<Pattern<Double>> dataSet)
    {
        ArrayList<Pattern<Double>> newList = new ArrayList<Pattern<Double>>();
        int lengthOfDataSet = dataSet.size();
        double partToPartition = lengthOfDataSet * percentToPartition;

        for(int i = 0; i<(int)partToPartition;i++)
        {
            newList.add(dataSet.get(i));
        }

        return newList;
    }
}
