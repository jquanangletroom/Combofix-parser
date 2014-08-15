package com.succurri;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	private static final String DELIM1 = "If the download process does not begin automatically, please <a href='";
	private static final String DELIM2 = "'>click here";
	private static final String HARD_CODED_FILE_PATH = "C:\\ktemp\\CFDL.html";

	public static void main(String[] args) {
		String html = "";
		String url = "";
		File file = null;
		
		if (args != null && args.length == 1) {
			file = new File(args[0]);
		}// if

		try {
			BufferedReader br;
			if (args != null && args.length == 1) {
				br = new BufferedReader(new FileReader(file));
			} else {
				br = new BufferedReader(new FileReader(HARD_CODED_FILE_PATH));
			}// else
			while (br.ready()) {
				html += br.readLine();
			}// while
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // catch

		String[] tokens = html.split(DELIM1);
		tokens = tokens[1].split(DELIM2);

		url = tokens[0];

		System.out.println(url);
	}// main

}// class
