
/* 
The	symbols	'I',	'X',	'C',	and	'M'	can	be	repeated	at	most	3	times	in	a row.
The	symbols	'V',	'L',	and	'D'	can	never	be repeated.
The '1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next highest values ('IV' and	
'IX',	'XL'	and	'XC',	'CD'	and 'CM').
Only	one	subtraction	can	be	made	per	numeral	('XC'	is	allowed,	'XXC'	is not).
The	'5'	symbols	('V',	'L',	and	'D')	can	never	be subtracted.
 */

public class RomanNumerals 
{
	
	public int convertToInteger(String romanNum) 
		{
		romanNum = romanNum.toUpperCase(); // in case someone sends small letters
		
		// To be Implemented
		return 0;
		
		}
	
	public int convertOne(char x)
		{
		switch (x)
			{
		case 'I' : return 1;
		case 'V' : return 5;
		case 'X' : return 10;
		case 'L' : return 50; 
		case 'C' : return 100; 
		case 'D' : return 500;
		case 'M' : return 1000;
			}
		return 0;
		}
	
	public int sumUp(String rNum)
		{
		int sum=0;
		for (int i=0; i<rNum.length(); i++)
			{
			sum=sum+convertOne(rNum.charAt(i));			
			}
		return sum;
		}
	
	public int threeRow (String x)
		{
		char y;
		int number=0;
		for (int i=0; i<x.length();i++)
			{
			y = x.charAt(i);
			switch (y)
				{
				case 'D' : 
				case 'V' : 
				case 'L' : if (y == x.charAt(i+1)) return 1;
				case 'X' : 
				case 'I' : 
				case 'M' : 
				case 'C' : 
					for (int j=i+1; j<x.length(); j++)
						{
						if (y == x.charAt(j)) number++;
						}
					if (number > 2) return 2;
					}
				
			}
		
		return 0;
		}
	
	
}
