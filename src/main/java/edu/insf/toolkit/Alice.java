package edu.insf.toolkit;

import edu.insf.toolkit.HTML.HTMLPage;
import edu.insf.toolkit.Tools.Constants;
import edu.insf.toolkit.Tools.FileHelper;
import edu.insf.toolkit.Tools.TextExtractor;
import edu.insf.toolkit.Tools.TextTokenizer;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;


public class Alice
{
    public static void main(String args[])
    {
        FileHelper fileHelper = new FileHelper();
        TextExtractor textExtractor = new TextExtractor();
        TextTokenizer textTokenizer = new TextTokenizer();
        HTMLPage html = new HTMLPage();
        Constants constants = new Constants();

        //File file = fileHelper.turnToFile(constants.pdfs("alicia_es.pdf"));
        //ArrayList<String> book = textExtractor.getChapter(file,1,52);

        //fileHelper.writeFile(book ,constants.books("alicia_es.txt"));

        ArrayList<String> book = fileHelper.readFileToMemory(constants.books("alicia_es.txt"));
        ArrayList<String> noNewLines = textTokenizer.replaceNewLines(book);
        ArrayList<String> tokenized = textTokenizer.tokenize(noNewLines.toString(), "spa");
        fileHelper.writeFile(tokenized,constants.tokenized("alicia_es.txt"));


    }


}
