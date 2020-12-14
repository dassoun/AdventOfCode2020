import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jco.utils.FileTransfom;
import com.jco.utils.StringUtils;

public class Day14b {

	public static void main(String[] args) {
		String fileName = "inputs/day14a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);
		
		HashMap<Long, Long> memory = new HashMap<Long, Long>();
		long sum = 0;
		long tmpNumber = 0;
		long memAddress = 0;
		String mask = "";
		ArrayList<String> addressList = new ArrayList<String>();
		ArrayList<String> binaryList = new ArrayList<String>();
		
		String tmpMask = "";
		
		for (String s : list) {
			if (s.substring(0, 4).equals("mask")) {
				
				mask = s.substring(7);
				int xCount = 0;
				for (int i = 0; i < 36; i++) {
					if (mask.substring(i, i+1).equals("X")) {
						xCount++;
					}
				}
				
				binaryList = getBinaryList(xCount);
				
				
				int pos = s.indexOf(" = ");
				if (pos > -1) {
					tmpMask = s.substring(pos + 3);
				}
				
			} else {
				
				int pos = s.indexOf(" = ");
				if (pos > -1) {
					tmpNumber = Long.valueOf(s.substring(pos + 3));
				}
				
				Matcher matcher2 = Pattern.compile("\\[(.*?)\\]").matcher(s);
				if (matcher2.find()) {
					memAddress = Long.valueOf(matcher2.group(1));
				}
				
				String tmpBinary = Long.toBinaryString(memAddress);
				tmpBinary = "000000000000000000000000000000000000" + tmpBinary;
				tmpBinary = tmpBinary.substring(tmpBinary.length() - 36);
				
				String res = "";
				for (int i = 0; i < 36; i++) {
					if (tmpMask.substring(i, i + 1).equals("1")) {
						res += "1";
					} else if (tmpMask.substring(i, i + 1).equals("0")) {
						res += tmpBinary.substring(i, i + 1);
					} else {
						res += "X";
					}
				}
				
				addressList.clear();
				for (String b : binaryList) {
					int charNb = 0;

					String address = "";
					for (int i = 0; i < 36; i++) {
						if (res.substring(i, i + 1).equals("X")) {
							address += b.charAt(charNb);
							charNb++;
						} else {
							address += res.charAt(i);
						}
					}
					
					addressList.add(address);
				}
				
				
				for (String a : addressList) {
					memAddress = Long.parseLong(a, 2);
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
	
	
	
	public static ArrayList<String> getBinaryList(long nb) {
		ArrayList<String> binaryList = new ArrayList<String>();
		
		long nbMax = (long) Math.pow(2, nb);
		int tmpZeroLength = Long.toBinaryString(nbMax - 1).length();
		
		for (long l = 0; l < nbMax; l++) {
			String tmpBinary = Long.toBinaryString(l);
			tmpBinary = "000000000000000000000000000000000000" + tmpBinary;
			tmpBinary = tmpBinary.substring(tmpBinary.length() - tmpZeroLength);
			binaryList.add(tmpBinary);
		}
		
		
		return binaryList;
	}
}
