package edu.insf.toolkit.Models;

import com.snowtide.pdf.OutputTarget;
import com.snowtide.pdf.PDFTextStream;
import com.snowtide.pdf.Page;
import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

public class BPage
{
    //http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html#UK
    private Locale locale = null;
    private BreakIterator breakIterator = null;
    private String unTokenizedPage = null;
    private ArrayList<String> tokenizedPage = new ArrayList<String>();

    public BPage()
    {
        super();
    }

    public void setUnTokenizedPage(String page)
    {
        this.unTokenizedPage = page;
    }

    public void setTokenizedPage(ArrayList<String> page)
    {
        this.tokenizedPage = page;
    }

    public String getUnTokenizedPage()
    {
        return this.unTokenizedPage;
    }

    public ArrayList<String> getTokenizedPage()
    {
        return this.tokenizedPage;
    }

    public void getPDFTextByPage(File pdfFile, int pageNumber)
    {
        StringBuffer sb = new StringBuffer();
        BPage bPage = new BPage();
        try
        {
            PDFTextStream stream = new PDFTextStream(pdfFile);
            //A string buffer is like a String, but can be modified.
            OutputTarget target = new OutputTarget(sb);
            Page page = stream.getPage(pageNumber);
            page.pipe(target);
            stream.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        this.unTokenizedPage = sb.toString();
    }

    public void tokenize(String language)
    {
        ArrayList<String> sentences = new ArrayList<String>();
        Locale currentLocale = new Locale(language);
        BreakIterator sentenceIterator = BreakIterator.getSentenceInstance(currentLocale);
        sentenceIterator.setText(this.unTokenizedPage);
        int boundary = sentenceIterator.first();
        int lastBoundary = 0;
        while (boundary != BreakIterator.DONE)
        {
            boundary = sentenceIterator.next();
            if(boundary != BreakIterator.DONE)
            {
                this.tokenizedPage.add(this.unTokenizedPage.substring(lastBoundary, boundary));
            }
            lastBoundary = boundary;
        }
    }

    public void replaceNewLines()
    {
        ArrayList<String> newLines = this.tokenizedPage;
        ArrayList<String> lines = new ArrayList<String>();
        this.tokenizedPage = null;

        for(String s: newLines)
        {
            String str = s.replaceAll("(\\n)"," ");
            lines.add(str);
        }
        this.tokenizedPage = lines;
    }

    public void writePage()
    {

    }
}
