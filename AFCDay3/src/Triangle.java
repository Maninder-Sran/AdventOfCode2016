
public class Triangle {
	private int[] sideLengths = new int[3];
	
	public Triangle(String side1, String side2, String side3){
		sideLengths[0] = Integer.valueOf(side1);
		sideLengths[1] = Integer.valueOf(side2);
		sideLengths[2] = Integer.valueOf(side3);
	}
	public boolean doesExist(){
		if(sideLengths[0] + sideLengths[1] > sideLengths[2] &&
			sideLengths[0] + sideLengths[2] > sideLengths[1]&&
			sideLengths[1] + sideLengths[2] > sideLengths[0])
			return true;
		
		return false;
	}
}
