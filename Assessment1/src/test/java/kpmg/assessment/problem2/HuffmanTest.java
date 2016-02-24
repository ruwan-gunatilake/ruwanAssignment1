package kpmg.assessment.problem2;

import java.util.ArrayList;

import junit.framework.Assert;
import kpmg.assessment.problem2.Huffman;
import kpmg.assessment.problem2.HuffmanResult;

import org.junit.Test;

/**
 * @author ruwan
 *
 */
public class HuffmanTest {

	@Test
	public void testHuffmanTest1() {
		String str = "aaaaaabbbbcccdd";
		Huffman huffman = new Huffman();
		ArrayList<HuffmanResult> huffmanResultList = huffman.getHuffmanCodes(str);
		for (HuffmanResult result : huffmanResultList) {
			switch (result.getSymbol()) {
			case 'a':
				Assert.assertEquals("0", result.getHuffmanCode());
				break;
			case 'b':
				Assert.assertEquals("10", result.getHuffmanCode());
				break;
			case 'c':
				Assert.assertEquals("111", result.getHuffmanCode());
				break;
			case 'd':
				Assert.assertEquals("110", result.getHuffmanCode());
				break;
			}
		}

	}
	
	@Test
	public void testHuffmanTest2() {
		String str = "ppppppaaabbc";
		Huffman huffman = new Huffman();
		ArrayList<HuffmanResult> huffmanResultList = huffman.getHuffmanCodes(str);
		for (HuffmanResult result : huffmanResultList) {
			switch (result.getSymbol()) {
			case 'p':
				Assert.assertEquals("0", result.getHuffmanCode());
				break;
			case 'a':
				Assert.assertEquals("10", result.getHuffmanCode());
				break;
			case 'b':
				Assert.assertEquals("111", result.getHuffmanCode());
				break;
			case 'c':
				Assert.assertEquals("110", result.getHuffmanCode());
				break;
			}
		}

	}

}