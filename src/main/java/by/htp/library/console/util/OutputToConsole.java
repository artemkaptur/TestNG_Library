package by.htp.library.console.util;

import java.util.List;

public final class OutputToConsole {

	private OutputToConsole() {

	}

	public static <T> void printList(List<T> list) {
		for (T item : list) {
			System.out.println(item); 
		}
	}

}
