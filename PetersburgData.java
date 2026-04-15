import java.util.*;
public class PetersburgData
{
   public static void main(String[] args)
   {
      boolean rand_bool = true;
      boolean tester = false;
      int w =0;
      int x;
      int z;
      long total = 0;
      long pow;
      int number = 10000;
      int[] set = new int[number];
      int[] set1 = new int[number/3+1];
      int[] set2 = new int[number/3+1];
      int[] set3 = new int[number/3+1];
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
         
         pow = (long)Math.pow(2,j+1);
         set[z] = (int)pow;
         rand_bool = true;
         
      }
      for(x=0;x<number;++x){
         if(w == 0){
            set1[x/3]=set[x];
            w = 1;
            System.out.print("1");
         } else{
         if(w==1) {
            set2[x/3]=set[x];
            w=2;
            System.out.print("2");
         } else{
         if(w==2){
            set3[x/3]=set[x];
            w=0;
            System.out.print("3");
         }
         }
         }
      }
      for(x=0;x<number/2;++x){
        System.out.println(set1[x] + "\t" + set2[x] + "\t" + set3[x]);
      }
      
   }
      
 }