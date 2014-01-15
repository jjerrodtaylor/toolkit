package edu.insf.toolkit;

import java.io.*;
import java.util.ArrayList;

public class FileHelper {

    private BufferedWriter bw = null;
    public File turnToFile(String filePath)
    {
        File file = new File(filePath);
        return file;
    }


    public void writeFile(String stringToWrite, String nameOfFile)
    {
        bw = SingletonBufferedWritter.getBufferedWritter(nameOfFile);
        try
        {
            bw.write(stringToWrite);
            bw.newLine();
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
        BufferedWriter bw = SingletonBufferedWritter.getBufferedWritter(nameOfFile);

        for(String s: linesToWrite)
        {
            try
            {
                bw.write(s);
                bw.newLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            bw.flush();
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFileToMemory(String filepath)
    {
        BufferedReader br = SingletonBufferedReader.getBufferedReader(filepath);
        String currentLine = null;
        ArrayList<String> fileContents = new ArrayList<String>();

        try
        {
            while((currentLine = br.readLine()) != null)
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
                br.close();
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
