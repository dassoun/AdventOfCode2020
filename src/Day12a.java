import java.util.ArrayList;
import java.util.HashMap;

import com.jco.utils.FileTransfom;

public class Day12a {

	public static void main(String[] args) {
		String fileName = "inputs/day12a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);

		HashMap<Integer, String> facingMap = new HashMap<Integer, String>();
		facingMap.put(0, "E");
		facingMap.put(90, "S");
		facingMap.put(180, "W");
		facingMap.put(270, "N");
		facingMap.put(-90, "N");
		facingMap.put(-180, "W");
		facingMap.put(-270, "S");
		
		int facing = 0;
		
		int horizontalMove = 0;
		int verticalMove = 0;
		
		System.out.println("Facing : " + facingMap.get(facing) + ", Horizontal : " + horizontalMove + ", Vertical : " +  verticalMove);
		
		int i = 0;
		for (String s : list) {
			i++;
			
			String move = s.substring(0, 1);
			int nb = Integer.valueOf(s.substring(1));
			
			switch (move) {
				case "N":
					verticalMove += nb;
					break;
				case "S":
					verticalMove -= nb;
					break;
				case "E":
					horizontalMove += nb;
					break;
				case "W":
					horizontalMove -= nb;
					break;
				case "L":
					facing -= nb;
					facing = facing % 360;
					break;
				case "R":
					facing += nb;
					facing = facing % 360; 
					break;
				case "F":
					switch (facingMap.get(facing)) {
						case "N":
							verticalMove += nb;
							break;
						case "S":
							verticalMove -= nb;
							break;
						case "E":
							horizontalMove += nb;
							break;
						case "W":
							horizontalMove -= nb;
							break;
					}
					break;
			}
			
			System.out.println(s + " --> Facing : " + facingMap.get(facing) + ", Horizontal : " + horizontalMove + ", Vertical : " +  verticalMove);
		}
		
		System.out.println(Math.abs(verticalMove) + Math.abs(horizontalMove));
	}

}
