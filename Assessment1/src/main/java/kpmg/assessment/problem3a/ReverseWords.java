package kpmg.assessment.problem3a;

/**
 * @author ruwan
 * 
 */
public class ReverseWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		ReverseWords rw = new ReverseWords();
		System.out.println(rw.reverseWords("This is a test"));
	}

	public String reverseWords(String input) {
		if (input == null || "".equals(input)) {
			return "";
		}
		String wordsArr[] = input.split(" ");

		StringBuilder sb = new StringBuilder();// SpringBuffer can be used with little performance overhead if thread safety is a concern
		for (int i = wordsArr.length - 1; i >= 0; i--) {
			sb.append(wordsArr[i]).append(" ");
		}
		sb.setLength(sb.length() - 1);// removing trailing space
		return sb.toString();
	}

}
