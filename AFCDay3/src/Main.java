import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = " ";
		String[][] triangleLengths = new String[3][3];
		int numOfTriangles = 0;
		int numLine = 0;
		int triangleIndex = 0;
		
		while(true){
			
			if((line = input.nextLine().trim()).isEmpty())
				break;
			numLine++;
			
			String[] lengths = {"","",""};
			boolean isComplete = false;
			int index = 0;
			
			for(int i = 0; i < line.length();i++){
				if(line.charAt(i) != ' '){
					lengths[index] += line.charAt(i);
					isComplete = true;
				}
				else if(isComplete){
					index++;
					isComplete = false;
				}		
			}
			
			for(int i = 0; i < lengths.length; i++){
				triangleLengths[i][triangleIndex] = lengths[i];
			}
			triangleIndex++;
			
			if(numLine == 3){
				Triangle triangle1 = new Triangle(triangleLengths[0][0],triangleLengths[0][1],triangleLengths[0][2]);
				Triangle triangle2 = new Triangle(triangleLengths[1][0],triangleLengths[1][1],triangleLengths[1][2]);
				Triangle triangle3 = new Triangle(triangleLengths[2][0],triangleLengths[2][1],triangleLengths[2][2]);
				if(triangle1.doesExist())
					numOfTriangles++;
				if(triangle2.doesExist())
					numOfTriangles++;
				if(triangle3.doesExist())
					numOfTriangles++;
				
				numLine = 0;
				triangleIndex = 0;
			}
		}
		System.out.println(numOfTriangles);
		input.close();
	}

}
