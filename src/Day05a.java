import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day05a {

	public static void main(String[] args) {
		String fileName = "inputs/day05a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);

		int max = 0;
		
		for (String s : list) {
			Seat seat = new Seat(s);
			
			if (seat.id > max) {
				max = seat.id;
			}
//			System.out.println(seat.row + " / " + seat.column);
		}
		
		System.out.println(max);
	}
	
	static class Seat {
		private int row;
		private int column;
		private int id;
		
		public Seat() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Seat(int row, int column) {
			super();
			this.row = row;
			this.column = column;
			this.id = (this.row * 8) + this.column;
		}
		
		public Seat(String data) {
			super();
			
			String strRow;
			String strColumn;
			
			strRow = data.substring(0, 7);
			strColumn = data.substring(7, 10);
			
			strRow = strRow.replace('F', '0');
			strRow = strRow.replace('B', '1');
			
			strColumn = strColumn.replace('L', '0');
			strColumn = strColumn.replace('R', '1');
			
			this.row = Integer.parseInt(strRow, 2);
			this.column = Integer.parseInt(strColumn, 2);
			
			this.id = (this.row * 8) + this.column;
		}
	}

}
