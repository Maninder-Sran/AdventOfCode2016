import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		LCDScreen screen = new LCDScreen(6,50);
		String line = "";
		while(!(line = input.nextLine().trim()).isEmpty()){
			System.out.println();
			screen.updateScreen(line);
			screen.printScreen();
			
		}
		System.out.println(screen.numberOfPixelsOn());
		input.close();
	}
}
