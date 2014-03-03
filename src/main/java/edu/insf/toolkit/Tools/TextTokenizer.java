package edu.insf.toolkit.Tools;

import edu.insf.toolkit.Tools.FileHelper;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

/**
 * http://en.wikipedia.org/wiki/List_of_ISO_639-2_codes
 */
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

    public ArrayList<String> tokenize(String text, Locale locale)
    {
        ArrayList<String> sentences = new ArrayList<String>();
        BreakIterator sentenceIterator = BreakIterator.getSentenceInstance(Locale.US);
        sentenceIterator.setText(text);
        int boundary = sentenceIterator.first();
        int lastBoundary = 0;
        while (boundary != BreakIterator.DONE)
        {
            boundary = sentenceIterator.next();
            if(boundary != BreakIterator.DONE)
            {
                sentences.add(text.substring(lastBoundary, boundary));
            }
            lastBoundary = boundary;
        }
        return sentences;
    }

    public ArrayList<String> tokenize(String text, String language)
    {
        ArrayList<String> sentences = new ArrayList<String>();
        Locale currentLocale = new Locale(language);
        BreakIterator sentenceIterator = BreakIterator.getSentenceInstance(currentLocale);
        sentenceIterator.setText(text);
        int boundary = sentenceIterator.first();
        int lastBoundary = 0;
        while (boundary != BreakIterator.DONE)
        {
            boundary = sentenceIterator.next();
            if(boundary != BreakIterator.DONE)
            {
                sentences.add(text.substring(lastBoundary, boundary));
            }
            lastBoundary = boundary;
        }
        return sentences;
    }

    public ArrayList<String> replaceNewLines(ArrayList<String> lines)
    {
        ArrayList<String> newLines = new ArrayList<String>();

        for(String s: lines)
        {
            String str = s.replaceAll("(\\n)"," ");
            newLines.add(str);
        }
        return newLines;
    }

    public ArrayList<ArrayList<String>> divideText(ArrayList<String> combinedText)
    {
        String[] newStrings;
        ArrayList<ArrayList<String>> seperatedTexts = new ArrayList<ArrayList<String>>();
        ArrayList<String> l1Text = new ArrayList<String>();
        ArrayList<String> l2Text = new ArrayList<String>();

        for(String s: combinedText)
        {
            newStrings = s.split("\\t");
            if(newStrings.length == 2)
            {
                l1Text.add(newStrings[0]);
                l2Text.add(newStrings[1]);
            }
            else
            {
                l1Text.add(newStrings[0]);
                l2Text.add("");
            }
        }

        seperatedTexts.add(l1Text);
        seperatedTexts.add(l2Text);

        return seperatedTexts;
    }




}
