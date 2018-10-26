
public class KeyWord {
	private String word; // the keyword/term found on Google
	private int score; // score determined by factors

	/**
	 * Sets up parameters of class For the simulation, factors will be chosen by a
	 * random generator
	 * 
	 * @param word
	 *            the word according to Web Crawler
	 * @param freq
	 *            the frequency that word has appeared on Google
	 * @param time
	 *            the time the web page containing the word has existed
	 * @param other
	 *            the other web pages that also have the word
	 * @param pay
	 *            the amount of money the owner paid Google to advertise the web
	 *            page
	 */
	public KeyWord(String word, int score) {
		this.word = word; 
		this.score = score;
		
	}

	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public int getScore() {
		return score; 
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void calculate(int f, int t, int o, int p) {
		score = (f + t + o + p) / 4;
	}
}