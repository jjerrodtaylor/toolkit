package edu.insf.toolkit.Tools;

import edu.insf.toolkit.DesignPatterns.IOTypeFactory.*;
import edu.insf.toolkit.Models.BPage;
import org.odftoolkit.simple.TextDocument;
import java.io.*;
import java.util.ArrayList;

public class FileHelper {
    IOBufferedWriter  bw = null;
    IOBufferedReader br = null;
    TextDocument textDocument = null;

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

    public void writeFileAsODTFile(ArrayList<BPage> pages, String nameOfFile)
    {
        try
        {
            textDocument = TextDocument.newTextDocument();

            //go through each page
            for(int i=0;i<pages.size();i++)
            {
                //go through each paragraph in the page
                ArrayList<String> page = pages.get(i).getTokenizedPage();
                for(int j=0;j<page.size();j++)
                {
                    textDocument.addParagraph(page.get(j));
                }
            }

            textDocument.save(nameOfFile);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void writeChapter(ArrayList<ArrayList<String>>  chapter, int chapterNumber)
    {
        String nameOfFile = "chapter";

        //you have to make the loop twice as big because you have two books
        for(double i = 0; i<chapter.size();i=i+.5)
        {
            nameOfFile = "chapter"+"_"+String.valueOf(chapterNumber)+"_page_"+String.valueOf(i)+".txt";
            this.bw = IOFactory.buildIOBufferedWriter(nameOfFile);

            try
            {
                //if you are on an odd page
                if(i%1 == 0)
                {
                    this.bw.getBufferedWriter().write(chapter.get(0).get((int)i));
                }
                else
                {
                    this.bw.getBufferedWriter().write(chapter.get(1).get((int)i));
                }

                this.bw.getBufferedWriter().flush();
                this.bw.getBufferedWriter().close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
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
