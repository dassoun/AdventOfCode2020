import java.util.ArrayList;

import com.jco.utils.FileTransfom;
import com.jco.utils.StringUtils;

public class Day11b {

	public static void main(String[] args) {
		String fileName = "inputs/day11a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);
		
		printLayout(list);

		int length = list.get(0).length();
		
		String tmp = StringUtils.padLeft('*', "", length + 2);
		list.add(0, tmp);
		for (int i = 1; i < list.size(); i++) {
			list.set(i, "*" + list.get(i) + "*");
		}
		list.add(tmp);
		
		ArrayList<String> newLayout = (ArrayList<String>) list.clone();
		
		int nbMove = 0;
			
		do {
			nbMove = 0;
			
			for (int i = 1; i < list.size() - 1; i++) {
				for (int j = 1; j < list.get(0).length() - 1; j++) {
					if (list.get(i).charAt(j) == 'L') {
						int nbOccupied = 0;
						
						
						if (poepleInDirection(list, i, j, 0, -1)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, -1, -1)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, -1, 0)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, -1, 1)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, 0, 1)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, 1, 1)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, 1, 0)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, 1, -1)) {
							nbOccupied++;
						}
						
						if (nbOccupied == 0) {
							newLayout.set(i, (StringUtils.replaceCharAt(newLayout.get(i), j, '#')));
							nbMove++;
						}
					} else if (list.get(i).charAt(j) == '#') {
						int nbOccupied = 0;

						if (poepleInDirection(list, i, j, 0, -1)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, -1, -1)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, -1, 0)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, -1, 1)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, 0, 1)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, 1, 1)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, 1, 0)) {
							nbOccupied++;
						}
						if (poepleInDirection(list, i, j, 1, -1)) {
							nbOccupied++;
						}
						
						if (nbOccupied >= 5) {
							newLayout.set(i, (StringUtils.replaceCharAt(newLayout.get(i), j, 'L')));
							nbMove++;
						}
//						System.out.println(list.get(i));
//						System.out.println(newLayout.get(i));
					}
				}
			}
			
			list = (ArrayList<String>) newLayout.clone();
			
			printLayout(list);			
			
		} while (nbMove > 0);
		
		printLayout(list);
		
		System.out.println();
	}
	
	public static void printLayout(ArrayList<String> list) {
		for (String l : list) {
			System.out.println(l);
		}
		System.out.println(countChar(list, '#'));
	}

	public static int countChar(ArrayList<String> list, char c) {
		int count = 0;
		
		for (int i = 1; i < list.size() - 1; i++) {
			for (int j = 1; j < list.get(0).length() - 1; j++) {
				if (list.get(i).charAt(j) == c) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static boolean poepleInDirection(ArrayList<String> list, int posI, int posJ, int dirI, int dirJ) {
		boolean res;
		
		if (list.get(posI + dirI).charAt(posJ + dirJ) == '*') {
			res = false;
		} else if (list.get(posI + dirI).charAt(posJ + dirJ) == '#') {
			return true;
		} else if (list.get(posI + dirI).charAt(posJ + dirJ) == 'L') {
			return false;
		} else {
			res = poepleInDirection(list, posI + dirI, posJ + dirJ, dirI, dirJ);
		}
		
		return res;
	}
}
