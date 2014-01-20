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
        BPage firstPage = new BPage();
        ParallelPage parallelPage = new ParallelPage();
        HTMLPage html = new HTMLPage();
        Chapter chapter = new Chapter();
        Hunalign aligner = new Hunalign();

        //For the english
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

        //The combined languages
        ArrayList<String> combinedText = fileHelper.readFileToMemory(Constants.METAMORPH_ENG_ESP_TXT);
        parallelPage.divideLadderText(combinedText);

        String page = html.makePage(parallelPage);
        fileHelper.writeFile(page,"testpage.html");
        ArrayList<ParallelPage> listOfPages = new ArrayList<ParallelPage>();
        listOfPages.add(parallelPage);

        chapter.writeChapter(listOfPages,1);
    }
}
