
package hillcipher;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;



 

 

public class HillCipher {
 
 public static String formattheplain (String plain ,double key)
    {
       
         StringBuilder messag = new StringBuilder(plain);


       
         
            while((messag.length()%(int)Math.sqrt(key))!=0)
            {
                messag.append("X");
            }
         
        

         return messag.toString();
       
    }

 

   
    public static void main(String[] args) {
         String Alpha=new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        Scanner sc1=new Scanner(System.in);
        StringBuilder fine=new StringBuilder();
        int rows=0;
        int columns=0;
        double key=sc1.nextDouble();
        double [][]keymat=new double[(int)Math.sqrt(key)][(int)Math.sqrt(key)];
        for(int i=0;i<key;i++)
        {
       double y= Double.parseDouble(sc1.next());
       keymat[rows][columns]=y;
       columns++;
       if(columns==(int)Math.sqrt(key))
       {
           columns=0;
           rows++;
           
       }
       
        }
      
        String plain=sc1.next();
        String formated =formattheplain(plain,key);
        int [] plainmat=new int [(int)Math.sqrt(key)];
        int l=0;
        double []result=new double[(int)Math.sqrt(key)];
        int counter=0;
      while(l<formated.length())
      {
          char e=formated.charAt(l);
         int s= Alpha.indexOf(e);
         
         plainmat[counter]=s;
        
         counter++;
          l++;
         
         if(counter==(int)Math.sqrt(key))
         {
             for (int i = 0; i < keymat.length; i++) { 
    for (int j = 0; j < plainmat.length; j++) { 
        
            result[i] += keymat[i][j] * plainmat[j];
       
    }
}
         
        for(int o=0;o<result.length;o++)
        {
            Double d = new Double(result[o]%26);
            int i = d.intValue();
          fine.append(Alpha.charAt(i));
          result[o]=0;
            
        }
        counter=0;
        
        
          }
        
      }
         
              System.out.println(fine.toString());
        
    
    
    }
}