package edu.insf.toolkit;

/**
 * A file of static constants that will be used through out the nn architectures.
 */
public class Constants
{
    public static String READ_FILE_NAME = null;
    public static String WRITE_FILE_NAME = null;
    public static String METAMORPH_ENG = "/Users/jamaaltaylor/Documents/toolkit/src/test/resources/metamorph_eng.pdf";
    public static String METAMORPH_ESP = "/Users/jamaaltaylor/Documents/toolkit/src/test/resources/metamorph_esp.pdf";
    public static String METAMORPH_ENG_TXT = "/Users/jamaaltaylor/Documents/toolkit/src/test/resources/metamorph_eng.txt";
    public static String METAMORPH_ESP_TXT = "/Users/jamaaltaylor/Documents/toolkit/src/test/resources/metamorph_esp.txt";
    public static String METAMORPH_ENG_TXT_FMT = "/Users/jamaaltaylor/Documents/toolkit/src/test/resources/metamorph_eng_fmt.txt";
    public static String METAMORPH_ESP_TXT_FMT = "/Users/jamaaltaylor/Documents/toolkit/src/test/resources/metamorph_esp_fmt.txt";

    public void setREAD_FILE_NAME(String file_name)
    {
        READ_FILE_NAME = file_name;
    }

    public void setWRITE_FILE_NAME(String file_name)
    {
        WRITE_FILE_NAME = file_name;
    }
}
