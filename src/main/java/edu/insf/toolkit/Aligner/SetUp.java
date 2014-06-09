package edu.insf.toolkit.Aligner;

import edu.insf.toolkit.Tools.Constants;
import edu.main.NewCommandLineArguments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created with IntelliJ IDEA.
 * User: jamaaltaylor
 * Date: 6/2/14
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class SetUp
{
    private String settingsFile;
    private Constants constants = new Constants();

    //folders
    private String evalDir;
    private String alignDir;
    private String classifyDir;
    private String testDir;
    private String trainDir;

    //files
    private String l1File;
    private String l1TrainFile;
    private String l1TrainFileName;
    private String l1TestFile;
    private String l1TestFileName;
    private String l1EvalFile;
    private String l1EvalFileName;

    private String l2File;
    private String l2TrainFile;
    private String l2TrainFileName;
    private String l2TestFile;
    private String l2TestFileName;
    private String l2EvelFile;
    private String l2EvalFileName;
    private String trainFilePath;
    private String testFilePath;
    private String evalFilePath;

    public SetUp(String filePath)
    {
        settingsFile = filePath;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(new File(settingsFile)));
            setUpFolders();
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    public void setUpFolders()
    {
        File align = new File(constants.getRoot()+"align/");
        File eval = new File(constants.getRoot()+"eval/");
        File classify = new File(constants.getRoot()+"classify/");
        File test = new File(constants.getRoot()+"test/");
        File train = new File(constants.getRoot()+"train/");

        if(!align.exists())
        {
            align.mkdir();
            alignDir = align.getAbsolutePath();
        }

        if(!eval.exists())
        {
            eval.mkdir();
            evalDir = eval.getAbsolutePath();
        }

        if(!classify.exists())
        {
            classify.mkdir();
            classifyDir = classify.getAbsolutePath();
        }

        if(!test.exists())
        {
            test.mkdir();
            testDir = test.getAbsolutePath();
        }

        if(!train.exists())
        {
            train.mkdir();
            trainDir = train.getAbsolutePath();
        }
    }

    public void setFilePaths()
    {
        l1TrainFile = trainDir + l1TrainFileName;
        l2TrainFile = trainDir + l2TrainFileName;
        l1TestFile = testDir + l1TestFileName;
        l2TestFile = testDir + l2TestFileName;
        l1EvalFile = evalDir+ l1EvalFileName;
    }

    /**
     * Find out what lex weights are. You probably have a set of lex
     * weights for each language.
     * @param lang
     * @return
     */
    public  String getBadLexweightsPath(String lang){
        if (lang.equals(l1File))
            return alignDir + "2.lexweights";
        else if (lang.equals(l2File))
            return alignDir + "1.lexweights";
        else
            return null;
    }

    public  String getGoodLexweightsPath(String lang){
        if (lang.equals(l1File))
            return alignDir + l1File + ".lexweights";
        else if (lang.equals(l2File))
            return alignDir + l2File + ".lexweights";
        else
            return null;
    }

    public  String getOutputPath(){
        return constants.getRoot() +  "output.txt";
    }

    public  String getClassifierTrainFile(){
        return classifyDir + "train.prop";
    }


    public  String getClassifierEvalFile(){
        return classifyDir + "eval.prop";
    }

    public  String getClassifierTestFile(){
        return classifyDir + "test.prop";
    }
    public String getClassifierPropertiesFile(){
        return classifyDir + "data.prop";
    }

    public String getBerkeleyConfigFile(){
        return alignDir + "train.config";
    }

    public String getGeneratedLexWeightsPath(String lang){
        return "";
    }

    public String getClassifierOutputRawFile(){
        return classifyDir + "results.txt";
    }

    public String getParallelSentenceFile(){
        return classifyDir + "extracted-parallel-sentences.txt";
    }

    //getters and setters

    public String getSettingsFile() {
        return settingsFile;
    }

    public void setSettingsFile(String settingsFile) {
        this.settingsFile = settingsFile;
    }

    public Constants getConstants() {
        return constants;
    }

    public void setConstants(Constants constants) {
        this.constants = constants;
    }

    public String getEvalDir() {
        return evalDir;
    }

    public void setEvalDir(String evalDir) {
        this.evalDir = evalDir;
    }

    public String getAlignDir() {
        return alignDir;
    }

    public void setAlignDir(String alignDir) {
        this.alignDir = alignDir;
    }

    public String getClassifyDir() {
        return classifyDir;
    }

    public void setClassifyDir(String classifyDir) {
        this.classifyDir = classifyDir;
    }

    public String getTestDir() {
        return testDir;
    }

    public void setTestDir(String testDir) {
        this.testDir = testDir;
    }

    public String getTrainDir() {
        return trainDir;
    }

    public void setTrainDir(String trainDir) {
        this.trainDir = trainDir;
    }

    public String getL1File() {
        return l1File;
    }

    public void setL1File(String l1File) {
        this.l1File = l1File;
    }

    public String getL1TrainFile() {
        return l1TrainFile;
    }

    public void setL1TrainFile(String l1TrainFile) {
        this.l1TrainFile = l1TrainFile;
    }

    public String getL1TrainFileName() {
        return l1TrainFileName;
    }

    public void setL1TrainFileName(String l1TrainFileName) {
        this.l1TrainFileName = l1TrainFileName;
    }

    public String getL1TestFile() {
        return l1TestFile;
    }

    public void setL1TestFile(String l1TestFile) {
        this.l1TestFile = l1TestFile;
    }

    public String getL1TestFileName() {
        return l1TestFileName;
    }

    public void setL1TestFileName(String l1TestFileName) {
        this.l1TestFileName = l1TestFileName;
    }

    public String getL1EvalFile() {
        return l1EvalFile;
    }

    public void setL1EvalFile(String l1EvalFile) {
        this.l1EvalFile = l1EvalFile;
    }

    public String getL1EvalFileName() {
        return l1EvalFileName;
    }

    public void setL1EvalFileName(String l1EvalFileName) {
        this.l1EvalFileName = l1EvalFileName;
    }

    public String getL2File() {
        return l2File;
    }

    public void setL2File(String l2File) {
        this.l2File = l2File;
    }

    public String getL2TrainFile() {
        return l2TrainFile;
    }

    public void setL2TrainFile(String l2TrainFile) {
        this.l2TrainFile = l2TrainFile;
    }

    public String getL2TrainFileName() {
        return l2TrainFileName;
    }

    public void setL2TrainFileName(String l2TrainFileName) {
        this.l2TrainFileName = l2TrainFileName;
    }

    public String getL2TestFile() {
        return l2TestFile;
    }

    public void setL2TestFile(String l2TestFile) {
        this.l2TestFile = l2TestFile;
    }

    public String getL2TestFileName() {
        return l2TestFileName;
    }

    public void setL2TestFileName(String l2TestFileName) {
        this.l2TestFileName = l2TestFileName;
    }

    public String getL2EvelFile() {
        return l2EvelFile;
    }

    public void setL2EvelFile(String l2EvelFile) {
        this.l2EvelFile = l2EvelFile;
    }

    public String getL2EvalFileName() {
        return l2EvalFileName;
    }

    public void setL2EvalFileName(String l2EvalFileName) {
        this.l2EvalFileName = l2EvalFileName;
    }

    public String getTrainFilePath() {
        return trainFilePath;
    }

    public void setTrainFilePath(String trainFilePath) {
        this.trainFilePath = trainFilePath;
    }

    public String getTestFilePath() {
        return testFilePath;
    }

    public void setTestFilePath(String testFilePath) {
        this.testFilePath = testFilePath;
    }

    public String getEvalFilePath() {
        return evalFilePath;
    }

    public void setEvalFilePath(String evalFilePath) {
        this.evalFilePath = evalFilePath;
    }
}
