package edu.insf.toolkit;

import edu.insf.toolkit.DesignPatterns.FluidInterfaceHTML.HTMLPage;
import edu.insf.toolkit.Models.BPage;
import edu.insf.toolkit.Models.Chapter;
import edu.insf.toolkit.Models.ParallelPage;
import edu.insf.toolkit.Tools.Constants;
import edu.insf.toolkit.Tools.FileHelper;
import edu.insf.toolkit.Tools.Languages;

import java.io.File;
import java.util.ArrayList;

public class extractText {

    public static void main(final String args[])
    {
        FileHelper fileHelper = new FileHelper();
        BPage firstChapter;

        Constants.makeDirectory(fileHelper.turnToFile(Constants.rawFilePath(Languages.ENGLISH)));
        Constants.makeDirectory(fileHelper.turnToFile(Constants.rawFilePath(Languages.SPANISH)));
        //For the english pg 0-8 ch.1

        //get the text from the pdfs
        for(int i=0;i<8;i++)
        {
            firstChapter = new BPage();
            firstChapter.getPDFTextByPage(fileHelper.turnToFile(Constants.pdfFilePath("metamorph_eng.pdf")),i);
            fileHelper.writeFile(firstChapter.getUnTokenizedPage(),Constants.rawFilePath("/eng/metamorph_eng_"+String.valueOf(i)+".txt"));
        }

        //do manual editing at this step.
    }
}
