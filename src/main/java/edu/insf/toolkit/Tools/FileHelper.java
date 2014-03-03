package edu.insf.toolkit.Tools;

import edu.insf.toolkit.DesignPatterns.IOTypeFactory.*;

import java.io.*;
import java.util.ArrayList;

public class FileHelper {
    IOBufferedWriter  bw = null;
    IOBufferedReader br = null;

    public File turnToFile(String filePath)
    {
        File file = new File(filePath);
        return file;
    }

    public void writeFile(String stringToWrite, String nameOfFile)
    {
        this.bw = IOFactory.buildIOBufferedWriter(nameOfFile);
        try
        {
            this.bw.getBufferedWriter().write(stringToWrite);
            this.bw.getBufferedWriter().newLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                this.bw.getBufferedWriter().flush();
                this.bw.getBufferedWriter().close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


    /**
     * Function takes an Arraylist of Strings as well as the path for where the file should be written to.
     * @param linesToWrite
     * @param nameOfFile
     */
    public void writeFile(ArrayList<String> linesToWrite, String nameOfFile)
    {
        this.bw = IOFactory.buildIOBufferedWriter(nameOfFile);

        for(String s: linesToWrite)
        {
            try
            {
                this.bw.getBufferedWriter().write(s);
                this.bw.getBufferedWriter().newLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            this.bw.getBufferedWriter().flush();
            this.bw.getBufferedWriter().close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFileToMemory(String filepath)
    {
        this.br = IOFactory.buildIOBufferedReader(filepath);
        String currentLine = null;
        ArrayList<String> fileContents = new ArrayList<String>();

        try
        {
            while((currentLine = this.br.getBufferedReader().readLine()) != null)
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
                this.br.getBufferedReader().close();
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
