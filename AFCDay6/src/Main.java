import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Decrypt enigma = null;
        String line; 
        
        while(!(line = input.nextLine().trim()).isEmpty()){
            if(enigma == null)
                enigma = new Decrypt(line.length());
            
            enigma.findFrequency(line); 
        }
        System.out.println(enigma.toString());
        input.close();
    }
}