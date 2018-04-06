package by.htp.library.console.util;

import java.util.Scanner;

public class InputFromConsole {
	
	private InputFromConsole() {
	}

	public static String scanInfo() {
		System.out.println("Type your string:");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
//		sc.close();
		return result;	
	}

}
