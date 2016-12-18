import java.util.ArrayList;

public class Decrypt {
	private String roomName = "";
	private String data = "";
	private String checkSum = "";
	private int sectorId;
	private ArrayList<Integer> characters = new ArrayList<>();
	private boolean[] checked = new boolean[26];
	private String[] highestFreqChar = {"z","z","z","z","z"};
	private int[] highestFreqVal = new int[5];
	
	public Decrypt(String[] values){
		for(int i = 0; i < values.length-1;i++){
			this.data += values[i];
			this.roomName += " "+values[i];
		}
		this.sectorId = Integer.valueOf(values[values.length-1].substring(0,3));
		this.checkSum = values[values.length-1].substring(4,9);
		initCharacters();
	}
	private void initCharacters(){
		for(int i = 0; i < 26; i++){
			characters.add(0);
		}
	}
	public boolean isReal(){
		calcFrequency();
		String temp = "";
		for(int i = 0; i < highestFreqChar.length; i++){
			temp += highestFreqChar[i];
		}
		if(temp.equals(checkSum))
			return true;
		
		return false;
	}
	public int getSectorId(){
		return sectorId;
	}
	public String getRoomName(){
		char[] letters = roomName.toCharArray();
		this.roomName = "";
		for(int i = 0; i < letters.length; i++){
			if(letters[i] != ' '){
				int offset = sectorId % 26;
				letters[i] = (char)(((((int)(letters[i]) - 97)+offset) % 26) + 97);
			}
			this.roomName += String.valueOf(letters[i]);
		}
		return this.roomName;
	}
	private void calcFrequency(){
		for(int i = 0; i < data.length(); i++){
			characters.set(((int)(data.charAt(i))-97), characters.get(((int)(data.charAt(i))-97))+1);
		}
		findHighest(data.length(),0);
		for(int i = 1; i < highestFreqVal.length;i++){
			findHighest(highestFreqVal[i-1],i);
		}
			
	}
	private void findHighest(int max,int pos){
		int distance = max;
		boolean flag = false;
		for(int i = 0; i < characters.size(); i++){
			if((max - characters.get(i)) < distance && !checked[i]){
				if(flag){
					checked[(int)(highestFreqChar[pos].charAt(0))-97] = false;
				}
				distance = max - characters.get(i);
				highestFreqVal[pos] = characters.get(i);
				highestFreqChar[pos] = String.valueOf((char)(i+97));
				checked[i] = true;
				flag = true;
			}else if(max - characters.get(i) == distance && !checked[i]){
				highestFreqChar[pos] = ((i+97) < (int)(highestFreqChar[pos].charAt(0))) ? String.valueOf((char)(i+97)) : highestFreqChar[pos];
			}
		}
	}
}
