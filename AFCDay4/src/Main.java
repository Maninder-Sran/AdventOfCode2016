import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		String line = "";
		String[] values = new String[4];
		int sectorIdSum = 0;
		int sectorId = 0;
		String roomName = "northpole object storage";
		
		while(true){
			if((line = input.nextLine().trim()).isEmpty())
				break;
			
			values = line.split("-");
			Decrypt enigma = new Decrypt(values);
			if(enigma.isReal()){
				sectorIdSum += enigma.getSectorId();
				if(enigma.getRoomName().trim().equals(roomName)){
					sectorId = enigma.getSectorId();
				}
			}
		}
		System.out.println(sectorIdSum +" "+sectorId);
		input.close();
	}

}
