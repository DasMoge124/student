public class Main{
    public static String makePalindrome(String word){
        String otherWord = "";
        for (int i = word.length()-1; i>=0;i--){
            otherWord += word.charAt(i);
        }
        if (otherWord.equals(word)){
            return otherWord;
        }
        else{
            return "Nothing";
        }
    }
    public static int determineScore(int wordLength){
        if (wordLength%2 == 0){
            return wordLength * 2;
        }
        else{
            return wordLength;
        }
    }
    public static void main(String[] args){
        int Score = 0;
        String word = "radar";
        String otherWord = makePalindrome(word.toLowerCase());
        if (otherWord != "Nothing"){
            Score = determineScore(otherWord.length());
        }
        System.out.println(Score);
    }
}