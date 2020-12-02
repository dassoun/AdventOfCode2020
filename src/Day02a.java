import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day02a {

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
		private int min;
		private int max;
		private String password;
		
		public Data() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Data(String s, int min, int max, String password) {
			super();
			this.s = s;
			this.min = min;
			this.max = max;
			this.password = password;
		}
		
		public Data(String s) {
			super();
			
			String tmp[] = s.split(": ");
			
			this.password = tmp[1];
			
			String tmp2[] = tmp[0].split(" ");
			
			this.s = tmp2[1];
			
			String tmp3[] = tmp2[0].split("-");
			
			this.min = Integer.valueOf(tmp3[0]);
			this.max = Integer.valueOf(tmp3[1]);
		}
		
		public boolean isValid() {
			int count = countOccurences(this.password, this.s.charAt(0), 0);
			
			if ((this.min <= count) && (count <= this.max)) {
				return true;
			}
			
			return false;
		}
		
		private int countOccurences(String someString, char searchedChar, int index) {
		    if (index >= someString.length()) {
		    	return 0;
		    }

		    int count = someString.charAt(index) == searchedChar ? 1 : 0;
		    return count + countOccurences(someString, searchedChar, index + 1);
		}
		
		public String toString() {
			return "min: " + this.min + ", max: " + this.max + ", s: " + this.s + ", password: " + this.password + ", valid: " + this.isValid();
		}
	}
}
