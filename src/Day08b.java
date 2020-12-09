import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day08b {

	public static void main(String[] args) {
		String fileName = "inputs/day08a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);
		
		ArrayList<String> copiedList = new ArrayList<String>();
		copiedList = (ArrayList<String>) list.clone();
		
		int modifiedIndex = -1;
		
		boolean looped;
		do {
			looped = exec(copiedList);
			
			if (looped) {
				//copiedList.clear();
				copiedList = (ArrayList<String>) list.clone();
				
				boolean found = false;
				int i = modifiedIndex + 1;
				while (!found && i < copiedList.size()) {
					String tmp[] = copiedList.get(i).split(" ");
					if (tmp[0].equals("jmp")) {
						copiedList.set(i, copiedList.get(i).replace("jmp", "nop"));
						modifiedIndex = i;
						found = true;
					} else if (tmp[0].equals("nop")) {
						copiedList.set(i, copiedList.get(i).replace("nop", "jmp"));
						modifiedIndex = i;
						found = true;
					}
					
					i++;
				}
			}
		} while (looped);
		
		
	}
	
	public static boolean exec(ArrayList<String> list) {
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
		
		return looped;
	}

}
