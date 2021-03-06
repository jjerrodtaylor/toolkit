package edu.insf.toolkit.DesignPatterns.Singletons;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * For the uninitiated:
 * http://en.wikipedia.org/wiki/Singleton_pattern
 */

/**
 *
 */
public class SingletonBufferedWriter {

    private static BufferedWriter bw = null;

    /**
     *
     * @param nameOfFile
     * @return
     */
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

    /**
     *
     * @return
     */
    public static BufferedWriter getBufferedWritter()
    {
        return bw;
    }
}
