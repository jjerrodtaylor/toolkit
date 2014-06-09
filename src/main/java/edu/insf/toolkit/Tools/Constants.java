package edu.insf.toolkit.Tools;

import java.io.File;

/**
 * A file of static constants that will be used through out the nn architectures.
 */
public class Constants
{
    private String resourcesRoot = "/src/test/resources";
    private String root = "/src/";
    public static String TEST_FILE = Constants.makeFilePath("/src/test/resources/testfile.txt");
    public static String READ_FILE_NAME = null;
    public static String WRITE_FILE_NAME = null;
    public static String METAMORPH_ESP = Constants.makeFilePath("/src/test/resources/pdf/metamorph_esp.pdf");


    public Constants()
    {
        super();
    }

    public String getRoot()
    {
        return Constants.makeFilePath(root);
    }

    public String pdfs(String fileName)
    {
        String address = resourcesRoot+"/pdfs/"+fileName;
        return Constants.makeFilePath(address);
    }

    public String jmaxalign(String fileName)
    {
        String address = resourcesRoot+"/jmaxalign/"+fileName;
        return Constants.makeFilePath(address);
    }
    
    public String books(String fileName)
    {
        String address = resourcesRoot+"/books/"+fileName;
        return Constants.makeFilePath(address);
    }

    public String tokenized(String fileName)
    {
        String address = resourcesRoot+"/tokenized/"+fileName;
        return Constants.makeFilePath(address);
    }

    public String processed(String fileName)
    {
        String address = resourcesRoot+"/processed/"+fileName;
        return Constants.makeFilePath(address);
    }

    public String aligned(String fileName)
    {
        String address = resourcesRoot+"/aligned/"+fileName;
        return Constants.makeFilePath(address);
    }

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
