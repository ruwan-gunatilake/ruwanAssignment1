package kpmg.assessment.problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;


/**
 * @author ruwan
 *
 */
public class Huffman {


	public static void main(String[] args) {
		Huffman huffman = new Huffman();
		String str = "aaaaaabbbbcccdd";
		ArrayList<HuffmanResult> huffmanResultList =huffman.getHuffmanCodes(str);
		huffman.printCodes(huffmanResultList);
	}
	
	public ArrayList<HuffmanResult> getHuffmanCodes(String input){
		ArrayList<HuffmanResult> huffmanResultList =new ArrayList<HuffmanResult>();
		Map<Character, Integer> map = getFeqMap(input);

		Iterator<Entry<Character, Integer>> iterator = map.entrySet().iterator();
		char[] chars = new char[map.size()];
		int[] fequencies = new int[map.size()];
		int i = 0;
		while (iterator.hasNext()) {
			Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) iterator.next();
			chars[i] = entry.getKey();
			fequencies[i] = entry.getValue();
			i++;
		}

		// create tree
		HuffmanTree tree = createTree(fequencies, chars);
		pickCodes(tree, new StringBuffer(),huffmanResultList);
		return huffmanResultList;
	}
	
	public void printCodes(ArrayList<HuffmanResult> huffmanResultList){
		System.out.println("CHARACTER\tFREQUENCY\tHUFFMAN CODE");
		for(HuffmanResult row: huffmanResultList){
			System.out.println(row.getSymbol() + "\t\t" + row.getFrequency() + "\t\t" + row.getHuffmanCode());
		}
		
	}

	
	private HuffmanTree createTree(int[] charFreqs, char[] chars) {
		PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
		// initially, we have a forest of leaves
		// one for each non-empty character
		for (int i = 0; i < charFreqs.length; i++)
			if (charFreqs[i] > 0)
				trees.offer(new HuffmanLeaf(charFreqs[i], chars[i]));

		assert trees.size() > 0;
		// loop until there is only one tree left
		while (trees.size() > 1) {
			// two trees with least frequency
			HuffmanTree a = trees.poll();
			HuffmanTree b = trees.poll();

			// put into new node and re-insert into queue
			trees.offer(new HuffmanNode(a, b));
		}
		return trees.poll();
	}

	private void pickCodes(HuffmanTree tree, StringBuffer prefix, ArrayList<HuffmanResult> huffmanResultList) {
		assert tree != null;
		if (tree instanceof HuffmanLeaf) {
			HuffmanLeaf leaf = (HuffmanLeaf) tree;
			huffmanResultList.add(new HuffmanResult(leaf.value, leaf.frequency, prefix.toString()));

		} else if (tree instanceof HuffmanNode) {
			HuffmanNode node = (HuffmanNode) tree;

			// left traversal
			prefix.append('0');
			pickCodes(node.left, prefix, huffmanResultList);
			prefix.deleteCharAt(prefix.length() - 1);

			// right traversal
			prefix.append('1');
			pickCodes(node.right, prefix, huffmanResultList);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}
	

	private Map<Character, Integer> getFeqMap(String input) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		if (input == null || "".equals(input))
			return map;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}
}