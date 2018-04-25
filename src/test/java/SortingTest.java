import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SortingTest {

    private static Sorting sorter;

    @BeforeClass
    public static void setUp(){
        System.out.println("Setting up");
        ArrayList<String> testData = new ArrayList<String>();
        testData.add("-2.2.2\t-3\tasd");
        testData.add("q1");
        testData.add("-2.2\t-3\tasd");
        testData.add("-2.2\t-3");
        sorter = new Sorting(testData);
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Tearing down");
        sorter = null;
    }

    @Test
    public void givenSetupArrayList_whenArraylistIsSorted_thenCorrectlySortedArrayListIsReturned() {
        ArrayList<String> correctlySorted = new ArrayList<String>();
        correctlySorted.add("-2.2\t-3");
        correctlySorted.add("-2.2\t-3\tasd");
        correctlySorted.add("-2.2.2\t-3\tasd");
        correctlySorted.add("q1");
        sorter.bubbleSort();
        ArrayList<String> sortedByBubbleSort = sorter.getToBeSorted();
        Assert.assertEquals(correctlySorted, sortedByBubbleSort);
    }

    @Test
    public void givenTwoIdenticalStrings_whenComparingLines_zeroIsReturned() {
        String s1 = "123\t456\t-asd";
        String s2 = "123\t456\t-asd";
        int comparisonResult = sorter.compareTwoLines(s1, s2);
        Assert.assertEquals(0, comparisonResult);
    }

    @Test
    public void givenNegativeAndPositiveNumericStrings_whenComparingLines_negativeIntIsReturned() {
        String s1 = "-123";
        String s2 = "123";
        int comparisonResult = sorter.compareTwoLines(s1, s2);
        Assert.assertTrue(comparisonResult < 0);
    }

    @Test
    public void givenWordAndNumericStrings_whenComparingLines_oneIsReturned() {
        String s1 = "asd";
        String s2 = "123";
        int comparisonResult = sorter.compareTwoLines(s1, s2);
        Assert.assertEquals(1, comparisonResult);
    }

    @Test
    public void givenIncorrectNumberFormat_whenCheckingIfNumeric_falseIsReturned() {
        String incorrectNumberFormat = "123.2.3";
        boolean isStringNumeric = sorter.isNumeric(incorrectNumberFormat);
        Assert.assertEquals(false, isStringNumeric);
    }

    @Test
    public void givenStringWithNegativeDecimal_whenCheckingIfNumeric_trueIsReturned() {
        String negativeDecimalString = "-123.2";
        boolean isStringNumeric = sorter.isNumeric(negativeDecimalString);
        Assert.assertEquals(true, isStringNumeric);
    }

    @Test
    public void givenStringWithLettersAndDigits_whenCheckingIfNumeric_falseIsReturned() {
        String lettersAndDigits = "11as34r";
        boolean isStringNumeric = sorter.isNumeric(lettersAndDigits);
        Assert.assertEquals(false, isStringNumeric);
    }
}