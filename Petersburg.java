import java.util.*;
public class Petersburg
{
   public static void main(String[] args)
   {
      int y = 35;
      int[] num = new int[y];
      boolean rand_bool = true;
      boolean tester = false;
      int x;
      int z;
      long total = 0;
      long pow;
      int number = 1000000000;
      long flip = 0;
      
      for(z = 0; z < number; z++) {
      
         int j=0;
         
         while (rand_bool) {
            
            double rand = (double)Math.random()*2;
            if(rand>=1){
               rand_bool = true;
               j = j+1;
            } else  {
               rand_bool = false;
            }
            flip++;
         }
         
         num[j] = num[j] + 1;
         rand_bool = true;
      }
      System.out.println("Number\tFrequency");
      for(x=0;x<y;++x){
         
         pow = (long)Math.pow(2,x+1);
         System.out.println("2^"+ (x+1) + "\t" + num[x]);
         total = total + pow * num[x];
         
      }
      if(total<0) {
         System.out.print("The total got too big.");
      } else {
         System.out.println("The total is " +total+ " and the average payout of a game is " + (double)total/number);
         System.out.print("The total amount of flips are " + flip);
      }
      
   }
      
 }