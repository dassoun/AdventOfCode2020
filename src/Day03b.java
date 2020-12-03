import java.math.BigInteger;
import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day03b {

	public static void main(String[] args) {
		String fileName = "inputs/day03a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);
		
		long count1 = countCharByPattern(list, 1, 1);
		long count2 = countCharByPattern(list, 3, 1);
		long count3 = countCharByPattern(list, 5, 1);
		long count4 = countCharByPattern(list, 7, 1);
		long count5 = countCharByPattern(list, 1, 2);
		
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
		System.out.println(count4);
		System.out.println(count5);
		
		
		System.out.println(count1 * count2 * count3 * count4 * count5);
	}
	
	private static long countCharByPattern(ArrayList<String> list, int x, int y) {
		long count = 0;
		
		int nbLines = list.size();
		int nbRows = list.get(0).length();
		
		int i = 0, j = 0;
		
		do {
			i += y;
			j += x;
			if (j >= nbRows) {
				j = j - nbRows;
			}
			
//			System.out.println("i: " + i + ", j: " + j + ", car: " + list.get(i).charAt(j));
			
			if (list.get(i).charAt(j) == '#') {
				count++;
			}
			
		} while (i < nbLines - y);
		
		return count;
	}

}
