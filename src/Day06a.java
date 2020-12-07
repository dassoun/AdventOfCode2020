import java.util.ArrayList;
import java.util.HashMap;

import com.jco.utils.FileTransfom;

public class Day06a {

	public static void main(String[] args) {
		String fileName = "inputs/day06a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);
		
		GroupAnswers ga = new GroupAnswers();
		
		int count = 0;
		
		for (String s : list) {
			if (!s.equals("")) {
				ga.addData(s);
			} else {
				count += ga.getNbAnswerWithOneYes();
				ga = new GroupAnswers();
			}
		}
		
		System.out.println(count);
	}

	static class GroupAnswers {
		private ArrayList<Cdf> dataList;

		public GroupAnswers() {
			super();
			// TODO Auto-generated constructor stub
			
			this.dataList = new ArrayList<Cdf>();
		}

		public GroupAnswers(ArrayList<Cdf> dataList) {
			super();
			this.dataList = dataList;
		}
		
		public void addData(String data) {
			Cdf responses = new Cdf(data);
			
			this.dataList.add(responses);
		}
		
		public int getNbAnswerWithOneYes() {
			int res = 0;
			
			Cdf answerCount = new Cdf();
			
			for (Cdf cdf : this.dataList) {
				for (int i = 0; i < 26; i++) {
					if (cdf.responses.get((char)(97 + i)) == true) {
						answerCount.responses.replace((char)(97 + i), true);
					}
				}
			}
			
			for (int i = 0; i < 26; i++) {
				if (answerCount.responses.get((char)(97 + i)) == true) {
					res++;
				}
			}
			
			return res;
		}
	}
	
	// customs declaration forms
	static class Cdf {
		private HashMap<Character, Boolean> responses;

		public Cdf() {
			super();
			// TODO Auto-generated constructor stub
			
			this.responses = new HashMap<Character, Boolean>();
			
			for (int i = 0; i < 26; i++) {
				this.responses.put((char)(97 + i), false);
			}
		}

		public Cdf(HashMap<Character, Boolean> responses) {
			super();
			this.responses = responses;
		}

		public Cdf(String response) {
			super();
			
			this.responses = new HashMap<Character, Boolean>();
			
			for (int i = 0; i < 26; i++) {
				this.responses.put((char)(97 + i), false);
			}
			
			for (int i = 0; i < response.length(); i++) {
				char key = response.charAt(i);
				
				Boolean res = this.responses.get(key);
				
				if (res != null) {
					this.responses.replace(key, true);
				} else {
					this.responses.put(key, true);
				}
			}
		}
		
		
	}
}
