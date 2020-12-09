import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day09a {

	public static void main(String[] args) {
		String fileName = "inputs/day09a.txt";
		
		ArrayList<Long> list = new ArrayList<Long>();
		list = FileTransfom.fileToLongList(fileName);

		int preambleSize = 25;
		int currentIndex = preambleSize;
		boolean found = true;
		
		int i = currentIndex - 1;
		int j = currentIndex - 2;
		while (currentIndex < list.size() && found) {
			found = false;
			while (i >= (currentIndex - (preambleSize - 1)) && !found) {
				while (j >= (currentIndex - (preambleSize)) && !found) {
					if (list.get(i) + list.get(j) == list.get(currentIndex)) {
						System.out.println("currentIndex: " + currentIndex + ", " + list.get(i) + " + " + list.get(j) + " = " + list.get(currentIndex) + " (" + i + ", " + j + ")");
						found = true;
					}
					
					j--;
				}
				i--;
				j = i - 1;
			}
			if (found) {
				currentIndex++;
				i = currentIndex - 1;
				j = currentIndex - 2;
			} else {
				System.out.println(list.get(currentIndex));
			}
		}
		
	}

}
