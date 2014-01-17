package edu.insf.toolkit;

import edu.insf.toolkit.Helper;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import java.io.File;

public class HelperTest
{
    Helper helper = new Helper();

    //@Test
    public void testGenerateRandonDouble()
    {
        double generatedNumber = helper.generateRandomDouble(1,1);
        assertEquals(1.0,generatedNumber,0.0);
    }


}
