package edu.insf.toolkit.DesignPatterns.Factory;


public class IOFactory
{
    public static IOBuffered buildIOBuffered(IOType type, String filePath)
    {
        IOBuffered buffered = null;

        switch (type)
        {
            case BUFFERED_READER:
                buffered = new IOBufferedReader(filePath);
                break;
            case BUFFERED_WRITTER:
                buffered = new IOBufferedWriter(filePath);
                break;
            default:
                buffered = null;
        }

        if(buffered == null)
        {
            throw new IOFactoryException("This IOBuffered type does not exist");
        }
        else
        {
            return buffered;
        }
    }
}
