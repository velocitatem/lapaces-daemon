package velo.ladealpha.fields.psychology.behaviour.prediction;

import velo.ladealpha.fields.psychology.personality.Profile;

public class EmotionalRegression {
	private Profile profile;
	public EmotionalRegression(Profile profile) {
		this.profile = profile;
	}
	private double floor(double val) {
		return val>0?val:-1;
	}
	
	// these are meer approximations of behavioural patterns
	
	public double despair() {		
		return floor(profile.getcontextual_struggle() - profile.getcontextual_meaning());
	}
	public double external_disappointment() {
		return floor(profile.getExpectations() - profile.getReality());
	}
	public double jelousy() {
		return floor(profile.getPride() / profile.getKindness());
	}
	public double anxiety() {
		return floor((profile.getcontextual_struggle() + profile.getResponsibility() + profile.getExternal_disappointment()) / 2.3);
	}
	
	
}
