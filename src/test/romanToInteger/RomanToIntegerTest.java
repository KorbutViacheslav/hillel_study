package romanToInteger;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.naming.SizeLimitExceededException;

@RunWith(DataProviderRunner.class)
public class RomanToIntegerTest {
    private static RomanToInteger romanToInteger;

    @BeforeClass
    public static void createNew() {
        romanToInteger = new RomanToInteger();
    }

    @Test(expected = SizeLimitExceededException.class)
    public void romeNumbersShouldSizeException() throws SizeLimitExceededException {
        romanToInteger.romeNumbersConvert("MMMMMM");
    }

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {"XXX", 30},
                {"IX", 9},
                {"VIII", 8},
                {"LVIII", 58},
                {"MCMXCIV", 1994},
                {"MMMCMXCIX", 3999},
                {"I", 1}
        };
    }

    @DataProvider
    public static Object[][] exeption() {
        return new Object[][]{
                {"XXXX"},
                {"IIX"},
                {"VIIII"},
                {""},
                {"IM"},
                {"XDM"},
                {"XM"}
        };
    }

    @Test
    @UseDataProvider("data")
    public void romeNumbersConvertTest(String str, int result) throws SizeLimitExceededException {
        Assert.assertEquals(result, romanToInteger.romeNumbersConvert(str));
    }

    @Test(expected = IllegalArgumentException.class)
    @UseDataProvider("exeption")
    public void shouldExeption(String str) throws SizeLimitExceededException {
        romanToInteger.romeNumbersConvert(str);
    }
}
