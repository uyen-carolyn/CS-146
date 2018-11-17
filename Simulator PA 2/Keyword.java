/**
 * Keyword class used in the Simulator Simple class containing typical getter
 * and setter methods along with methods that may or may not be used
 */
public class Keyword {

	private String name; // name of URL in our case
	private int f; // represents frequency (frequency factor)
	private int t; // represents time of existence (time factor)
	private int o; // represents amount websites that reference it (association factor)
	private int p; // represents amount of payment for more exposure (payment factor)

	private int score; // total sum of factors that will be used for sorting
	private int index = 0; // for possible debug use if needed

	/**
	 * Constructor for the Keyword class
	 * 
	 * @param name
	 * @param f
	 * @param t
	 * @param o
	 * @param p
	 */
	public Keyword(String name, int f, int t, int o, int p) {
		this.name = name;
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
	public String getName() {
		return name;
	}

	/**
	 * Sets the name as a different name if needed
	 * 
	 * @param theName
	 */
	public void setName(String theName) {
		name = theName;
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
	 * Gets the index of the Keyword type
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
}