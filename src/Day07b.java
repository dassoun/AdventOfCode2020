import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day07b {

	public static void main(String[] args) {
		String fileName = "inputs/day07a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);

		ArrayList<Bag> bagList = new ArrayList<Bag>();
		
		for (String s : list) {
			String[] tmp = s.split(" bags contain ");
			
			bagList.add(new Bag(tmp[0], tmp[1]));
		}
		
		for (Bag b : bagList) {	
			if (b.color.equals("shiny gold")) {
				System.out.println(b.countBagsIn(bagList));
			}
		}
	}

	static class Bag {
		private String color;
		private ArrayList<Content> contentList;
		
		public Bag() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Bag(String color, ArrayList<Content> contentList) {
			super();
			this.color = color;
			this.contentList = contentList;
		}

		public Bag(String color) {
			super();
			this.color = color;
			this.contentList = new ArrayList<Content>();
		}
		
		public Bag(String color, String data) {
			super();
			this.color = color;
			
			this.contentList = new ArrayList<Content>();
			
			if (!data.contentEquals("no other bags.")) {
				String[] tab = data.split(", ");
				for (String s : tab) {
					s = s.replace("bags", "bag");
					s = s.replace("bags.", "bag");
					s = s.replace("bag.", "bag");
					s = s.replace(" bag", "");
					
					String[] tmp = s.split(" ", 2);
					int quantity = Integer.valueOf(tmp[0]);
					String contentColor = tmp[1];
					
					Content content = new Content(contentColor, quantity);
					this.addContent(content);
				}
			}
			
		}
		
		private void addContent(Content content) {
			this.contentList.add(content);
		}
		
		private void addContent(String data) {
			
		}
		
		public boolean canCarry(String color, ArrayList<Bag> bagList) {
			boolean res = false;
			
			boolean found = false;
			
			
			if (contentList == null || contentList.size() == 0) {
				return false;
			}
			
			for (Content c : contentList) {
				if (c.color.equals(color)) {
					res = true;
					break;
				} else {
					int i = 0;
					while (i < bagList.size() && !found) {
						if (bagList.get(i).color.equals(c.color)) {
							
							found = bagList.get(i).canCarry(color, bagList);
							
							if (found) {
								break;
							}
						}
						
						i++;
					}
					
					if (found) {
						res = true;
						break;
					}
				}
			}
			
			return res;
		}
		
public int countBagsIn(ArrayList<Bag> bagList) {
	int count = 0;
	
	if (contentList == null || contentList.size() == 0) {
		return 0;
	}
	
	for (Content c : contentList) {
		for (Bag b : bagList) {
			if (b.color.equals(c.color)) {
				count += c.quantity + c.quantity * b.countBagsIn(bagList);
				break;
			}
		}
		
	}

	return count;
}
	}
	
	static class Content {
		private String color;
		private int quantity;
		
		public Content() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Content(String color, int quantity) {
			super();
			this.color = color;
			this.quantity = quantity;
		}
		
	}
}
