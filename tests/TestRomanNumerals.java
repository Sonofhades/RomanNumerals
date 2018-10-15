import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals 
{

	@Test
	public void test_calculation_of_Roman_Numerals() 
		{
		String year = "MCMLXXXIV";
		int result = 0;
		RomanNumerals x = new RomanNumerals();
		result = x.convertToInteger(year);
		if (result == -1) fail ("The Roman number had illegal letter combos in it");
		if (result != 1984) fail("Numbers do not match");
		}

	@Test
	public void testIndividualLetters() 
		{
		String letters="IVXCLM";
		RomanNumerals x = new RomanNumerals();
		for (int i=0; i<6; i++)
			{
			// char letter = letters.charAt(i);
			
			if (x.convertOne(letters.charAt(i)) == 0) fail("Wrong result for individual letter convert test");
			}
		}
	
	@Test
	public void testSum_without_considering_the_places_in_string() 
		{
		String year = "MCMLXXXIV";
		RomanNumerals x = new RomanNumerals();
		if (x.sumUp(year) != 2186) fail("Did not compute correctly");
		}
	
	@Test
	public void test_cheatCalculation()
	{
	String year = "CMCDXCXLIXIV";
	RomanNumerals x = new RomanNumerals();
	year = x.cheatCalculation(year);
	}
	
	@Test
	public void test_checkValidity() // If there are more than 3 x of specific letter or 2 x of another
	{
	// Select which failure to test	
	// String year = "MMMM";
	// String year = "DD";
	// String year = "CCCC";
	// String year = "LL";
	// String year = "XXXX";
	// String year = "VV";
	String year = "IIII";
	RomanNumerals x = new RomanNumerals();
	// char result = x.checkValidity(year);
	if (!x.checkValidity(year)) fail ("Fails because too many (2 / 4) Roman numerals of type in a row");
	}
	
	
	@Test
	public void test_illegalCombos()
	{
	// String year="IX"; // should work	
	// String year="IC"; // should fail
	// String year = "MCMLXXXIV"; // should work
	String year = "MXMLXXXIV"; // should fail
	RomanNumerals x = new RomanNumerals();
	if (!x.illegalCombos(year)) fail ("Wrong roman numeral combos detected");
	}
	
}
