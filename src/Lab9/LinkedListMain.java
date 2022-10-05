package Lab9;

import java.util.Scanner;

public class LinkedListMain {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		LinkedLinkStack stack = new LinkedLinkStack();
		String line = "";
		
		while(in.hasNextLine()) {
			line = in.nextLine();
			stack.push(line);
		
		} in.close();
	
	while(!stack.isEmpty())
		System.out.println(stack.pop());
	}
}
