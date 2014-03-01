package edu.insf.toolkit.Tools;

import edu.insf.toolkit.DesignPatterns.FluidInterfaceHTML.HTMLPage;
import edu.insf.toolkit.DesignPatterns.IOTypeFactory.*;
import edu.insf.toolkit.Hunalign;
import edu.insf.toolkit.Models.BPage;
import edu.insf.toolkit.Models.Chapter;
import edu.insf.toolkit.Models.ParallelPage;
import org.odftoolkit.simple.TextDocument;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public void writeFile(String stringToWrite, String nameOfFile, boolean append)
    {
        this.bw = IOFactory.buildIOBufferedWriter(nameOfFile, append);
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
    public void writeFile(List<String> linesToWrite, String nameOfFile)
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

    public void writeFile(List<String> linesToWrite, String nameOfFile, boolean append)
    {
        this.bw = IOFactory.buildIOBufferedWriter(nameOfFile, append);

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
                LinkedList<String> page = pages.get(i).getTokenizedPage();
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

    public void writeChapter(int startNumber, int endNumber, String language, String fileName1, String fileName2, String fileName3)
    {
        FileHelper fileHelper = new FileHelper();
        BPage firstPage = new BPage();
        Chapter chapter = new Chapter();
        ArrayList<BPage> pages = new ArrayList<BPage>();

        //get the text from the pdf as a page and write the entire chapter as one file
        File file = fileHelper.turnToFile(fileName1);
        for(int i=startNumber;i<endNumber;i++)
        {
            firstPage.getPDFTextByPage(file,i);
            fileHelper.writeFile(firstPage.getUnTokenizedPage(), fileName2,true);
        }

        //read the new file back in and turn it into a string
        ArrayList<String> firstChapter = fileHelper.readFileToMemory(fileName2);
        String firstChapterAsString = fileHelper.turnListToString(firstChapter);
        firstPage.setUnTokenizedPage(firstChapterAsString);
        fileHelper.writeFile(firstPage.getUnTokenizedPage(),Constants.partiallyprocessedFilePath("test.txt"));
        //tokenize the page and write the file
        firstPage.tokenize(language);
        firstPage.replaceNewLines();
        fileHelper.writeFile(firstPage.getTokenizedPage(), fileName3,true);
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
        StringBuilder longString = new StringBuilder(11000);

        for(int i =0; i < listOfStrings.size()-1; i++)
        {
            longString.append(" ");
            longString.append(listOfStrings.get(i));
            longString.append(" ");
        }
        return longString.toString();
    }

}
