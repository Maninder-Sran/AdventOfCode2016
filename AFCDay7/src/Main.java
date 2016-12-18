import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = "";
		int validIPABBA = 0;
		int validSSLIP = 0;
		while(!(line = input.nextLine().trim()).isEmpty()){
			TLSVerifier authenticator = new TLSVerifier(line);
			if(authenticator.isValidIP())
				validIPABBA++;
			if(authenticator.isValidSSLIP())
				validSSLIP++;
		}
		System.out.println("\n"+validIPABBA);
		System.out.println("\n"+validSSLIP);
		input.close();
	}
}
