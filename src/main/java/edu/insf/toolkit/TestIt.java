package edu.insf.toolkit;

import edu.insf.toolkit.Constants;
import edu.insf.toolkit.TextTokenizer;
import edu.insf.toolkit.TextExtractor;

import java.io.BufferedWriter;
import java.io.File;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class TestIt {

    public static void main(final String args[])
    {
        FileHelper fileHelper = new FileHelper();
        TextExtractor textExtractor = new TextExtractor();
        TextTokenizer textTokenizer = new TextTokenizer();
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        File file = fileHelper.turnToFile(Constants.METAMORPH_ENG);
        String firstPage = textExtractor.getPDFTextByPage(file,0);
        fileHelper.writeFile(firstPage,Constants.METAMORPH_ENG_TXT);
        fileHelper.writterFlushClose();
        fileHelper.killBufferedWritter();
        ArrayList<String> list = textTokenizer.tokenize(firstPage,Locale.US);

        fileHelper.writeFile(list,Constants.METAMORPH_ENG_TXT_FMT);
    }
}
