package edu.insf.toolkit;

import edu.insf.toolkit.Models.BPage;
import edu.insf.toolkit.Models.Chapter;
import edu.insf.toolkit.Models.ParallelPage;
import edu.insf.toolkit.Tools.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import edu.insf.toolkit.DesignPatterns.FluidInterfaceHTML.*;
import edu.insf.toolkit.Tools.FileHelper;
import edu.insf.toolkit.Tools.Languages;

public class TestIt {

    public static void main(final String args[])
    {
        FileHelper fileHelper = new FileHelper();
        BPage firstChapter = new BPage();
        ParallelPage parallelPage = new ParallelPage();
        HTMLPage html = new HTMLPage();
        Chapter chapter = new Chapter();
        Hunalign aligner = new Hunalign();
        ArrayList<BPage> pages = new ArrayList<BPage>();

        //For the english pg 1-8 ch.1

        //get the text from the pdfs
        for(int i=0;i<8;i++)
        {
            BPage page = new BPage();
            page.getPDFTextByPage(fileHelper.turnToFile(Constants.pdfFilePath("metamorph_eng.pdf")),i);
            fileHelper.writeFile(page.getUnTokenizedPage(),Constants.rawFilePath("metamorph_eng_"+String.valueOf(i)+".txt"));
        }

        File folder = new File(Constants.rawFilePath(""));
        File[] allFiles = folder.listFiles();
        //read the files into memory
        ArrayList<ArrayList<String>> allPages = new ArrayList<ArrayList<String>>();

        for(int i=0;i<allFiles.length;i++)
        {
            String filePath = Constants.rawFilePath("metamorph_eng_"+String.valueOf(i)+".txt");
            ArrayList<String> pageToAdd = fileHelper.readFileToMemory(filePath);
            allPages.add(pageToAdd);
        }

        String allPagesAsString = "";

        for(int i=0;i<allPages.size();i++)
        {
            allPagesAsString = allPagesAsString+fileHelper.turnListToString(allPages.get(i));
        }

        firstChapter.setUnTokenizedPage(allPagesAsString);
        firstChapter.tokenize(Languages.ENGLISH);



        /*
        File file = fileHelper.turnToFile(Constants.METAMORPH_ENG);
        firstPage.getPDFTextByPage(file,0);
        fileHelper.writeFile(firstPage.getUnTokenizedPage(), Constants.METAMORPH_ENG_TXT);

        firstPage.tokenize(Languages.ENGLISH);
        firstPage.replaceNewLines();
        fileHelper.writeFile(firstPage.getTokenizedPage(), Constants.METAMORPH_ENG_TXT_FMT);

        //For the spanish
        file = fileHelper.turnToFile(Constants.METAMORPH_ESP);
        firstPage.getPDFTextByPage(file, 1);
        fileHelper.writeFile(firstPage.getUnTokenizedPage(), Constants.METAMORPH_ESP_TXT);

        firstPage.tokenize(Languages.SPANISH);
        firstPage.replaceNewLines();
        fileHelper.writeFile(firstPage.getTokenizedPage(), Constants.METAMORPH_ESP_TXT_FMT);

        String page = html.makePage(parallelPage);
        fileHelper.writeFile(page,"testpage.html");
        ArrayList<ParallelPage> listOfPages = new ArrayList<ParallelPage>();
        listOfPages.add(parallelPage);

        chapter.writeChapter(listOfPages,1); */
    }
}
