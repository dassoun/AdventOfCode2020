import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day02b {

	public static void main(String[] args) {
		String fileName = "inputs/day02a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);
		
		int count = 0;
		for (String s : list) {
			Data data = new Data(s);
			
			System.out.println(data);
			
			if (data.isValid()) {
				count++;
			}
		}
		
		System.out.println(count);

	}

	static class Data {
		private String s; 
		private int pos1;
		private int pos2;
		private String password;
		
		public Data() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Data(String s, int pos1, int pos2, String password) {
			super();
			this.s = s;
			this.pos1 = pos1;
			this.pos2 = pos2;
			this.password = password;
		}
		
		public Data(String s) {
			super();
			
			String tmp[] = s.split(": ");
			
			this.password = tmp[1];
			
			String tmp2[] = tmp[0].split(" ");
			
			this.s = tmp2[1];
			
			String tmp3[] = tmp2[0].split("-");
			
			this.pos1 = Integer.valueOf(tmp3[0]);
			this.pos2 = Integer.valueOf(tmp3[1]);
		}
		
		public boolean isValid() {
			return password.charAt(pos1 - 1) == s.charAt(0) ^ password.charAt(pos2 - 1) == s.charAt(0);
		}
		
		private int countOccurences(String someString, char searchedChar, int index) {
		    if (index >= someString.length()) {
		    	return 0;
		    }

		    int count = someString.charAt(index) == searchedChar ? 1 : 0;
		    return count + countOccurences(someString, searchedChar, index + 1);
		}
		
		public String toString() {
			return "pos1: " + this.pos1 + ", pos2: " + this.pos2 + ", s: " + this.s + ", password: " + this.password + ", valid: " + this.isValid();
		}
	}
}
