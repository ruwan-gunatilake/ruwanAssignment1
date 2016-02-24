package kpmg.assessment.problem1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ruwan
 *
 */
public class TelephoneNumbers {

	private static final String REGEX_OR = "|";
	private static final String WORDS_FILE = "words.txt";

	public static void main(String args[]) {
		TelephoneNumbers tpn = new TelephoneNumbers();
		String filePath = tpn.getWordsFilePath();

		if (filePath == null) {
			System.err.println("File does not exist or path error!");
			return;
		}

		ArrayList<String> matchingWords = tpn.getMatchingWords("0123456789", filePath);
		for (String word : matchingWords) {
			System.out.println(word);
		}
	}

	public ArrayList<String> getMatchingWords(String phoneNumber, String filePath) {
		ArrayList<String> matchingWords = new ArrayList<String>();
		if (validatePhoneNumber(phoneNumber)) {
			try {
				String matchingRegex = getMatchingRegex(phoneNumber);
				System.out.println("matchingRegex : " + matchingRegex);
				Pattern pattern = Pattern.compile(matchingRegex, Pattern.CASE_INSENSITIVE);

				Matcher matcher = pattern.matcher("");

				FileReader fileReader = new FileReader(filePath);
				try (BufferedReader br = new BufferedReader(fileReader)) {
					String line;
					while ((line = br.readLine()) != null) {
						matcher.reset(line); // reset the input
						if (matcher.find()) {
							matchingWords.add(line.trim());
						}
					}
				}
			} catch (FileNotFoundException e) {
				System.err.println(WORDS_FILE + " does not exist! - " + e.getMessage());
			} catch (IOException e) {
				System.err.println(WORDS_FILE + " access error! - " + e.getMessage());
			}
		}
		return matchingWords;
	}

	private String getMatchingRegex(String phoneNumber) {

		Set<String> matchingLetters = new HashSet<String>();// HashSet is used
															// to avoid
															// duplicates
		for (int i = 0; i < phoneNumber.length(); i++) {
			String letters = map.get(phoneNumber.charAt(i));
			if (letters == null) {
				continue;
			}
			for (int j = 0; j < letters.length(); j++) {
				matchingLetters.add(String.valueOf(letters.charAt(j)));
			}
		}

		StringBuilder regex = new StringBuilder();
		for (String letter : matchingLetters) {
			regex.append(letter).append(REGEX_OR);
		}

		if (regex.length() > 0) {
			regex.setLength(regex.length() - 1);// removing trailing REGEX_OR
			return "^[" + regex.toString() + "](.)*$";
		}
		return null;
	}

	private String getWordsFilePath() {
		try {
			URL fileURL = this.getClass().getResource(WORDS_FILE);
			if (fileURL == null) {
				return null;
			}
			File file = new File(this.getClass().getResource(WORDS_FILE).toURI());
			if (file.exists()) {
				return file.getPath();
			} else {
				return null;
			}
		} catch (URISyntaxException e) {
			System.err.println("File path error! - " + e.getMessage());
			return null;
		}

	}

	private boolean validatePhoneNumber(String phoneNumber) {
		Pattern digitPattern = Pattern.compile("\\d{10}");// Pattern for 10
															// digits
		if (!digitPattern.matcher(phoneNumber).matches()) {
			System.err.println("Incorrect phone number! Only numbers are allowed and length must be 10.");
			return false;
		}
		return true;
	}

	private static final HashMap<Character, String> map = new HashMap<Character, String>() {
		private static final long serialVersionUID = -609889241542870519L;
		{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}
	};

}