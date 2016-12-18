
public class Decrypt{
    
    private int[][] charFrequency;
    private StringBuilder phrase = new StringBuilder(50);
    public Decrypt(int sentenceSize){
        charFrequency = new int[sentenceSize][26];
    }
    public void findFrequency(String line){
        line.toLowerCase();
        for(int i = 0, n = line.length(); i < n; i++){
            if(line.charAt(i) != ' '){
                charFrequency[i][((int)line.charAt(i)) - 97]++;
            }
            /*else{
                charFrequency[i][26]++; 
            }*/
        }
    }
    @Override
    public String toString(){
        for(int i = 0, n = charFrequency.length; i < n; i++){
            int lowFrequency = 100000;
            int posLow = 0;
            for(int j = 0, k = charFrequency[i].length; j < k; j++){
                if(charFrequency[i][j] < lowFrequency){
                    lowFrequency = charFrequency[i][j];
                    posLow = j;
                }
            }
           // if(posLow != 26)
                phrase.append(String.valueOf((char)(posLow+97)));
            /*else
                phrase.append(" ");*/
        }
        return phrase.toString();
    }
}