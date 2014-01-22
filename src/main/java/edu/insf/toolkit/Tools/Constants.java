package edu.insf.toolkit.Tools;

import java.io.File;

/**
 * A file of static constants that will be used through out the nn architectures.
 */
public class Constants
{
    private static String filePath = "";

    public static String READ_FILE_NAME = null;
    public static String WRITE_FILE_NAME = null;
    public static String RAW = Constants.makeFilePath("/src/test/resources/raw/");
    public static String PDF = Constants.makeFilePath("/src/test/resources/pdf/");
    public static String PARTIALLY_PROCESSED = Constants.makeFilePath("/src/test/resources/partiallyprocessed/");
    public static String FULLY_PROCESSED = Constants.makeFilePath("/src/test/resources/fullyprocessed/");
    public static String ALIGNED = Constants.makeFilePath("/src/test/resources/aligned/");
    public static String ODT = Constants.makeFilePath("/src/test/resources/odt");

    public static String METAMORPH_ENG = Constants.makeFilePath("/src/test/resources/pdf/metamorph_eng.pdf");
    public static String METAMORPH_ESP = Constants.makeFilePath("/src/test/resources/pdf/metamorph_esp.pdf");
    public static String METAMORPH_ENG_TXT = Constants.makeFilePath("/src/test/resources/raw/metamorph_eng.txt");
    public static String METAMORPH_ESP_TXT = Constants.makeFilePath("/src/test/resources/raw/metamorph_esp.txt");
    public static String METAMORPH_ENG_TXT_FMT = Constants.makeFilePath("/src/test/resources/partiallyprocessed/metamorph_eng_fmt.txt");
    public static String METAMORPH_ESP_TXT_FMT = Constants.makeFilePath("/src/test/resources/partiallyprocessed/metamorph_esp_fmt.txt");
    public static String TEST_FILE = Constants.makeFilePath("/src/test/resources/testfile.txt");
    public static String METAMORPH_ENG_ESP_TXT = Constants.makeFilePath("/src/test/resources/aligned/metamorph-en-es.txt");

    public static String makeFilePath(String addition)
    {
        String filePath = new File("").getAbsolutePath();
        filePath = filePath+addition;
        return filePath;
    }

    public static String pdfFilePath(String nameOfFile)
    {
        return Constants.filePath = Constants.PDF+nameOfFile;
    }

    public static String rawFilePath(String nameOfFile)
    {
        return Constants.filePath = Constants.RAW+nameOfFile;
    }

    public static String partiallyprocessedFilePath(String nameOfFile)
    {
        return Constants.filePath = Constants.PARTIALLY_PROCESSED+nameOfFile;
    }

    public static String fullyprocessedFilePath(String nameOfFile)
    {
        return Constants.filePath = Constants.FULLY_PROCESSED+nameOfFile;
    }

    public static String alignedFilePath(String nameOfFile)
    {
        return Constants.filePath = Constants.ALIGNED+nameOfFile;
    }

    public static String odtFilePath(String nameOfFile)
    {
        return Constants.filePath = Constants.ODT+nameOfFile;
    }

    public static boolean makeDirectory(File dir)
    {
        boolean result = false;
        if(!dir.exists())
        {
            result = dir.mkdir();
        }
        return result;
    }
}
