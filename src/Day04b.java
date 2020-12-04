import java.util.ArrayList;
import java.util.regex.Pattern;

import com.jco.utils.FileTransfom;

public class Day04b {

	public static void main(String[] args) {
		String fileName = "inputs/day04a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);

		ArrayList<Data> dataList = new ArrayList<Data>();
		
		int count = 0;
		
		String tmp = "";
		
		for (String s : list) {
			if (!s.equals("")) {
				tmp += s + " ";
			} else {
				Data data = new Data(tmp.trim());
				
				if (data.isValid()) {
					count++;
				}
				
				dataList.add(data);
				
				System.out.println(data.toString());
				
				tmp = "";
			}
		}
		
		System.out.println(count);
	}

	static class Data {
		private String ecl;
		private String pid;
		private String eyr;
		private String hcl;
		private String byr;
		private String iyr;
		private String cid;
		private String hgt;
		
		public Data() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Data(String ecl, String pid, String eyr, String hcl, String byr, String iyr, String cid, String hgt) {
			super();
			this.ecl = ecl;
			this.pid = pid;
			this.eyr = eyr;
			this.hcl = hcl;
			this.byr = byr;
			this.iyr = iyr;
			this.cid = cid;
			this.hgt = hgt;
		}

		public Data(String data) {
			super();
			data.replace("\n", " ");
			String[] parts = data.split(" ");
			
			for (String s : parts) {
				String[] fields = s.split(":");
				switch (fields[0]) {
					case "ecl":
						this.ecl = fields[1];
						break;
					case "pid":
						this.pid = fields[1];
						break;
					case "eyr":
						this.eyr = fields[1];
						break;
					case "hcl":
						this.hcl = fields[1];
						break;
					case "byr":
						this.byr = fields[1];
						break;
					case "iyr":
						this.iyr = fields[1];
						break;
					case "cid":
						this.cid = fields[1];
						break;
					case "hgt":
						this.hgt = fields[1];
						break;
					default:
						break;
				}
			}
		}
		
		private boolean isValid() {
			boolean res = true;
			
			if (this.ecl == null || this.pid == null || this.eyr == null || this.hcl == null
					|| this.byr == null || this.iyr == null || this.hgt == null) {
				
				return false;
			}
			
			// byr
			if (this.byr.length() != 4 || this.byr.compareTo("1920") < 0 || this.byr.compareTo("2002") > 0) {
				return false;
			}
			
			// iyr
			if (this.iyr.length() != 4 || this.iyr.compareTo("2010") < 0 || this.iyr.compareTo("2020") > 0) {
				return false;
			}
			
			// eyr
			if (this.eyr.length() != 4 || this.eyr.compareTo("2020") < 0 || this.eyr.compareTo("2030") > 0) {
				return false;
			}
			
			// hgt
			int in = this.hgt.indexOf("in");
			int cm = this.hgt.indexOf("cm");
			if (in > 0) {
				String[] tmp = this.hgt.split("in");
				int tmp2 = Integer.valueOf(tmp[0]);
				if (tmp2 < 59 || tmp2 > 76) {
					return false;
				}
			} else if (cm > 0) {
				String[] tmp = this.hgt.split("cm");
				int tmp2 = Integer.valueOf(tmp[0]);
				if (tmp2 < 150 || tmp2 > 193) {
					return false;
				}
			} else {
				return false;
			}
		
			// hcl
			if (!Pattern.matches("#[0-9a-f]{6}", this.hcl)) {
				return false;
			}
			
			// ecl
			if (!this.ecl.equals("amb") && !this.ecl.equals("blu") && !this.ecl.equals("brn") && !this.ecl.equals("gry")
					&& !this.ecl.equals("grn") && !this.ecl.equals("hzl") && !this.ecl.equals("oth")) {
				
				return false;
			}
			
			// pid
			if (!Pattern.matches("[0-9]{9}", this.pid)) {
				return false;
			}
			
			return res;
		}

		@Override
		public String toString() {
			return "Data [ecl=" + ecl + ", pid=" + pid + ", eyr=" + eyr + ", hcl=" + hcl + ", byr=" + byr + ", iyr="
					+ iyr + ", cid=" + cid + ", hgt=" + hgt + "]" + isValid();
		}
		
		
	}
}
