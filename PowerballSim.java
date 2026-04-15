import java.util.*;
import java.lang.*;
public class PowerballSim
{
   public static void main(String[] args) {
      int a;
      int distinct_wins = 9;
      int[] wins = new int[distinct_wins];
      int[] winning_whites = whites();
      int winning_red = reds();
      int overlap;
      int money_won = 0;
      int profit;
      int games = 292000000;
      int jackpot = 629000000;
      int losses = 0;
      for(a=0;a<distinct_wins;a++){
         wins[a] = 0;
      }
      for(a=0;a<games;a++){
         int[] ticket_whites = whites();
         int ticket_red = reds();
         overlap = sameElements(winning_whites,ticket_whites);
         if(winning_red==ticket_red){
            switch(overlap){
               case(0):
                  wins[0]++;
                  break;
               case(1):
                  wins[1]++;
                  break;
               case(2):
                  wins[2]++;
                  break;
               case(3):
                  wins[4]++;
                  break;
               case(4):
                  wins[5]++;
                  break;
               case(5):
                  wins[8]++;
                  break;                  
            }
         }else{
            switch(overlap){
               case(1):
               case(2):
                  losses++;
                  break;
               case(3):
                  wins[3]++;
                  break;
               case(4):
                  wins[5]++;
                  break;
               case(5):
                  wins[7]++;
                  break;
            }
         }
      }
      System.out.println("Total Games: " + games);
      for(a=0;a<distinct_wins;a++){
         System.out.print(wins[a] + ",");
         switch(a){
            case(0):
            case(1):
               money_won = money_won + wins[a] * 4;
               break;
            case(2):
            case(3):
               money_won = money_won + wins[a] * 7;
               break;
            case(4):
            case(5):
               money_won = money_won + wins[a] * 100;
               break;
            case(6):
               money_won = money_won + wins[a] * 50000;
               break;
            case(7):
               money_won = money_won + wins[a] * 1000000;
               break;
            case(8):
               money_won = money_won + wins[a] * jackpot;
               break;
         }
      }
      profit = money_won - 2 * games;
      System.out.print("\nMoney won: " + money_won + " Profit: " + profit + " Total Game Losses: " + losses);
      
   }
   public static int[] whites(){
      //Variables
      int white_balls = 69;
      int white_winners = 5;
      int[][] whites = new int[white_winners][];
         whites[0] = new int[white_balls];
         whites[1] = new int[white_balls-1];
         whites[2] = new int[white_balls-2];
         whites[3] = new int[white_balls-3];
         whites[4] = new int[white_balls-4];
      int[] winning_white = new int[white_winners];
      int[] sorted_white = new int[white_winners];
      int x = 0;
      int y = 0;
      
      ///Getting White Balls
      
      for(x=0;x< white_balls;x++){
         whites[0][x]=x;
      }
      
      for(x=0;x<5;x++){
      
         int random = getRandomInt(whites[x].length);
         winning_white[x] = whites[x][random];
         int[] middle;
         switch(x){
            case(0):
               whites[1] = removeElement(whites[0],whites[1],random);
               break;
            case(1):
               whites[2] = removeElement(whites[1],whites[2],random);
               break;
            case(2):
               whites[3] = removeElement(whites[2],whites[3],random);
               break;
            case(3):
               whites[4] = removeElement(whites[3],whites[4],random);
               break;
         }
      }
      ///Sorting white balls
      sorted_white = sort(winning_white);
      return sorted_white;
   }
   public static int reds() {
      int[] reds = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
      int winning_red;
      winning_red=reds[getRandomInt(reds.length)];
      return winning_red;
   }
   
   public static int getRandomInt(int max) {
      return (int)Math.floor((double)(Math.random() * max));
   }
   
   
   public static int[] removeElement(int[] array,int[] newarray , int index) {
      
      int newarrayIndex = 0;
      
      for(int i=0;i<array.length;i++){
         if(i != index){
            newarray[newarrayIndex]=array[i];
            newarrayIndex++;
         }
      }
      
      return newarray;
   }
   
   public static int[] sort(int[] array){
      int x = 0;
      int[] newArray = new int[array.length];
      int temp;
      for(x = 0;x<5;x++){
         newArray[x] = array[x];
      }
      while(!(newArray[0]<newArray[1] && newArray[1]<newArray[2] && newArray[2]<newArray[3] && newArray[3]<newArray[4])){
         for(x=1;x<5;x++){
            if(newArray[x]<newArray[x-1]){
               temp = newArray[x];
               newArray[x] = newArray[x-1];
               newArray[x-1] = temp;
            }
         }
      }
      return newArray;
   }
   public static int sameElements(int[] win, int[] ticket){
      int x;
      int y;
      int same = 0;
      for(x = 0;x<win.length; x++){
         for(y = 0;y<ticket.length;y++){
            if(win[x] == ticket[y]){
               same++;
            }
         }
      }
      return same;
   }
}