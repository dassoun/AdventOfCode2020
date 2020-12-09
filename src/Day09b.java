import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day09b {

	public static void main(String[] args) {
		String fileName = "inputs/day09a.txt";
		
		ArrayList<Long> list = new ArrayList<Long>();
		list = FileTransfom.fileToLongList(fileName);

		long valueToFind = 1124361034;
		long sum = 0;
		
		long min = 0;
		long max = 0;
		
		boolean found = false;
		
		int i = 0;
		while (i < list.size()) {
			int j = i + 1;
			sum = 0;
			while (!found && sum < valueToFind && j < list.size()) {
				if (j == i + 1) {
					sum = list.get(i) + list.get(j);
					min = Math.min(list.get(i), list.get(j));
					max = Math.max(list.get(i), list.get(j));
				} else {
					sum += list.get(j);
					
					min = Math.min(min, list.get(j));
					max = Math.max(max, list.get(j));
				}
				
				if (sum == valueToFind) {
					System.out.println(min + max);
					
					found = true;
				}
				
				j++;
			}
			
			i++;
		}
	}

}
