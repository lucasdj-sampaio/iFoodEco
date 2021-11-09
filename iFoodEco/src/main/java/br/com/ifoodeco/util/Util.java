package br.com.ifoodeco.util;

public class Util {

	public static String replaceChar(String toReplace) {
		return toReplace
				.replace("(","")
				.replace(")", "")
				.replace(".", "")
				.replace("!", "")
				.replace("@", "")
				.replace("#", "")
				.replace("$", "")
				.replace("%", "")
				.replace("-", "")
				.replace("_", "")
				.replace(" ", "")
				.replace("/", "")
				.replace(",", "")
				.replace("\\", "")
				.trim();
	}
	
}