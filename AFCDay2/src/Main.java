import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		StringBuilder passcode = new StringBuilder(5);
		String[] instructions = new String[5];
		
		for(int i = 0; i < instructions.length;i++){
			instructions[i] = input.nextLine();
		}
		for(int i = 0; i < instructions.length; i++){
			passcode.append((new Passcode(instructions[i]).getPasscode()));
		}
		System.out.println(passcode.toString());
		input.close();
	}
}
