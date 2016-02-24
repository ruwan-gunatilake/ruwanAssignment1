package kpmg.assessment.problem2;

/**
 * @author ruwan
 *
 */
public class HuffmanResult {
	private char symbol;
	private int frequency;
	private String huffmanCode;

	public HuffmanResult(char symbol, int frequency, String huffmanCode) {
		super();
		this.symbol = symbol;
		this.frequency = frequency;
		this.huffmanCode = huffmanCode;
	}
	
	public char getSymbol() {
		return symbol;
	}
	public int getFrequency() {
		return frequency;
	}
	public String getHuffmanCode() {
		return huffmanCode;
	}
}
