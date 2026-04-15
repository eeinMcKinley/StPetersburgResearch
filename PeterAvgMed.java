import java.util.*;
public class PeterAvgMed
{
   public static void main(String[] args)
   {
      boolean rand_bool = true;
      int in_set = 21;
      int total_set = 1001;
      int total_element = total_set * in_set;
      int half_set = (int)in_set/2;
      int half_element = (int)total_element/2;
      int x;
      int y;
      int z;
      int number = 0;
      long pow;
      long add_set = 0;
      float average = 0;
      long[] set = new long[in_set];
      long[] big_set = new long[total_element];
      float[] avg = new float[total_set];
      int[] med = new int[total_set];
      
      
      for(x = 0; x< total_set; x++){
         for(y = 0; y< in_set; y++){
            //Calculate number
            int j=0;
         
            while (rand_bool) {
            
               double rand = (double)Math.random()*2;
               
               if(rand>=1){
                  rand_bool = true;
                  j = j+1;
               } else  {
                  rand_bool = false;
               }
            }
         
            pow = (long)Math.pow(2,j+1);
            set[y] = pow;
            big_set[number] = pow;
            add_set = add_set + pow;
          
            
            rand_bool = true;
            number++;
         }
         
         Arrays.sort(set);
         med[x] = (int) set[half_set];
         avg[x] = (float)add_set/in_set;
         
         add_set = 0;
      }
      
      Arrays.sort(big_set);
      
      
      System.out.println("Medians:");
      for(z = 0; z<total_set; z++){
         System.out.println(med[z]);
         
      }
      System.out.println("The True Median: "+big_set[half_element]);
      System.out.println("Averages:");
      for(z = 0; z< total_set; z++){
         System.out.println(avg[z]);
         average = average + avg[z];
      }
      average = average/total_set;
      System.out.println("The True Average: " + average);
   
   
   
   
   }
      
}