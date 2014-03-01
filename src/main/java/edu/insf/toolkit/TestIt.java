package edu.insf.toolkit;

import edu.insf.toolkit.Models.BPage;
import edu.insf.toolkit.Models.Chapter;
import edu.insf.toolkit.Models.ParallelPage;
import edu.insf.toolkit.Tools.Constants;
import org.odftoolkit.simple.TextDocument;
import java.io.File;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import edu.insf.toolkit.DesignPatterns.FluidInterfaceHTML.*;
import edu.insf.toolkit.Tools.FileHelper;
import edu.insf.toolkit.Tools.Languages;

public class TestIt {

    public static void main(final String args[])
    {
        FileHelper fileHelper = new FileHelper();
        ArrayList<String> chapter1 = fileHelper.readFileToMemory(Constants.alignedFilePath("aligned_eng-esp.txt"));
        ParallelPage page = new ParallelPage();
        LinkedList<LinkedList<String>> seperatedTexts = page.divideLadderText(chapter1);

        try
        {
            TextDocument textDocument = TextDocument.newTextDocument();

            int pagesInChapter = 8;
            int sectionsPerPage = seperatedTexts.get(0).size()/pagesInChapter;
            int j = 0;
            for(double i=seperatedTexts.get(1).size(); i> -1;i = i-.5)
            {
                if(j<sectionsPerPage)
                {
                    textDocument.addParagraph(seperatedTexts.get(0).pollFirst());
                    j++;
                }
                else
                {
                    textDocument.addParagraph(seperatedTexts.get(1).pollFirst());
                    j++;

                    if(j==sectionsPerPage*2)
                    {
                        j= 0;
                    }
                }
            }
            textDocument.save("chapter1.odt");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
