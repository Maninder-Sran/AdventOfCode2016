
public class LCDScreen {
	private int[][] screen;
	
	public LCDScreen(int screenHeight, int screenWidth){
		screen = new int[screenHeight][screenWidth];
	}
	
	public void updateScreen(String line){
		String[] instructions = line.split(" ");
		
		if(instructions[0].equals("rect")){
			displayRect(instructions[1]);
		}else {
			shiftDisplay(instructions[1], instructions[2], Integer.valueOf(instructions[4]));
		}
	}

	private void displayRect(String size) {
		String[] sizeOfRect = size.split("x");
		int width = Integer.valueOf(sizeOfRect[0]);
		int height = Integer.valueOf(sizeOfRect[1]);
		
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				screen[i][j] = 1;
			}
		}
	}
	private void shiftDisplay(String direction, String position, int offset){
		if(direction.equals("row")){
			int row = Integer.valueOf(position.substring(2));
			for(int i = 0; i < offset; i++){
				for(int j = screen[row].length - 1; j  > 0; j--){
					int temp = screen[row][j];
					screen[row][j] = screen[row][j - 1];
					screen[row][j -1] = temp; 
				}
			}
		  
		}else{
			int col = Integer.valueOf(position.substring(2));
			for(int i = 0; i < offset; i++){
				for(int j = screen.length - 1; j  > 0; j--){
					int temp = screen[j][col];
					screen[j][col] = screen[j - 1][col];
					screen[j - 1][col] = temp; 
				}
			}
		}
	}
	public void printScreen(){
		for(int i = 0; i < screen.length; i++){
			for(int j = 0; j < screen[i].length; j++){
				if(screen[i][j] == 1)
					System.out.print("#");
				else
					System.out.print("-");
			}
			System.out.println();
		}
	}
	public int numberOfPixelsOn() {
		int pixelsOn = 0;
		for(int i = 0; i < screen.length; i++){
			for(int j = 0; j < screen[i].length; j++){
				if(screen[i][j] == 1){
					pixelsOn++;
				}
			}
		}
		return pixelsOn;
	}
}


