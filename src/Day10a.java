import java.util.ArrayList;
import java.util.Arrays;

import com.jco.utils.FileTransfom;

public class Day10a {

	public static void main(String[] args) {
		String fileName = "inputs/day10a.txt";
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = FileTransfom.fileToIntList(fileName);
		
		Integer[] tab = list.toArray(new Integer[0]);
		
		Arrays.sort(tab);
		
		int count1Jolt = 0;
		int count3Jolt = 0;
		
		int currentAdapter = 0;
		int diff = 0;
		
		int count = 0;
		for (int i = 0; i < tab.length; i++) {
			if (i == 0) {
				currentAdapter = tab[i];
				if (currentAdapter == 1) {
					count1Jolt += 1;
				} else {
					count3Jolt += 1;
				}
			} else {
				diff = tab[i] - tab[i - 1];
				currentAdapter = diff;
				if (currentAdapter == 1) {
					count1Jolt += 1;
				} else {
					count3Jolt += 1;
				}
			}
		}
		count3Jolt += 1;
		
		System.out.println(count1Jolt + " / " + count3Jolt);
		System.out.println(count1Jolt * count3Jolt);
	}

}
