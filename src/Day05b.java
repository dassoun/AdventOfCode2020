import java.util.ArrayList;
import java.util.Collections;

import com.jco.utils.FileTransfom;

public class Day05b {

	public static void main(String[] args) {
		String fileName = "inputs/day05a.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransfom.fileToStringList(fileName);

		ArrayList<Seat> seatList = new ArrayList<Seat>();
		
		for (String s : list) {
			seatList.add(new Seat(s));

//			System.out.println(seat.row + " / " + seat.column);
		}
		
		Collections.sort(seatList);
		
		int previousSeat = 0;
		int i = 0;
		
		for (Seat s : seatList) {
			if (i == 0) {
				previousSeat = s.id;
			} else {
				if ((s.id - previousSeat) > 1) {
					System.out.println(s.id - 1);
				}
				
				previousSeat = s.id;
			}
			
//			System.out.println(s.id);
			
			i++;
		}
	}
	
	static class Seat implements Comparable<Seat> {
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

		@Override
		public int compareTo(Seat arg0) {
			
			return this.id - arg0.id;
		}
	}

}
