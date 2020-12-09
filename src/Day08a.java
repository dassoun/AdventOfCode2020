import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day08a {

	public static void main(String[] args) {
		String fileName = "inputs/day08a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);

		ArrayList<Integer> opList = new ArrayList<Integer>();
		boolean looped = false;
		
		int acc = 0;
		
		int i = 0;
		do {
			opList.add(i);
			
			String s = list.get(i);
			String[] tmp = s.split(" ");
			
			switch (tmp[0]) {
				case "acc":
					acc += Integer.valueOf(tmp[1]);
					i++;
					break;
				case "jmp":
					i += Integer.valueOf(tmp[1]);
					break;
				case "nop":
					i++;
					break;
				default:
					break;
			}
			
			int index = opList.indexOf(i);
			if (index != -1) {
				looped = true;
			}
			
		} while (i < list.size() && !looped);
		
		System.out.println(acc);
	}

}
