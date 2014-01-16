package edu.insf.toolkit;

import edu.insf.toolkit.DesignPatterns.Singletons.SingletonBufferedReader;
import edu.insf.toolkit.DesignPatterns.Singletons.SingletonBufferedWriter;
import edu.insf.toolkit.DesignPatterns.Factory.*;

import java.io.*;
import java.util.ArrayList;

public class FileHelper {

    public File turnToFile(String filePath)
    {
        File file = new File(filePath);
        return file;
    }

    public void writeFile(String stringToWrite, String nameOfFile)
    {
        IOBufferedWriter  bw = IOFactory.buildIOBufferedWriter(nameOfFile);
        try
        {
            bw.getBufferedWriter().write(stringToWrite);
            bw.getBufferedWriter().newLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Function takes an Arraylist of Strings as well as the path for where the file should be written to.
     * @param linesToWrite
     * @param nameOfFile
     */
    public void writeFile(ArrayList<String> linesToWrite, String nameOfFile)
    {
        IOBufferedWriter  bw = IOFactory.buildIOBufferedWriter(nameOfFile);

        for(String s: linesToWrite)
        {
            try
            {
                bw.getBufferedWriter().write(s);
                bw.getBufferedWriter().newLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            bw.getBufferedWriter().flush();
            bw.getBufferedWriter().close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFileToMemory(String filepath)
    {
        IOBufferedReader br = IOFactory.buildIOBufferedReader(filepath);
        String currentLine = null;
        ArrayList<String> fileContents = new ArrayList<String>();

        try
        {
            while((currentLine = br.getBufferedReader().readLine()) != null)
            {
                fileContents.add(currentLine);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                br.getBufferedReader().close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        return fileContents;
    }

    public String turnListToString(ArrayList<String> listOfStrings)
    {
        String longString = "";

        for(int i =0; i < listOfStrings.size()-1; i++)
        {
            longString += listOfStrings.get(i);
        }
        return longString;
    }

}
