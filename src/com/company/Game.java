package com.company;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public void game() throws Exception {
        Random rand= new Random();
        wordCollectionArray wordsCollection= new wordCollectionArray();
        providePermutations allCombo= new providePermutations();
        ResultChecker result= new ResultChecker();
        Scanner sc= new Scanner(System.in);
        String[] wordArray= wordsCollection.publicDictionaryEnglish();
        int RandomQuestionBaseWord= rand.nextInt(wordArray.length);
        String word= wordArray[RandomQuestionBaseWord];
        String[] jumbledWordArray= allCombo.Possibility(word);
        int RandomQuestionJumbledWord= rand.nextInt(jumbledWordArray.length);
        String jumbledWord= jumbledWordArray[RandomQuestionJumbledWord];
        System.out.println("The jumbled word is: "+jumbledWord);
        System.out.println("Enter your answer: ");
        String answer= sc.next();
        result.winChecker(answer.toLowerCase(Locale.ROOT), jumbledWord, word);
    }
}
