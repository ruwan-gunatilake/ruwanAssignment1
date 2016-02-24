package kpmg.assessment.problem3a;

import junit.framework.Assert;
import kpmg.assessment.problem3a.ReverseWords;

import org.junit.Test;

/**
 * @author ruwan
 *
 */
public class ReverseWordsTest {
	
	@Test
	public void TestGeneralString() {
		ReverseWords reverseWords=new ReverseWords();
		String reversedText=reverseWords.reverseWords("This is a test");
		Assert.assertNotNull(reversedText);
		Assert.assertEquals("test a is This", reversedText);
	}

	@Test
	public void TestSpecialCharacters() {
		ReverseWords reverseWords=new ReverseWords();
		String reversedText=reverseWords.reverseWords("Opps! It is Sam's car. His rego number is ABC-97-DEF.");
		Assert.assertNotNull(reversedText);
		Assert.assertEquals("ABC-97-DEF. is number rego His car. Sam's is It Opps!", reversedText);

	}

	@Test
	public void TestEmptyString() {
		ReverseWords reverseWords=new ReverseWords();
		String reversedText=reverseWords.reverseWords("");
		Assert.assertNotNull(reversedText);
		Assert.assertEquals("", reversedText);
	}

	@Test
	public void TestNull() {
		ReverseWords reverseWords=new ReverseWords();
		String reversedText=reverseWords.reverseWords(null);
		Assert.assertNotNull(reversedText);
		Assert.assertEquals("", reversedText);
	}
}
