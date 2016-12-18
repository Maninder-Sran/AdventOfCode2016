import java.util.ArrayList;
import java.util.regex.Pattern;

public class TLSVerifier {
	private boolean isValidIP = false; 
	private boolean isValidIPSSL = false;
	private ArrayList<String> BAB = new ArrayList<>();
	public TLSVerifier(String line){
		String[] fragments = ((line.replaceAll(Pattern.quote("["), " ")).replaceAll(Pattern.quote("]"), " ")).split(" ");
		determineTLS(fragments);
		determineSSL(fragments);
		
	}
	private void determineSSL(String[] fragments) {
		boolean flag = false;
		for(int i = 0; i < fragments.length; i+=2){
			if(containsABA(fragments[i])){
				for(int j = 1; j < fragments.length; j+=2){
					if(containsBAB(fragments[j]) && j != fragments.length - 1){
						isValidIPSSL = true;
						flag = true;
						break;
					}
				}
				if(flag){break;}
			}
		}	
	}
	private void determineTLS(String[] fragments){
		boolean flag = true;
		for(int i = 1; i < fragments.length; i+=2){
			if(!(isValidIP = !containsABBA(fragments[i])) && i != fragments.length-1){
				flag = false;
				break;
			}	
		}
		if(flag){
			for(int i = 0; i < fragments.length; i+=2){
				if((isValidIP = containsABBA(fragments[i])))
						break;
			}
		}
	}
	private boolean containsABBA(String line){
		char[] sequence = new char[4];
		for(int i = 0; i < line.length() - 3; i++){
			for(int j = 0; j < sequence.length; j++){
				sequence[j] = line.charAt(i+j);
			}
			if(sequence[0] == sequence[3] && sequence[1] == sequence[2] && sequence[0] != sequence[1])
				return true;
		}
		return false;
	}
	private boolean containsABA(String line){
		boolean flag = false;
		char[] sequence = new char[3];
		for(int i = 0; i < line.length() - 2; i++){
			StringBuilder tempBAB = new StringBuilder(3);
			for(int j = 0; j < sequence.length; j++){
				sequence[j] = line.charAt(i+j);
			}
			if(sequence[0] == sequence[2] && sequence[0] != sequence[1]){
				tempBAB.append(String.valueOf(sequence[1]));
				tempBAB.append(String.valueOf(sequence[0]));
				tempBAB.append(String.valueOf(sequence[1]));
				BAB.add(tempBAB.toString());
				flag = true;
			}	
		}
		return flag;
	}
	private boolean containsBAB(String line){
		char[] sequence = new char[3];
		for(int i = 0; i < line.length() - 2; i++){
			for(int j = 0; j < sequence.length; j++){
				sequence[j] = line.charAt(i+j);
			}
			StringBuilder temp = new StringBuilder(3);
			temp.append(String.valueOf(sequence[0]));
			temp.append(String.valueOf(sequence[1]));
			temp.append(String.valueOf(sequence[2]));
			for(int k = 0; k < BAB.size(); k++){
				if(temp.toString().equals(BAB.get(k))){
					System.out.println(temp.toString() +"\t"+BAB.get(k));
					return true;
				}
			}
		}
		return false;
	}
	public boolean isValidIP() {
		return isValidIP;
	}
	public boolean isValidSSLIP() {
		System.out.println(isValidIPSSL);
		return isValidIPSSL;
	}
}
