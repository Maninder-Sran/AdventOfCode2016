import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Decompresser formatter = new Decompresser();
		String line = "";
		
		while(!(line = input.nextLine().trim()).isEmpty()){
			formatter.decompress(line,0);
		}
		System.out.println(formatter.sizeOfDecompressed());
		input.close();
	}

}
