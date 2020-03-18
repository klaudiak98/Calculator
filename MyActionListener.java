import java.awt.TextField;
import java.awt.event.ActionEvent;

public class MyActionListener implements java.awt.event.ActionListener {

	private char operation;
	private int first=0, second=0;
	private boolean done = false, done2 = false, equal = false, number = false, afterChar = false, afterNumber = false;
	private String makeNumber = "";
	private TextField textField;
	private String show = "";
	private String temp = "";
	
	public MyActionListener(TextField textField_m)
	{
		textField = textField_m;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		char butt = e.getActionCommand().charAt(0);

		switch(butt)
		{
			case '1' : number  = true; break;
			case '2' : number  = true; break;
			case '3' : number  = true; break;
			case '4' : number  = true; break;
			case '5' : number  = true; break;
			case '6' : number  = true; break;
			case '7' : number  = true; break;
			case '8' : number  = true; break;
			case '9' : number  = true; break;
			case '0' : number  = true; break;
			case '+' : number  = false; break;
			case '-' : number  = false; break;
			case '*' : number  = false; break;
			case '/' : number  = false; break;
			case '=' : number  = false; break;
			case 'C' : number  = false; break;
			default : System.out.println("ERROR!"); break;
		}
		
		//first number is pressed
		if (number && !afterNumber && !afterChar && !done && !done2)
		{
			show += butt;
			makeNumber += butt;
			afterNumber = true;
		}
		
		//int after int -> first value
		else if (number && afterNumber && !afterChar && !done && !done2)
		{
			makeNumber += butt;
			show = makeNumber;
		}
		
		//first char after int (other than '=', 'C')
		else if (!number && butt != '=' && butt != 'C' && afterNumber && !afterChar && !done2 && !done)
		{
			operation = butt;
			show += operation;
			first = Integer.parseInt(makeNumber);
			afterNumber = false;
			done = true;
			afterChar = true;
			makeNumber = "";
		}
		
		//char after char
		else if (!number && butt != '=' && butt != 'C' && !afterNumber && afterChar && !done2)
		{
			show = Integer.toString(first);
			show += butt;
			operation = butt;
		}
		
		//int after char -> second value
		else if (number && !afterNumber && afterChar && done && !done2)
		{
			temp = show;
			makeNumber += butt;
			show += makeNumber;
			afterNumber = true;
			afterChar = false;
			done2 = true;
			equal = true;
		}
		
		//int after int -> second value
		else if (number && afterNumber && !afterChar && done && done2)
		{
			show = temp;
			makeNumber += butt;
			show += makeNumber;
		}
		
		//char after second int (other then '=', 'C')
		else if (!number && butt != '=' && butt != 'C' && afterNumber && !afterChar && done && done2)
		{
			show += butt;
			second = Integer.parseInt(makeNumber);
			afterNumber = false;
			afterChar = true;
			makeNumber = "";
						
			switch (operation)
			{
				case '+': first += second; break;
				case '-': first -= second; break;
				case '*': first *= second; break;
				case '/': 
					{
						if (second == 0)
						{
							show = "DIVISION BY ZERO! Try again: ";
							//System.out.println("DIVISION BY ZERO!"); break;
						} else first /= second; break;
					}
			}

			operation = butt;
			second = 0;
			done2 = false;
			equal = false;
		}
		
		// '='
		else if (butt == '=' && !afterChar && done && done2 && equal)
		{
			show += butt;
			second = Integer.parseInt(makeNumber);
			
			switch (operation)
			{
				case '+': first += second; break;
				case '-': first -= second; break;
				case '*': first *= second; break;
				case '/': {
					if (second == 0)
					{
						show = "DIVISION BY ZERO! Try again: ";
						//System.out.println("DIVISION BY ZERO!"); break;
					} else first /= second; break;
				}
			}
			
			show += first;
			
			done2 = false;
			done = false;
			equal = false;
			afterChar = false;
			afterNumber = true;
			second = 0;
			makeNumber = Integer.toString(first);

		}
		
		else if (butt == 'C')
		{
			operation = '0';
			first=0;
			second=0;
			done = false;
			done2 = false;
			equal = false;
			number = false;
			afterChar = false;
			afterNumber = false;
			makeNumber = "";
			show = "";
		} 
		
		else if (butt == '=' && afterNumber)
		{
			first = Integer.parseInt(makeNumber);
			show += "=";
			show += first;
			
			done2 = false;
			done = false;
			equal = false;
			afterChar = false;
			afterNumber = true;
			second = 0;
			makeNumber = Integer.toString(first);
		}
		
		else 
		{
			System.out.println("ERROR!");
			show = "ERROR!";
		}

		textField.setText(show);
	}
	
	
}

