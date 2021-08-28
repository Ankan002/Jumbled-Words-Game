package com.company;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

class Empty extends Exception{
    Empty(String s){
        super(s);
    }
}

public class ResultChecker {

    //TODO: Private method to check whether the returned word is available in the dictionary or not as well as is it correct according to the game rules....
    private boolean isCorrect(String answer, String jumbledQuestion)throws Exception{
        if(answer.isEmpty()){
            throw new Empty("The answer is empty");
        }
        if((answer.length()<jumbledQuestion.length())  ||  (answer.length()>jumbledQuestion.length())){
            return false;
        }
        wordCollectionArray wordCollection= new wordCollectionArray();
        String[] wordAvailableArray= wordCollection.publicDictionaryEnglish();
        Set<String> wordSet= new HashSet<>();
        Collections.addAll(wordSet, wordAvailableArray);
        if(!wordSet.contains(answer)){
            return false;
        }
        Map<Character, Integer> charMap= new HashMap<>();
        for(int i=0;i<jumbledQuestion.length();i++){
            Integer count= charMap.get(jumbledQuestion.charAt(i));
            if(count==null){
                charMap.put(jumbledQuestion.charAt(i), 1);
            }
            else{
                charMap.put(jumbledQuestion.charAt(i), count+1);
            }
        }
        boolean isCorrect= true;
        for(int i=0;i<answer.length();i++){
            Integer count= charMap.get(answer.charAt(i));
            if((count==null) || (count==0)){
                isCorrect=false;
                break;
            }
            else{
                charMap.put(answer.charAt(i), count-1);
            }
        }
        return isCorrect;
    }

    //TODO: Public and the actual method responsible for declaring the result...
    public void winChecker(String answer, String jumbledQuestion, String ActualQuestion) throws Exception {
        if(isCorrect(answer, jumbledQuestion)){
            System.out.println("The answer is correct.......");
        }
        else{
            System.out.println("The answer is wrong......."+" The actual answer was "+ActualQuestion+"....");
        }
    }
}
