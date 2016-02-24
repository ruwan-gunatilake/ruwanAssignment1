package kpmg.assessment.problem3b;

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
		char[] input = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 't',
				'e', 's', 't' };
		rw.reverseWords(input);
		System.out.println(new String(input));
	}

	public void reverseWords(char[] input) {
		if (input == null) {
			return;
		}
		reverseArray(input);
		findWordsAndReverse(input);
	}
	
	private void reverseArray(char[] input){
		int leftIndex = 0;
		int rightIndex = input.length - 1;
		while (rightIndex > leftIndex) {
			swap(input, leftIndex, rightIndex);
			leftIndex++;
			rightIndex--;
		}		
	}
	
	private void findWordsAndReverse(char[] input){
		int wordStartIndex = 0;
		int wordEndIndex = 0;
		for (char c : input) {
			if (c == ' ') {
				reverseWord(input, wordStartIndex, wordEndIndex - 1);
				wordStartIndex = ++wordEndIndex;
			} else if (wordEndIndex == input.length - 1) {
				reverseWord(input, wordStartIndex, wordEndIndex);
			} else {
				wordEndIndex++;
			}
		}
	}

	private void reverseWord(char[] input, int leftIndex, int rightIndex) {
		while (rightIndex > leftIndex) {
			swap(input, leftIndex, rightIndex);
			leftIndex++;
			rightIndex--;
		}
	}

	private void swap(char[] input, int leftIndex, int rightIndex) {
		char temp = input[leftIndex];
		input[leftIndex] = input[rightIndex];
		input[rightIndex] = temp;
	}

}
