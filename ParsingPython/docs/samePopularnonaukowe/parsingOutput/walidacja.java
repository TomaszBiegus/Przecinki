import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class walidacja{
  static int liczbaKolumn = 5;

  public static void main(String[] args) throws FileNotFoundException {
    Scanner odczyt = new Scanner(new File("outputCRF.txt"));
    String line;
    String[] cols;
    int dobrze = 0, zle = 0;
    while(odczyt.hasNext()){
      line = odczyt.nextLine();
      //System.out.println(line);
      cols = line.split("\t");
      for(int i=0; i<cols.length; i++){
        cols[i] = cols[i].trim();
      }
      //System.out.println(cols.length);
      if(cols.length == liczbaKolumn){
        System.out.println(cols[liczbaKolumn-2]+"  "+cols[liczbaKolumn-1]);
        if( (cols[liczbaKolumn-2].equals("comma_after")) || (cols[liczbaKolumn-1].equals("comma_after")) ){
          //System.out.println("weszlo");
          if(cols[liczbaKolumn-2].equals(cols[liczbaKolumn-1]))
            dobrze++;
          else
            zle++;
        }
      }
    }
    System.out.println("\ndobrze: "+dobrze+"  zle: "+zle+"  \n");
    System.out.println("\n\nDobrze/(dobrze+zle) = " + (double)100*dobrze/(dobrze+zle) + "%\n\n");
  }

}
