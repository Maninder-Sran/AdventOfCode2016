
public class Passcode {
	//private int[][] lock = new int[3][3];
	private char lock[][] = {{' ',' ','1',' ',' '},{' ','2','3','4',' '},{'5','6','7','8','9'},{' ','A','B','C',' '},{' ',' ','D',' ',' '}};
	private int row;
	private int col;
	private String instructions;
	
	public Passcode(String instructions){
		this.instructions = instructions;
		this.row = 2;
		this.col = 0;
		//initLock();
	}
	public String getPasscode(){
		for(int i = 0; i < this.instructions.length(); i++){
			movePosLock(this.instructions.charAt(i));
		}
		return String.valueOf(lock[row][col]);
	}
	/*private void initLock(){
		int counter = 0;
		for(int i  = 0; i < lock.length;i++){
			for(int j = 0; j < lock[i].length;j++){
				counter++;
				lock[i][j] = counter; 
			}
		}
	}*/
	public void movePosLock(char direction){
		switch(direction){
		case 'U':
			row = (row > 0 && lock[row - 1][col] != ' ') ? row - 1 : row;
			break;
		case 'D':
			row = (row < 4 && lock[row + 1][col] != ' ') ? row + 1 : row;
			break;
		case 'L':
			col = (col > 0 && lock[row][col - 1] != ' ') ? col - 1 : col;
			break;
		case 'R':
			col = (col < 4 && lock[row][col + 1] != ' ') ? col + 1 : col;
			break;
		}
	}
}
