package kpmg.assessment.problem3b;

import junit.framework.Assert;
import kpmg.assessment.problem3b.ReverseWords;

import org.junit.Test;

/**
 * @author ruwan
 *
 */
public class ReverseWordsTest {

	@Test
	public void TestGeneralString() {
		ReverseWords reverseWords = new ReverseWords();
		char[] input = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 't',
				'e', 's', 't' };
		reverseWords.reverseWords(input);
		Assert.assertNotNull(String.valueOf(input));
		Assert.assertEquals("test a is This", String.valueOf(input));
	}

	@Test
	public void TestSpecialCharacters() {
		ReverseWords reverseWords = new ReverseWords();
		char[] input = { 'O', 'p', 'p', 's', '!', ' ', 'I', 't', ' ', 'i', 's',
				' ', 'S', 'a', 'm', '\'', 's', ' ', 'c', 'a', 'r', '.', ' ',
				'H', 'i', 's', ' ', 'r', 'e', 'g', 'o', ' ', 'n', 'u', 'm',
				'b', 'e', 'r', ' ', 'i', 's', ' ', 'A', 'B', 'C', '-', '9',
				'7', '-', 'D', 'E', 'F', '.' };
		reverseWords.reverseWords(input);
		Assert.assertNotNull(String.valueOf(input));
		Assert.assertEquals(
				"ABC-97-DEF. is number rego His car. Sam's is It Opps!",
				String.valueOf(input));

	}

	@Test
	public void TestEmptyString() {
		ReverseWords reverseWords = new ReverseWords();
		char[] input = {};
		reverseWords.reverseWords(input);
		Assert.assertNotNull(String.valueOf(input));
		Assert.assertEquals("", String.valueOf(input));
	}

}
