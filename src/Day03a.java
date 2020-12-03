import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day03a {

	public static void main(String[] args) {
		String fileName = "inputs/day03a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);
		
		int count = 0;
		
		int nbLines = list.size();
		int nbRows = list.get(0).length();
		
		int i = 0;
		int j = 0;
		do {
			i++;
			j += 3;
			if (j >= nbRows) {
				j = j - nbRows;
			}
			
			if (list.get(i).charAt(j) == '#') {
				count++;
			}
			
		} while (i < nbLines - 1);
		
		System.out.println(count);

	}

}
