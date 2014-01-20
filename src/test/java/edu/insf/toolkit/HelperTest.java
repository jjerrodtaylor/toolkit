package edu.insf.toolkit;

import edu.insf.toolkit.Tools.Helper;

import static org.junit.Assert.assertEquals;

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
