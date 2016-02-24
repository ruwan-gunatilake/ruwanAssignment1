package kpmg.assessment.problem1;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import junit.framework.Assert;
import kpmg.assessment.problem1.TelephoneNumbers;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ruwan
 *
 */
public class TelephoneNumbersTest {

	private String filePath = null;

	@Before
	public void init() {
		try {
			URL fileURL = this.getClass().getResource("words.txt");
			if (fileURL != null) {
				File file = new File(fileURL.toURI());
				filePath=file.getPath();
			}
		} catch (URISyntaxException e) {
			System.err.println("File path error! - " + e.getMessage());
		}
	}

	@Test
	public void TestCorrectPhoneNumber() {

		Assert.assertNotNull(filePath);
		TelephoneNumbers  tpn = new TelephoneNumbers();
		ArrayList<String> matchingWords = tpn.getMatchingWords("0123333333", filePath);
		for(String c:matchingWords) {
			System.out.println(c);
		}
		Assert.assertTrue(matchingWords.contains("azymous"));//last word starting with a
		Assert.assertTrue(matchingWords.contains("bz"));//last word starting with b
		Assert.assertTrue(matchingWords.contains("czigany"));//last word starting with c
		Assert.assertTrue(matchingWords.contains("dzo"));//last word starting with d
		Assert.assertTrue(matchingWords.contains("ezra"));//last word starting with e
		Assert.assertTrue(matchingWords.contains("fz"));//last word starting with f
		Assert.assertFalse(matchingWords.contains("g"));//first word starting with g
		Assert.assertFalse(matchingWords.contains("gyving"));//last word starting with g
	}
}