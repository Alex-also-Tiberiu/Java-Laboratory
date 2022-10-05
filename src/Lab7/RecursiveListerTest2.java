package Lab7;

import javax.swing.JOptionPane;


public class RecursiveListerTest2
{
    public static void main(String[] args) {
        
        int first = 0;
        int n = Integer.parseInt(args[first]);
        
        RecursiveNumberLister2 rnl = new RecursiveNumberLister2();
        
        JOptionPane.showMessageDialog(null , "la lista e' :\n    "+rnl.recursivelyList(n));
        
    }
}
