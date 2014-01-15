package edu.insf.toolkit;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class TextTokenizer
{
    //http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html#UK
    private Locale locale = null;
    private BreakIterator breakIterator = null;
    private FileHelper fHelper = new FileHelper();

    public TextTokenizer()
    {
        super();
    }

    public Locale getLocale()
    {
        return locale;
    }

    public void setLocale(Locale locale)
    {
        this.locale = locale;
    }

    public void setLocale(String language)
    {
        locale = new Locale(language);
    }

    public void setLocale(String language, String country)
    {
        locale = new Locale(language,country);
    }

    public void setLocale(String language, String country, String variant)
    {
        locale = new Locale(language,country,variant);
    }

    public ArrayList<String> tokenize(String text, Locale locale){
        ArrayList<String> sentences = new ArrayList<String>();
        BreakIterator sentenceIterator = BreakIterator.getSentenceInstance(Locale.US);
        sentenceIterator.setText(text);
        int boundary = sentenceIterator.first();
        int lastBoundary = 0;
        while (boundary != BreakIterator.DONE) {
            boundary = sentenceIterator.next();
            if(boundary != BreakIterator.DONE){
                sentences.add(text.substring(lastBoundary, boundary));
            }
            lastBoundary = boundary;
        }
        return sentences;
    }

    public ArrayList<String> tokenize(String text, String language, String country){
        ArrayList<String> sentences = new ArrayList<String>();
        Locale currentLocale = new Locale(language, country);
        BreakIterator sentenceIterator = BreakIterator.getSentenceInstance(currentLocale);
        sentenceIterator.setText(text);
        int boundary = sentenceIterator.first();
        int lastBoundary = 0;
        while (boundary != BreakIterator.DONE) {
            boundary = sentenceIterator.next();
            if(boundary != BreakIterator.DONE){
                sentences.add(text.substring(lastBoundary, boundary));
            }
            lastBoundary = boundary;
        }
        return sentences;
    }




}
