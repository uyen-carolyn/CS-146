/**
 * Keyword class used in the Simulator Simple class containing typical getter
 * and setter methods along with methods that may or may not be used
 */
public class Link {

	private String l; // name of URL
	private int f; // represents frequency (frequency factor)
	private int t; // represents time of existence (time factor)
	private int o; // represents amount websites that reference it (association factor)
	private int p; // represents amount of payment for more exposure (payment factor)

	private int score; // total sum of factors that will be used for sorting
	private int index = 0; // for possible debug use if needed

	private int rank = 1;

	/**
	 * Constructor for the Keyword class
	 * 
	 * @param l
	 *            the given name of the URL
	 * @param f
	 *            the given frequency score
	 * @param t
	 *            the given time score
	 * @param o
	 *            the given association score
	 * @param p
	 *            the given payment score
	 */
	public Link(String l, int f, int t, int o, int p) {
		this.l = l;
		this.f = f;
		this.t = t;
		this.o = o;
		this.p = p;

		score = f + t + o + p;
	}

	/**
	 * Gets the name of the Keyword type
	 * 
	 * @return name
	 */
	public String getL() {
		return l;
	}

	/**
	 * Sets the name as a different name if needed
	 * 
	 * @param theName
	 */
	public void setL(String theLink) {
		l = theLink;
	}

	/**
	 * Gets the frequency factor score
	 * 
	 * @return f
	 */
	public int getF() {
		return f;
	}

	/**
	 * Sets the frequency factor score
	 * 
	 * @param aF
	 *            the score for the factor
	 */
	public void setF(int aF) {
		f = aF;
	}

	/**
	 * Gets the time factor score
	 * 
	 * @return t
	 */
	public int getT() {
		return t;
	}

	/**
	 * Sets the time factor score
	 * 
	 * @param aT
	 *            the score for the factor
	 */
	public void setT(int aT) {
		t = aT;
	}

	/**
	 * Gets the other web pages association factor score
	 * 
	 * @return o
	 */
	public int getO() {
		return o;
	}

	/**
	 * Sets the association factor score
	 * 
	 * @param aO
	 *            the score for the factor
	 */
	public void setO(int aO) {
		o = aO;
	}

	/**
	 * Gets the amount paid for more exposure factor score
	 * 
	 * @return p
	 */
	public int getP() {
		return p;
	}

	/**
	 * Sets the payment factor score
	 * 
	 * @param aP
	 *            the score for the factor
	 */
	public void setP(int aP) {
		p = aP;
	}

	/**
	 * Gets the score of the Keyword type
	 * 
	 * @return score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Calculates the score given the factors added together
	 * 
	 * @param af
	 *            the frequency factor
	 * @param at
	 *            the time factor
	 * @param ao
	 *            the association factor
	 * @param ap
	 *            the payment factor
	 */
	public void calculateScore(int af, int at, int ao, int ap) {
		score = af + at + ao + ap;
	}

	/**
	 * Gets the index of the Link type
	 * 
	 * @return index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Sets the index
	 * 
	 * @param aIndex
	 *            the given index
	 */
	public void setIndex(int aIndex) {
		index = aIndex;
	}

	/**
	 * Gets the rank of the Link type
	 * 
	 * @return
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Sets the rank
	 * 
	 * @param r
	 *            the given rank
	 */
	public void setRank(int r) {
		rank = r;
	}
}