package edu.insf.toolkit;

import java.io.*;
import java.util.ArrayList;

public class FileHelper {

    private BufferedWriter bw = null;
    private BufferedReader br = null;

    public BufferedWriter getBufferedWritter(String nameOfFile)
    {
        if(bw == null)
        {
            try
            {
                bw = new BufferedWriter(new FileWriter(nameOfFile));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return bw;
    }

    public BufferedWriter getBufferedWritter()
    {
        return bw;
    }

    public BufferedReader getBufferedReader(String nameOfFile)
    {
        if(br == null)
        {
            try
            {
                br = new BufferedReader(new FileReader(nameOfFile));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return br;
    }


    public BufferedReader getBufferedReader()
    {
        return br;
    }

    public void killBufferedReader()
    {
        BufferedReader br = this.getBufferedReader();
        br = null;
    }

    public void killBufferedWritter()
    {
        BufferedWriter bw = this.getBufferedWritter();
        bw = null;
    }

    /**
     * Function takes an Arraylist of Strings as well as the path for where the file should be written to.
     * @param linesToWrite
     * @param nameOfFile
     */
    public void writeFile(ArrayList<String> linesToWrite, String nameOfFile)
    {

        bw = this.getBufferedWritter(nameOfFile);

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
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFileToMemory(String filepath)
    {
        BufferedReader br = this.getBufferedReader(filepath);
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
