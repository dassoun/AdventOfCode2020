import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day15a {

	public static void main(String[] args) {
		String fileName = "inputs/day15a.txt";
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = FileTransfom.inLineFileToIntList(fileName, ",");

		for (int turnNumber = list.size(); turnNumber < 2020; turnNumber++) {
			boolean found = false;
			int searchedNumber = list.get(turnNumber - 1);
			int j = turnNumber - 2;
			while (!found && j >= 0) {
				if (searchedNumber == list.get(j)) {
					found = true;
				} else {
					j--;
				}
			}
			if (found) {
				list.add((turnNumber) - (j + 1));
			} else {
				list.add(0);
			}
		}
		
		System.out.print(list.get(2019));
	}

}
