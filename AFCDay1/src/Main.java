import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Map tracker = new Map();
		String line = input.nextLine();
		
		String[] directions = line.trim().split(", ");
		
		for(String instruction : directions)
		{
			tracker.position(instruction);
		}
		
		System.out.println(tracker.getNetDistance());
		input.close();
	}

}
