import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day13a {

	public static void main(String[] args) {
		String fileName = "inputs/day13a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);
		
		int timestamp = Integer.valueOf(list.get(0));
		
		String[] tab = list.get(1).split(",");
		
		ArrayList<Integer> timeList = new ArrayList<Integer>();
		
		for (String s : tab) {
			if (!s.contentEquals("x")) {
				timeList.add(Integer.valueOf(s));
			}
		}
		
		int id = 0;
		int minTime = 100000000;
		int time = 0;
		for (int i : timeList) {
			time = 0;
			while (time < timestamp) {
				time += i;
			}
			
			if (time < minTime) {
				minTime = time;
				id = i;
			}
		}
		
		System.out.println((minTime - timestamp) * id);
	}

}
