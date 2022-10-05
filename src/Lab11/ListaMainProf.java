package Lab11; /**
  @author Adriano Luchetta
  @version 21-Nov-2005
  @version 3-Dic-2004
*/

import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class ListaMainProf
{
  public static void main(String[] args) throws IOException
  {
    // verifica argomenti su line di comando
    if (args.length < 1)
    {
      System.out.println("uso: $java MainListaSuCatena nomeFile");
      System.exit(1);
    }

    Scanner in = new Scanner(new FileReader(args[0]));
    in.useDelimiter("[,;.!?()\n]+");

    Lista list1 = new Lista();
    Lista list2 = new Lista();
    Iterator iter1 = list1.iterator();

    int i = 0;
    while (in.hasNext())
    {
      String str = in.next();
      iter1.add(str);
      list2.add(i++, str);
    }
    in.close();

    Lista list3 = new Lista();

    listCopy(list1, list3);

    System.out.println("\n*** Lista 1 *********");
    iter1 = list1.iterator();
    while (iter1.hasNext())
      System.out.println((String) iter1.next());
      
    System.out.println("\n*** Lista 2 ***");
    int size = list2.size();
    for (i = 0; i < size; i++)
      System.out.println((String) list2.get(i));

    System.out.println("\n*** Lista 3 ***");
    Iterator iter3 = list3.iterator();
    while (iter3.hasNext())
      System.out.println((String) iter3.next());

    // vuotamento e verifica della prima lista
    System.out.println("\n*** Vuotamento Lista 1 ***");
    iter1 = list1.iterator();
    while (iter1.hasNext())
    {
      Object x =iter1.next();
      iter1.remove();
      System.out.println(x);
    }
    System.out.println("\n*** Lista 1 dopo vuotamento size = " + list1.size() + "***");
    iter1 = list1.iterator();
    while (iter1.hasNext())
      System.out.println(iter1.next());

    // vuotamento e verifica della seconda lista
    System.out.println("\n*** Vuotamento Lista 2 ***");
    size = list2.size();
    while (!list2.isEmpty())
       System.out.println(list2.remove(0));

    System.out.println("\n*** Lista 2 dopo vuotamento  size = " + list2.size() + "***");
    size = list2.size();
    for (i = 0; i < size; i++)
      System.out.println((String) list2.get(i));
  }

  //Copia da una lista a un'altra
  public static void listCopy(List from, List to)
  {
    //le due liste sono lo stesso oggetto
    if(from == to) return;

    Iterator fromItr = from.iterator();
    Iterator toItr = to.iterator();
    while (fromItr.hasNext())
      toItr.add(fromItr.next());
  }
}
