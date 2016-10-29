package ch1.arrays.implementations.stringbuilder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBuilderTest {
    
    private StringBuilder sb;
    
    @Before
    public void setUp() {
        sb = new StringBuilder(10);
    }
    
    @After
    public void tearDown() {
        sb = null;
    }
    
    @Test
    public void testAppendAndToString() {
        sb.append("Hello,");
        sb.append(" World!");
        Assert.assertEquals("Hello, World!", sb.toString());
    }
    
    @Test
    public void testExpand() {
        for(int i = 0; i < 10; i++) {
            sb.append(Integer.toString(i));
        }
        sb.append("This one will expand it.");
        Assert.assertEquals("0123456789This one will expand it.", sb.toString());
    }

}
