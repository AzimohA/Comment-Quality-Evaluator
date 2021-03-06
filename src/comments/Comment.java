package comments;
import edu.stanford.nlp.simple.*;

/** responsible for storing...*/
public class Comment {
	private String comment;
	private boolean filtered;
	private int wordCount = 0;
	private Document doc;
	/** @param comment A string representation of the comment */
	public Comment(String comment) {
		this(comment, false);
	}
	/** 
	 * @param comment A string representation of the comment
	 * @param filtered A value representing if the comment is filtered or not
	 */
	public Comment(String comment, boolean filtered) {
		this.comment = comment;
		this.filtered = filtered;
	}
	/** Removes parts of the comment syntax so it complies better with natural language */
	public void filter() {
		StringBuilder stb = new StringBuilder();
		char[] rmString = comment.toCharArray();
		
		for(int i=0; i<comment.length(); i++) {
			if(rmString[i] == '*'||rmString[i] == '/') {
				
			}else {
				  stb.append(rmString[i]);
			}
		}
		comment = stb.toString();
		filtered = true;
		doc = new Document(comment);
		for(Sentence sent : doc.sentences()) {
			for(String word : sent.words()) {
				if(word!="." && word!= "," && word!=";" && word!=":") {
					wordCount++;
				}
			}
		}
	}
	public int getLength() {
		return wordCount;
		
	}
	
	/** @return The string representation of the comment */
	public String getComment() {
		return comment;
	}
	/** @return A value representing if the comment is filtered or not */
	public boolean getFiltered() {
		return filtered;
	}
}
