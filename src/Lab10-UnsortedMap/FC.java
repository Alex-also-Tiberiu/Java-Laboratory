package Lab10

import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FC {
	
	public static void main(String[] args) throws FileNotFoundException {
		
	Scanner in = new Scanner(new FileReader(args[0])).useDelimiter("[^a-zA-Z]+");
	MyMap map = new MyMap();
	
	while(in.hasNext()) {
		
		String s = in.next();
		Object x = map.get(s);
		
		if(x == null)
			map.put(s, 1);
		else
			map.put(s, (Integer)x+1);
	}
	
	Object[] keys = map.keys();
	
	for(int i = 0; i < keys.length; i++)
		System.out.println(keys[i]+ " : " + map.get(keys[i]));
	}
	
}
