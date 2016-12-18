
public class Decompresser {
	private StringBuilder phrase = new StringBuilder(50);
	
	public void decompress(String line,int pos){
		for(int i = pos; i < line.length(); i++){
			if(line.charAt(i) != '('){
				phrase.append(line.charAt(i));
			}else{
				String numChar = "";
				String repeats = "";
				boolean flag = true;
				i++;
				while(line.charAt(i) != ')'){
					if(flag){
						if(line.charAt(i) != 'x'){
							numChar += line.charAt(i);
							i++;
						}else{
							flag = false;
							i++;
						}	
					}else{
						repeats += line.charAt(i);
						i++;
					}
				}
				expanded(line,i,Integer.valueOf(numChar),Integer.valueOf(repeats));
				i += Integer.valueOf(numChar);
			}	
		}
	}

	private void expanded(String line, int pos,int numChar, int repeats) {
		for(int i = 0; i < repeats; i++){
			for(int j = pos; j < pos + numChar; j++){
				if(line.charAt(i) != '(')
					phrase.append(line.charAt(j));
				else
					decompress(line,j);
			}
		}
	}
	public int sizeOfDecompressed(){
		return phrase.length();
	}
}
