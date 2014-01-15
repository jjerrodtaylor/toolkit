package edu.insf.toolkit;

import java.text.BreakIterator;
import java.util.Locale;

public class TextTokenizer
{
    //http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html#UK
    private Locale locale = null;
    private BreakIterator breakIterator = null;


    public Locale getLocale()
    {
        return locale;
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
}
