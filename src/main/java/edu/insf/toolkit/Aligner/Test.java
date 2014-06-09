package edu.insf.toolkit.Aligner;

import edu.*;
import edu.insf.toolkit.Tools.Constants;
import edu.insf.toolkit.Tools.FileHelper;
import edu.main.JAligner;
import edu.main.NewCommandLineArguments;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 6/9/14
 * Time: 8:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class Test
{

    public static void main(String args[])
    {
        NewCommandLineArguments cmds = new NewCommandLineArguments("/Users/jamaaltaylor/Documents/toolkit/settings.txt");
        FileHelper fHelper = new FileHelper();
        Constants constants = new Constants();
        JAligner aligner = new JAligner(cmds);

        fHelper.createTrainingFile(constants.tokenized("metamorphosis_de.txt"),cmds,"de.train" );
        fHelper.createTrainingFile(constants.tokenized("metamorphosis_en.txt"),cmds,"en.train");

        fHelper.createTestingFile(constants.tokenized("metamorphosis_de.txt"),cmds,"de.test");
        fHelper.createTestingFile(constants.tokenized("metamorphosis_en.txt"),cmds,"en.train");

        aligner.train();
        aligner.test();
        aligner.eval();





    }

}
