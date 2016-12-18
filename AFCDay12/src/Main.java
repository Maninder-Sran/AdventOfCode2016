import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		ArrayList<String> instructions = new ArrayList<>();
		AssemBunny computer = new AssemBunny();
		String line = "";
		
		while(!(line = input.nextLine().trim()).isEmpty()){
			instructions.add(line);
		}
		computer.setInstructions(instructions);
		System.out.println(computer.getValue('a'));
		input.close();
	}

}
