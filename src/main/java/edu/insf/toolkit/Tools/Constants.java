package edu.insf.toolkit.Tools;

import java.io.File;

/**
 * A file of static constants that will be used through out the nn architectures.
 */
public class Constants
{
    public static String READ_FILE_NAME = null;
    public static String WRITE_FILE_NAME = null;
    public static String METAMORPH_ENG = Constants.makeFilePath("/src/test/resources/pdf/metamorph_eng.pdf");
    public static String METAMORPH_ESP = Constants.makeFilePath("/src/test/resources/pdf/metamorph_esp.pdf");
    public static String METAMORPH_ENG_TXT = Constants.makeFilePath("/src/test/resources/metamorph_eng.txt");
    public static String METAMORPH_ESP_TXT = Constants.makeFilePath("/src/test/resources/metamorph_esp.txt");
    public static String METAMORPH_ENG_TXT_FMT = Constants.makeFilePath("/src/test/resources/metamorph_eng_fmt.txt");
    public static String METAMORPH_ESP_TXT_FMT = Constants.makeFilePath("/src/test/resources/metamorph_esp_fmt.txt");
    public static String TEST_FILE = Constants.makeFilePath("/src/test/resources/testfile.txt");
    public static String METAMORPH_ENG_ESP_TXT = Constants.makeFilePath("/src/test/resources/fullyprocessed/Kafka_Franz-Verwandlung-en-es.txt");

    public static String makeFilePath(String addition)
    {
        String filePath = new File("").getAbsolutePath();
        filePath = filePath+addition;
        return filePath;
    }

    public void setREAD_FILE_NAME(String file_name)
    {
        READ_FILE_NAME = file_name;
    }

    public void setWRITE_FILE_NAME(String file_name)
    {
        WRITE_FILE_NAME = file_name;
    }
}
