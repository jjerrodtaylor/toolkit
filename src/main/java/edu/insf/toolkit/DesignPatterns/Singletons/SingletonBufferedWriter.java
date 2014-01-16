package edu.insf.toolkit.DesignPatterns.Singletons;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 1/15/14
 * Time: 5:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class SingletonBufferedWriter {

    private static BufferedWriter bw = null;

    public static BufferedWriter getBufferedWritter(String nameOfFile)
    {
        if(bw == null)
        {
            try
            {
                bw = new BufferedWriter(new FileWriter(nameOfFile));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return bw;
    }

    public static BufferedWriter getBufferedWritter()
    {
        return bw;
    }
}
