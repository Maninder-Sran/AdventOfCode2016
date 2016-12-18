import java.util.ArrayList;

public class Map {
	private int x = 0;
	private int y = 0;
	private char orientation = 'N';
	private int crossDistance = 0;
	private int intersection = 0;
	private boolean intersected = false;
	private ArrayList<String> positions = new ArrayList<>();
	
	public int getNetDistance(){
		if(!intersected)
			return Math.abs(x) + Math.abs(y);
		System.out.println("\n"+positions.get(intersection));
		return crossDistance;
	}
	
	public void position(String instruction){
		turn(instruction.charAt(0));
		move(Integer.valueOf(instruction.substring(1)));
	}
	private boolean checkPosition(){
		if(positions.contains(x + "," + y)){return true;}
		return false;
	}
	private void move(int distance){
		switch(orientation){
		case 'N':
			y += distance;
			if(checkPosition() && !intersected){setIntersection();}
			else{addPositions(distance,'N');}
			break;
		case 'E':
			x += distance;
			if(checkPosition() && !intersected){setIntersection();}
			else{addPositions(distance,'E');}
			break;
		case 'S':
			y -= distance;
			if(checkPosition() && !intersected){setIntersection();}
			else{addPositions(distance,'S');}
			break;
		case 'W':
			x -= distance;
			if(checkPosition() && !intersected){setIntersection();}
			else{addPositions(distance,'W');}
			break;
		}
	}
	private void addPositions(int distance,char direction) {
		for(int i = distance; i >= 0; i--){
			String coord = "";
			switch(direction){
			case 'N':coord = x + ","+ (y-i);break;
			case 'E':coord = (x-i) + "," + y;break;
			case 'S':coord = x + "," + (y+i);break;
			case 'W':coord = (x+i) + "," + y;break;
			}
			if(!positions.contains(coord)){
				positions.add(coord);
				System.out.println(coord);
			}
		}
	}

	private void setIntersection(){
		intersection = positions.indexOf(x + "," + y);
		intersected = true;
		System.out.println("\n"+positions.get(intersection)+"\n");
		String[] pos = positions.get(intersection).split(",");
		crossDistance = Math.abs(Integer.valueOf(pos[0])) + Math.abs(Integer.valueOf(pos[1]));
	}
	private void turn(char turn){
		switch(turn){
		case 'R':
			switch(orientation){
			case 'N': orientation = 'E'; break;
			case 'E': orientation = 'S'; break;
			case 'S': orientation = 'W'; break;
			case 'W': orientation = 'N'; break;
			}
			break;
		case 'L':
			switch(orientation){
			case 'N': orientation = 'W'; break;
			case 'W': orientation = 'S'; break;
			case 'S': orientation = 'E'; break;
			case 'E': orientation = 'N'; break;
			}
			break;
		}
	}
}
