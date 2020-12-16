import java.util.ArrayList;
import java.util.Arrays;

import com.jco.utils.FileTransfom;

public class Day16a {

	static final int STEP_RULES = 0;
	static final int STEP_MY_TICKET = 1;
	static final int STEP_OTHER_TICKETS = 2;
	
	public static void main(String[] args) {
		String fileName = "inputs/day16a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);
		
		ArrayList<Rule> ruleList = new ArrayList<Rule>();
		MutedTicket myTicket = new MutedTicket();
		ArrayList<MutedTicket> otherTicketList = new ArrayList<MutedTicket>();
		
		
		int step = 0;
		for (String s : list) {
			if (s.contentEquals("")) {
				step++;	
			} else {
				switch (step) {
					case STEP_RULES:
						ruleList.add(new Rule(s));
						break;
					case STEP_MY_TICKET:
						if (s.indexOf(",") > -1) {
							myTicket = new MutedTicket(s);
						}
						break;
					case STEP_OTHER_TICKETS:
						if (s.indexOf(",") > -1) {
							otherTicketList.add(new MutedTicket(s));
						}
						break;
				}
			}
		}
		
//		for (MutedTicket mt : otherTicketList) {
//			System.out.println(mt.matchRuleList(ruleList));
//		}
		
		int sum = 0;
		for (MutedTicket mt : otherTicketList) {
			sum += mt.outOfRulesSum(ruleList);
		}
		
		System.out.println(sum);
	}
	
	public static class Rule {
		private String name;
		private int min1;
		private int max1;
		private int min2;
		private int max2;
		
		public Rule() {
			super();
		}

		public Rule(String name, int min1, int max1, int min2, int max2) {
			super();
			this.name = name;
			this.min1 = min1;
			this.max1 = max1;
			this.min2 = min2;
			this.max2 = max2;
		}

		public Rule(String data) {
			super();
			String[] tmp = data.split(": ");
			
			this.name = tmp[0];
			
			String[] tmp2 = tmp[1].split(" or ");
			String[] tmp3 = tmp2[0].split("-");
			
			this.min1 = Integer.valueOf(tmp3[0]);
			this.max1 = Integer.valueOf(tmp3[1]);
			
			tmp3 = tmp2[1].split("-");
			
			this.min2 = Integer.valueOf(tmp3[0]);
			this.max2 = Integer.valueOf(tmp3[1]);
		}
		
		
	}

	public static class MutedTicket {
		private int[] field;

		public MutedTicket() {
			super();
		}

		public MutedTicket(int[] field) {
			super();
			this.field = field;
		}
		
		public MutedTicket(String s) {
			super();
			this.field = Arrays.stream(s.split(","))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		
		public boolean matchRuleList(ArrayList<Rule> ruleList) {
			boolean res = false;
			
			int i = 0;
			boolean found = true;
			while (i < field.length && found) {
				res = false;
				
				for (int j = 0; j < ruleList.size(); j++) {
					if ((field[i] >= ruleList.get(j).min1 && field[i] <= ruleList.get(j).max1) || (field[i] >= ruleList.get(j).min2 && field[i] <= ruleList.get(j).max2)) {
						res = true;
					}
				}
				
				found = res;
				
				i++;
			}
			
			return res;
		}
		
		public int outOfRulesSum(ArrayList<Rule> ruleList) {
			int sum = 0;
			boolean found = false;
			int i = 0;
			
			while (i < field.length) {
				found = false;
				
				for (int j = 0; j < ruleList.size(); j++) {
					if ((field[i] >= ruleList.get(j).min1 && field[i] <= ruleList.get(j).max1) || (field[i] >= ruleList.get(j).min2 && field[i] <= ruleList.get(j).max2)) {
						found = true;
					}
				}
				
				if (!found) {
					sum += field[i];
				}
				
				i++;
			}
			
			return sum;
		}
	}
}
