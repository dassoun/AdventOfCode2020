import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day01b {

	public static void main(String[] args) {
		String fileName = "inputs/day01a.txt";
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = FileTransfom.fileToIntList(fileName);
		
		boolean found = false;
		int i = 0;
		int val1 = 0, val2 = 0, val3 = 0;
		while (!found && i < list.size()-2) {
			int j = i + 1;
			while (!found && j < list.size()-1) {
				int k = i + 2;
				while (!found && k < list.size()) {
					if (list.get(i) + list.get(j) + list.get(k) == 2020) {
						val1 = list.get(i);
						val2 = list.get(j);
						val3 = list.get(k);
						found = true;
					}
					
					k++;
				}
				
				j++;
			}
			
			i++;
		}
		
		System.out.println("val 1 = " + val1);
		System.out.println("val 2 = " + val2);
		System.out.println("val 3 = " + val3);
		System.out.println("Res = " + (val1 * val2 * val3));
	}

}
