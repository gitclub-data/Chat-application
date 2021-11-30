package pandey.application.chat.window;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class test {
	public static void main(String args[]) {
		ArrayList arr=new ArrayList();
		Scanner scan=new Scanner(System.in);
		String[] rowcol=scan.nextLine().split(" ");
		int row=Integer.parseInt(rowcol[0]);
		int col=Integer.parseInt(rowcol[1]);
		for(int i=0;i<row;i++) {
			arr.add(Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
		}
		System.out.println(Arrays.deepToString(arr.toArray()));
		
	}
}
