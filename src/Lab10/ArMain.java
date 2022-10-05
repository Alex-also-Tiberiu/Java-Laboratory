package Lab10;

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArMain {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(args[0]));
		PrintWriter pri = new PrintWriter(args[1]);
		ArStack stack = new ArStack();
		
		in.useDelimiter("[ ]+");
		while(in.hasNext()) {
			String token = in.next();
			stack.push(token);
			
		} in.close();
		
		
		while(!(stack.isEmpty())) {
			pri.println(stack.pop());
		
		} pri.close();
	}
}
