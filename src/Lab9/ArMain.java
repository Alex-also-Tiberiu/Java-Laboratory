package Lab9;

import java.util.Scanner;

public class ArMain {
	
  public static void main(String[] args) {
		
	Scanner in = new Scanner(System.in);
	ArStack stack = new ArStack();
	
	while(in.hasNextLine()) {
		String line = in.nextLine();
		Scanner tok = new Scanner(line);
		
		while(tok.hasNext()) {
			String token = tok.next();
			tok.useDelimiter("[ ]+");
			stack.push(token);
			
		} tok.close();
	
	} in.close();
	
	
	while(!stack.isEmpty())
		System.out.println(stack.pop());
  }
}
