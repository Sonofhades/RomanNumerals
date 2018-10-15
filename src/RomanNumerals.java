
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
		// in case someone sends small letters that we use for
		// other purposes in the program
		romanNum = romanNum.toUpperCase(); 
		// checks that the 2 / 4 same letter combo is not present 
		if(!checkValidity(romanNum)) return -1;
		// checks that IXC can be deducted only from two next letters
		if(!illegalCombos(romanNum)) return -1;
		// changes substracted IXC values of VXLDM to vxlcdm whcih stand for 4, 9, 40, 90, 400 and 900
		romanNum=cheatCalculation(romanNum);
		// counts the total
		return sumUp(romanNum);
		}
	
	public int convertOne(char x)
		{
		switch (x)
			{
		case 'I' : return 1;
		case 'v' : return 4;
		case 'V' : return 5;
		case 'x' : return 9;
		case 'X' : return 10;
		case 'l' : return 40;
		case 'L' : return 50;
		case 'c' : return 90;
		case 'C' : return 100;
		case 'd' : return 400;
		case 'D' : return 500;
		case 'm' : return 900;
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
	
	public String cheatCalculation(String x)
		{
		x=x.replace("IV","v");
		x=x.replace("IX","x");
		x=x.replace("XL","l");
		x=x.replace("XC","c");
		x=x.replace("CD","d");
		x=x.replace("CM","m");
		return x;
		}
	
	public boolean checkValidity(String x)
	
		{
		int i, j;
		String rNumerals="VLDIXCM";
		String target="";
		char tested=rNumerals.charAt(0); // Would not allow me to introduce it without value
		for (i=0; i<rNumerals.length(); i++)
			{
			tested=rNumerals.charAt(i);
			if (i<3) 
				{
				target=target+tested+tested;
				}
			else
				{
				for (j=0; j<4; j++)
					{
					target=target+tested;
					}
				}
			if (x.contains(target)) return false;
			target="";
			}
		return true;
		}
	
	public boolean illegalCombos(String x)
		{
		String rNumerals = "IXC";
		String [] comparison = new String[3];
		comparison[0]="IVX";
		comparison[1]="XILC";
		comparison[2]="CIXDM";
		
		int i, j;
		for (i=0; i<x.length()-1; i++) // will not test the last letter for substractor
			{
			// find which of the substractor Roman numerals it is if any
			for (j=0; j<rNumerals.length(); j++)
				{
				if (x.charAt(i) == rNumerals.charAt(j))
					{
					// this should help to check if the letter is included in the comparison table
					if (comparison[j].indexOf(x.charAt(i+1)) ==-1) return false;
					}
										
				}
			}
		return true;
		}
	
}
