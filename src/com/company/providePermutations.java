package com.company;
import java.util.ArrayList;

public class providePermutations {
    ArrayList<String> stringArray= new ArrayList<>();

    //TODO: Swapping the indexes
    private String[] swap(String[] word, int index1, int index2){
        String temp= word[index1];
        word[index1]= word[index2];
        word[index2]= temp;
        return word;
    }

    //TODO: Making the string into words
    private String stringConverter(String[] word){
        String finalWord="";
        for(String alphabet: word){
            finalWord += alphabet;
        }
        return finalWord;
    }

    //TODO: Private method to calculate the permutations
    private void allPossibleWords(String[] word, int starting_index){
        if(starting_index == word.length-1){
            String finalWord= stringConverter(word);
            stringArray.add(finalWord);
        }

        for(int i=starting_index;i<word.length;i++){
            swap(word, i, starting_index);
            allPossibleWords(word, starting_index+1);
            swap(word, i, starting_index);
        }
    }

    //TODO: Find factorial
    private int Factorial(String word){
        int fact= 1;
        for(int i=2;i<=word.length();i++){
            fact*=i;
        }
        return fact;
    }

    //TODO: public method to be actually called for the combinations
    public String[] Possibility(String word){
        String[] wordArray= word.split("");
        allPossibleWords(wordArray, 0);
        String[] finalWordArray = new String[Factorial(word)-1];
        int j=0;
        for(String eachWord: stringArray){
            if(eachWord.equals(word)){
                continue;
            }
            finalWordArray[j] = eachWord;
            j++;
        }
        return finalWordArray;
    }
}
