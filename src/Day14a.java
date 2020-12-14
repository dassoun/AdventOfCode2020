import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jco.utils.FileTransfom;

public class Day14a {

	public static void main(String[] args) {
		String fileName = "inputs/day14a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);
		
		HashMap<Long, Long> memory = new HashMap<Long, Long>();
		long sum = 0;
		long tmpNumber = 0;
		long memAddress = 0;
		String mask = "";
		for (String s : list) {
			if (s.substring(0, 4).equals("mask")) {
				mask = s.substring(7);
			} else {
				int pos = s.indexOf(" = ");
				if (pos > -1) {
					tmpNumber = Long.valueOf(s.substring(pos + 3));
//					System.out.println(tmpNumber);
				}
				
				String tmpBinary = Long.toBinaryString(tmpNumber);
				tmpBinary = "000000000000000000000000000000000000" + tmpBinary;
				tmpBinary = tmpBinary.substring(tmpBinary.length() - 36);
				
				String res = "";
				for (int i = 0; i < 36; i++) {
					if (mask.substring(i, i+1).equals("X")) {
						res += tmpBinary.substring(i, i+1);
					} else {
						res += mask.substring(i, i+1);
					}
				}
				
				tmpNumber = Long.parseLong(res, 2);
				
				Matcher matcher2 = Pattern.compile("\\[(.*?)\\]").matcher(s);
				if (matcher2.find()) {
					memAddress = Long.valueOf(matcher2.group(1));
				    
			    	memory.put(memAddress, tmpNumber);
				}

			}
		}
		
		for(Map.Entry<Long, Long> entry : memory.entrySet()) {
			Long key = entry.getKey();
			Long value = entry.getValue();

		    sum += value;
		}
		
		System.out.println(sum);
	}
}
