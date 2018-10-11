import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals 
{

	@Test
	public void test() 
		{
		String year = "MCMLXXXIV";
		RomanNumerals x = new RomanNumerals();
		if (x.convertToInteger(year) != 1984) fail("Not yet implemented");
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
	public void test_are_there_two_VLD_or_more_than_three_IXCM_in_row() 
		{
		String year = "MCMLXXXIV";
		RomanNumerals x = new RomanNumerals();
		if (x.threeRow(year) != 0) fail("Something went awry");
		}
	
	
	
	
}
