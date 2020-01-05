import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;


public class PokedexSort {
  
  //Method that gets number of lines in the file
  public static int getLines() throws IOException{
    BufferedReader input = new BufferedReader(new FileReader("pokemon.txt"));
    int lines = 0;
    while(input.readLine() != null) lines ++;
    input.close();
    return lines;
  }
  
  //Method that creates list for viewing
  public static String View (String[] pokemon,String[] type ,String[] type2, int lines,String[] entry,int[]total,int[]hp,int[]atk,int[]def,int[]spa,int[]spd,int spe[])throws IOException {
    
    DecimalFormat twoDecimals = new DecimalFormat("000"); // declare decimal format
    String list = "Dex Entry:\tPokemon\tType\tBase Stats\tHitpoints\tAttack\tDefense\tSpecial Attack\tSpecial Defense\tSpeed\t Base Stats Total\n";
    list = list + "\n======\t=========\t====\t--->\t========\t======\t======\t==========\t=========\t=====\t==========\n";
    int counter = 0;
    for (int i = 0; i <lines;i++) {
      list = list + "\n" + entry[i] + "\t"+ pokemon[i] + "\t" + type[i] +  " " + type2[i]+ "\t\t"+ hp[i]+"\t"+atk[i]+"\t"+def[i]+"\t"+spa[i]+"\t"+spd[i]+"\t"+spe[i]+"\t"+total[i];  
    }
    
    return list;
  }
  //partition method for quickSortDig
 static int partition2(int[] arrayNumber,String[] pokemon,String[] type ,String[] type2, int lines,String[] entry,int[]total,int[]hp,int[]atk,int[]def,int[]spa,int[]spd,int spe[], int begin, int end) {  
    int pivot = end;

    int counter = begin;
    for (int i = begin; i < end; i++) {
        if (arrayNumber[i]<arrayNumber[pivot]) {
            String tempPokemon = pokemon[counter];
            pokemon[counter] = pokemon[i];
            pokemon[i] = tempPokemon;
            String tempType =type[counter];
            type[counter] = type[i];
            type[i] = tempType;
            String tempType2 =type2[counter];
            type2[counter] = type2[i];
            type2[i] = tempType2;
            String tempEntry =entry[counter];
            entry[counter] = entry[i];
            entry[i] = tempEntry;
            int tempTotal =total[counter];
            total[counter] = total[i];
            total[i] = tempTotal;
            int tempHp =hp[counter];
            hp[counter] = hp[i];
            hp[i] = tempHp;
            int tempAtk =atk[counter];
            atk[counter] = atk[i];
            atk[i] = tempAtk;
            int tempDef =def[counter];
            def[counter] = def[i];
            def[i] = tempDef;
            int tempSpa =spa[counter];
            spa[counter] = spa[i];
            spa[i] = tempSpa;
            int tempSpd =spd[counter];
            spd[counter] = spd[i];
            spd[i] = tempSpd;
            int tempSpe =spe[counter];
            spe[counter] = spe[i];
            spe[i] = tempSpe;
            counter++;
        }
    }
    String tempPokemon = pokemon[pivot];
    pokemon[pivot] = pokemon[counter];
    pokemon[counter] = tempPokemon;
    String tempType =type[pivot];
            type[pivot] = type[counter];
            type[counter] = tempType;
     String tempType2 =type2[pivot];
            type2[pivot] = type2[counter];
            type2[counter] = tempType2;
            String tempEntry =entry[pivot];
            entry[pivot] = entry[counter];
            entry[counter] = tempEntry;
     int tempTotal =total[pivot];
            total[pivot] = total[counter];
            total[counter] = tempTotal;
            int tempHp =hp[pivot];
            hp[pivot] = hp[counter];
            hp[counter] = tempHp;
            int tempAtk =atk[pivot];
            atk[pivot] = atk[counter];
            atk[counter] = tempAtk;
            int tempDef =def[pivot];
            def[pivot] = def[counter];
            def[counter] = tempDef;
            int tempSpa =spa[pivot];
            spa[pivot] = spa[counter];
            spa[counter] = tempSpa;
            int tempSpd =spd[pivot];
            spd[pivot] = spd[counter];
            spd[counter] = tempSpd;
            int tempSpe =spe[pivot];
            spe[pivot] = spe[counter];
            spe[counter] = tempSpe;
    return counter;
}
 //partition method for quickSortAlpha
  static int partition(String[] array1,String[] array2,String[] pokemon,String[] type ,String[] type2, int lines,String[] entry,int[]total,int[]hp,int[]atk,int[]def,int[]spa,int[]spd,int spe[], int begin, int end) {  
    int pivot = end;

    int counter = begin;
    for (int i = begin; i < end; i++) {
        if ((array1[i]+array2[i]).compareTo((array1[pivot]+array2[pivot]))<0) {
           String tempPokemon = pokemon[counter];
            pokemon[counter] = pokemon[i];
            pokemon[i] = tempPokemon;
            String tempType =type[counter];
            type[counter] = type[i];
            type[i] = tempType;
            String tempType2 =type2[counter];
            type2[counter] = type2[i];
            type2[i] = tempType2;
            String tempEntry =entry[counter];
            entry[counter] = entry[i];
            entry[i] = tempEntry;
            int tempTotal =total[counter];
            total[counter] = total[i];
            total[i] = tempTotal;
            int tempHp =hp[counter];
            hp[counter] = hp[i];
            hp[i] = tempHp;
            int tempAtk =atk[counter];
            atk[counter] = atk[i];
            atk[i] = tempAtk;
            int tempDef =def[counter];
            def[counter] = def[i];
            def[i] = tempDef;
            int tempSpa =spa[counter];
            spa[counter] = spa[i];
            spa[i] = tempSpa;
            int tempSpd =spd[counter];
            spd[counter] = spd[i];
            spd[i] = tempSpd;
            int tempSpe =spe[counter];
            spe[counter] = spe[i];
            spe[i] = tempSpe;
            counter++;
        }
    }
    String tempPokemon = pokemon[pivot];
    pokemon[pivot] = pokemon[counter];
    pokemon[counter] = tempPokemon;
    String tempType =type[pivot];
            type[pivot] = type[counter];
            type[counter] = tempType;
     String tempType2 =type2[pivot];
            type2[pivot] = type2[counter];
            type2[counter] = tempType2;
            String tempEntry =entry[pivot];
            entry[pivot] = entry[counter];
            entry[counter] = tempEntry;
     int tempTotal =total[pivot];
            total[pivot] = total[counter];
            total[counter] = tempTotal;
            int tempHp =hp[pivot];
            hp[pivot] = hp[counter];
            hp[counter] = tempHp;
            int tempAtk =atk[pivot];
            atk[pivot] = atk[counter];
            atk[counter] = tempAtk;
            int tempDef =def[pivot];
            def[pivot] = def[counter];
            def[counter] = tempDef;
            int tempSpa =spa[pivot];
            spa[pivot] = spa[counter];
            spa[counter] = tempSpa;
            int tempSpd =spd[pivot];
            spd[pivot] = spd[counter];
            spd[counter] = tempSpd;
            int tempSpe =spe[pivot];
            spe[pivot] = spe[counter];
            spe[counter] = tempSpe;
    return counter;
}
  //method to get index of pokemon name
  public static int findPokemon (String array[], String name){
    //go through the whole array
    for (int i = 0; i< array.length;i++) {
      if(array[i].equalsIgnoreCase(name)==true){
        return i;//name found, return the index of the name
      }
      
    }
    return -1;//not found, return a negative index
  }
  //method to get pokemon info
  public static String getInfo (String pokemonToFind,String[] pokemon,String[] type ,String[] type2,String[] entry,int[]total,int[]hp,int[]atk,int[]def,int[]spa,int[]spd,int spe[]) throws IOException {
  
    int lines= getLines();//calls function to get number of lines
 
    
    String info="";
    
    //calls method to get index of pokemon
    int loc = findPokemon(pokemon,pokemonToFind);
    
    //to display the information of the pokemon
    if(loc >=0)  info = "\n\n\n" + entry[loc] +" " + pokemon[loc] + " is a " + type[loc] + " " + type2[loc] + " type pokemon and its base stats are as follows:\n Hitpoints-" + hp[loc] +",Attack Stat-"+atk[loc]+",Defense Stat-"+def[loc]+",Special Attack Stat-"+spa[loc]+"\nSpecial Defense Stat-"+spd[loc]+",Speed Stat-"+spe[loc]+",Stat Total of "+total[loc]   ;
    else info = pokemonToFind + " not found";
    
    
    return info;//returns pokemon information
 
  }
  
  //quick sort method for string variables
public static void quickSortAlpha(String[]array1, String[]array2, String[] pokemon,String[] type ,String[] type2, int lines,String[] entry,int[]total,int[]hp,int[]atk,int[]def,int[]spa,int[]spd,int spe[], int begin, int end) {  
    if (end <= begin) return;
    int pivot = partition(array1,array2,pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,end);
    quickSortAlpha(array1,array2,pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,pivot-1);
    quickSortAlpha(array1,array2,pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe,pivot+1, end);
}
//quick sort method for integer variables
public static void quickSortDig(int[] arrayNumber,String[] pokemon,String[] type ,String[] type2, int lines,String[] entry,int[]total,int[]hp,int[]atk,int[]def,int[]spa,int[]spd,int spe[], int begin, int end) {  
    if (end <= begin) return;
    int pivot = partition2(arrayNumber,pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,end);
    quickSortDig(arrayNumber,pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,pivot-1);
    quickSortDig(arrayNumber,pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe,pivot+1, end);
}
  //main method
  public static void main(String[] args) {   
  }
}
