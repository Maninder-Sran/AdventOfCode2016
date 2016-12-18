import java.util.ArrayList;

public class AssemBunny {
	private int a = 0;
	private int b = 0;
	private int c = 1;
	private int d = 0;
	private int currInstruction = 0;
	private ArrayList<String> instructions = null;

	public void setInstructions(ArrayList<String> instructions) {
		this.instructions = instructions;
		while(currInstruction < instructions.size()){
			executeInstruction(instructions.get(currInstruction).split(" "));
			currInstruction++;
		}
	}

	private void executeInstruction(String[] instruction) {

		if(instruction[0].equals("cpy")){
			switch(instruction[1].charAt(0)){
			case 'a':
				b = (instruction[2].charAt(0) == 'b') ? a : b;
				c = (instruction[2].charAt(0) == 'c') ? a : c;
				d = (instruction[2].charAt(0) == 'd') ? a : d;
				break;
			case 'b':
				a = (instruction[2].charAt(0) == 'a') ? b : a;
				c = (instruction[2].charAt(0) == 'c') ? b : c;
				d = (instruction[2].charAt(0) == 'd') ? b : d;
				break;
			case 'c':
				a = (instruction[2].charAt(0) == 'a') ? c : a;
				b = (instruction[2].charAt(0) == 'b') ? c : b;
				d = (instruction[2].charAt(0) == 'd') ? c : d;
				break;
			case 'd':
				a = (instruction[2].charAt(0) == 'a') ? d : a;
				b = (instruction[2].charAt(0) == 'b') ? d : b;
				c = (instruction[2].charAt(0) == 'c') ? d : c;
				break;
			default:
				a = (instruction[2].charAt(0) == 'a') ? Integer.valueOf(instruction[1]) : a;
				b = (instruction[2].charAt(0) == 'b') ? Integer.valueOf(instruction[1]) : b;
				c = (instruction[2].charAt(0) == 'c') ? Integer.valueOf(instruction[1]) : c;
				d = (instruction[2].charAt(0) == 'd') ? Integer.valueOf(instruction[1]) : d;
				break;
			}
		}else if(instruction[0].equals("inc")){
			switch(instruction[1].charAt(0)){
			case 'a':a++;break;
			case 'b':b++;break;
			case 'c':c++;break;
			case 'd':d++;break;
			}
		}else if(instruction[0].equals("dec")){
			switch(instruction[1].charAt(0)){
			case 'a':a--;break;
			case 'b':b--;break;
			case 'c':c--;break;						
			case 'd':d--;break;
			}
		}else if(instruction[0].equals("jnz")){
			int offset = Integer.valueOf(instruction[2])-1;
			if(getValue(instruction[1].charAt(0)) != 0){
				if((currInstruction + offset) <= instructions.size()-1){
					currInstruction += offset;
				}
			}
		}
	}

	public int getValue(char register) {
		switch(register){
		case 'a':return a;
		case 'b':return b;
		case 'c':return c;
		case 'd':return d;
		default: return 1;
		}
	}
}
