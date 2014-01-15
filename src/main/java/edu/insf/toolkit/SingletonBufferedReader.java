package edu.insf.toolkit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 1/15/14
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class SingletonBufferedReader {

    private static BufferedReader br = null;

    public static BufferedReader getBufferedReader(String nameOfFile)
    {
        if(br == null)
        {
            try
            {
                br = new BufferedReader(new FileReader(nameOfFile));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return br;
    }


    public static BufferedReader getBufferedReader()
    {
        return br;
    }
}
