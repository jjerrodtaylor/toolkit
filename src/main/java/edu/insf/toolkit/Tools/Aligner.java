package edu.insf.toolkit.Tools;

import edu.*;
import edu.main.NewCommandLineArguments;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 5/22/14
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class Aligner
{
    public static void main(String args[])
    {
        Constants constants = new Constants();

        NewCommandLineArguments metamorphDE = new NewCommandLineArguments(constants.jmaxalign("files/settings.txt"));


    }
}
