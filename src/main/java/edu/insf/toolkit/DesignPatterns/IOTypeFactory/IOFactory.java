package edu.insf.toolkit.DesignPatterns.IOTypeFactory;


public class IOFactory
{
    public static IOBufferedWriter buildIOBufferedWriter(String filePath)
    {
        return new IOBufferedWriter(filePath);
    }

    public static IOBufferedReader buildIOBufferedReader(String filePath)
    {
        return new IOBufferedReader(filePath);
    }
}
