package document;

/** 
 * A class that represents a text document
 * @author UC San Diego Intermediate Programming MOOC team
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ShuyuDocument {

	private String text;
	
	/** Create a new document from the given text.
	 * Because this class is abstract, this is used only from subclasses.
	 * @param text The text of the document.
	 */
	protected ShuyuDocument(String text)
	{
		this.text = text;
	}
	
	/** Returns the tokens that match the regex pattern from the document 
	 * text string.
	 * @param pattern A regular expression string specifying the 
	 *   token pattern desired
	 * @return A List of tokens from the document text that match the regex 
	 *   pattern
	 */
	protected List<String> getTokens(String pattern)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(text);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		
		return tokens;
	}
	
	/** This is a helper function. You should write this and use it in your 
	 * BasicDocument class. 
	 * For reasons of efficiency you should not create Matcher or Pattern 
	 * objects inside this method. Just use a loop to loop through the 
	 * characters in the string and write your own logic for counting 
	 * syllables.
	 * 
	 * @param word  The word to count the syllables in
	 * @return The number of syllables in the given word, according to 
	 * this rule: Each contiguous sequence of one or more vowels is a syllable, 
	 *       with the following exception: a lone "e" at the end of a word 
	 *       is not considered a syllable unless the word has no other syllables. 
	 *       You should consider y a vowel.
	 */
	protected int countSyllables(String word) {
		int wordNumSyllables, sizeOfString;
		wordNumSyllables = 0;
		sizeOfString = word.toCharArray().length;
		String vowel = "aeiouy";
		for(int i=1; i<sizeOfString; i++) {
			if(vowel.indexOf(word.toLowerCase().charAt(i))>=0 && vowel.indexOf(word.toLowerCase().charAt(i-1))<0) {
				wordNumSyllables++;
			}
		}
		if(vowel.indexOf(word.toLowerCase().charAt(0))>=0) wordNumSyllables += 1;
		if(word.endsWith("e") && wordNumSyllables > 1 && vowel.indexOf(word.toLowerCase().charAt(sizeOfString-2))<0) wordNumSyllables -= 1;
	    return wordNumSyllables;
	}
	
	/** A method for testing
	 * @param doc The Document object to test
	 * @param syllables The expected number of syllables
	 * @param words The expected number of words
	 * @param sentences The expected number of sentences
	 * @return true if the test case passed.  False otherwise.
	 */
	public static boolean testCase(Document doc, int syllables, int words, int sentences)
	{
		System.out.println("Testing text: ");
		System.out.print(doc.getText() + "\n....");
		boolean passed = true;
		int syllFound = doc.getNumSyllables();
		int wordsFound = doc.getNumWords();
		int sentFound = doc.getNumSentences();
		if (syllFound != syllables) {
			System.out.println("\nIncorrect number of syllables.  Found " + syllFound 
					+ ", expected " + syllables);
			passed = false;
		}
		if (wordsFound != words) {
			System.out.println("\nIncorrect number of words.  Found " + wordsFound 
					+ ", expected " + words);
			passed = false;
		}
		if (sentFound != sentences) {
			System.out.println("\nIncorrect number of sentences.  Found " + sentFound 
					+ ", expected " + sentences);
			passed = false;
		}
		
		if (passed) {
			System.out.println("passed.\n");
		}
		else {
			System.out.println("FAILED.\n");
		}
		return passed;
	}
	
	
	/** Return the number of words in this document */
	public abstract int getNumWords();
	
	/** Return the number of sentences in this document */
	public abstract int getNumSentences();
	
	/** Return the number of syllables in this document */
	public abstract int getNumSyllables();
	
	/** Return the entire text of this document */
	public String getText() {
		return this.text;
	}
	
	
	/** return the Flesch readability score of this document */
	public double getFleschScore() {
		double fleschScore;
		Document doc = new BasicDocument(this.getText());
		if(doc.getNumSentences() == 0) {
			System.out.println("No sentence, couldn't figure out the FleschScore");
			fleschScore = 0;
		}
		else if(doc.getNumWords() == 0) {
			System.out.println("No word, couldn't figure out the FleschScore");
			fleschScore = 0;
		}
		else {
			fleschScore = 206.835 - (1.015*doc.getNumWords()/doc.getNumSentences()) - (84.6*doc.getNumSyllables()/doc.getNumWords());
		}
		return fleschScore;
	}
	
	
	
}
