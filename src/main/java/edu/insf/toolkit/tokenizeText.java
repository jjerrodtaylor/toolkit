package edu.insf.toolkit;


import edu.insf.toolkit.Models.BPage;
import edu.insf.toolkit.Tools.Constants;
import edu.insf.toolkit.Tools.FileHelper;
import edu.insf.toolkit.Tools.Languages;

import java.io.File;
import java.util.ArrayList;

public class tokenizeText {

    public static void main(final String args[])
    {
        File folder = new File(Constants.rawFilePath("eng"));
        FileHelper fileHelper = new FileHelper();
        BPage firstChapter = new BPage();
        File[] allFiles = folder.listFiles();
        //read the files into memory
        ArrayList<ArrayList<String>> allPages = new ArrayList<ArrayList<String>>();

        //for the english
        //read the files in
        for(int i=0;i<allFiles.length;i++)
        {
            String filePath = Constants.rawFilePath("/eng/metamorph_eng_"+String.valueOf(i)+".txt");
            //BPage pageToAddp = fileHelper.readFileToMemory(filePath);
            ArrayList<String> pageToAdd = fileHelper.readFileToMemory(filePath);
            allPages.add(pageToAdd);
        }

        int expectedBookSize = 11000;
        StringBuilder allPagesAsString = new StringBuilder(expectedBookSize);

        //build the string
        for(int i=0;i<allPages.size();i++)
        {
            allPagesAsString.append(" "+fileHelper.turnListToString(allPages.get(i))+" ");
        }

        allPages.clear();
        firstChapter.setUnTokenizedPage(allPagesAsString.toString());
        firstChapter.tokenize(Languages.ENGLISH);

        fileHelper.writeFile(firstChapter.getTokenizedPage(), Constants.partiallyprocessedFilePath("eng_ch_1.txt"));

    }
}
