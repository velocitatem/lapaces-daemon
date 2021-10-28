package velo.ladealpha.fields.psychology.behaviour.prediction;

import velo.ladealpha.fields.psychology.personality.Profile;

// TODO: Auto-generated Javadoc
/**
 * The Class EmotionalRegression.
 */
public class EmotionalRegression {
	
	/** The profile. */
	private Profile profile;
	
	/**
	 * Instantiates a new emotional regression.
	 *
	 * @param profile the profile
	 */
	public EmotionalRegression(Profile profile) {
		this.profile = profile;
	}
	
	/**
	 * Floor.
	 *
	 * @param val the val
	 * @return the double
	 */
	private double floor(double val) {
		return val>0?val:-1;
	}
	
	// these are meer approximations of behavioural patterns
	
	/**
	 * Despair.
	 *
	 * @return the double
	 */
	public double despair() {		
		return floor(profile.getcontextual_struggle() - profile.getcontextual_meaning());
	}
	
	/**
	 * External disappointment.
	 *
	 * @return the double
	 */
	public double external_disappointment() {
		return floor(profile.getExpectations() - profile.getReality());
	}
	
	/**
	 * Jelousy.
	 *
	 * @return the double
	 */
	public double jelousy() {
		return floor(profile.getPride() / profile.getKindness());
	}
	
	/**
	 * Anxiety.
	 *
	 * @return the double
	 */
	public double anxiety() {
		return floor((profile.getcontextual_struggle() + profile.getResponsibility() + profile.getExternal_disappointment()) / 2.3);
	}
	
	
}
