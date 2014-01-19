package edu.insf.toolkit;

import edu.insf.toolkit.Constants;
import edu.insf.toolkit.TextTokenizer;
import edu.insf.toolkit.TextExtractor;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import edu.insf.toolkit.DesignPatterns.FluidInterfaceHTML.*;
import edu.insf.toolkit.Hunalign;

public class TestIt {

    public static void main(final String args[])
    {
        FileHelper fileHelper = new FileHelper();
        TextExtractor textExtractor = new TextExtractor();
        TextTokenizer textTokenizer = new TextTokenizer();
        HTMLPage html = new HTMLPage();
        Hunalign aligner = new Hunalign();

        //For the english
        File file = fileHelper.turnToFile(Constants.METAMORPH_ENG);
        String firstPage = textExtractor.getPDFTextByPage(file, 0);
        fileHelper.writeFile(firstPage, Constants.METAMORPH_ENG_TXT);

        ArrayList<String> list = textTokenizer.tokenize(firstPage, Locale.US);
        list = textTokenizer.replaceNewLines(list);
        fileHelper.writeFile(list, Constants.METAMORPH_ENG_TXT_FMT);

        //For the spanish
        file = fileHelper.turnToFile(Constants.METAMORPH_ESP);
        firstPage = textExtractor.getPDFTextByPage(file, 1);
        fileHelper.writeFile(firstPage, Constants.METAMORPH_ESP_TXT);

        list = textTokenizer.tokenize(firstPage,"spa");
        list = textTokenizer.replaceNewLines(list);
        fileHelper.writeFile(list, Constants.METAMORPH_ESP_TXT_FMT);

        //The combined languages
        ArrayList<String> combinedText = fileHelper.readFileToMemory(Constants.METAMORPH_ENG_ESP_TXT);
        ArrayList<ArrayList<String>> seperateTexts = textTokenizer.divideText(combinedText);

        String page = html.makePage(seperateTexts);
        fileHelper.writeFile(page,"testpage.html");

        aligner.runHunalign();

        int i=0;
    }
}
