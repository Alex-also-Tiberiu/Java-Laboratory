package Lab11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ListaMain {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner in = new Scanner(new FileReader(args[0]));
		PrintWriter print = new PrintWriter(args[1]);
		Lista l = new Lista();
		Lista l2 = new Lista();
		
		int i = 0;
		while(in.hasNext()) {
			String tok = in.next();
			l.add(i, tok);
			i++;
		} in.close();
		
		i = 0;
		while(!(l.isEmpty())) {
			Object x = l.remove(i);
			l2.add(i, x);
			i++;
		}
		
		i = 0;
		while(!(l2.isEmpty())) {
			print.println(l2.remove(i));
			i++;
		}
		print.close();
	}
}
