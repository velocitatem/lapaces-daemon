package velo.ladealpha.fields.psychology.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.psychology.behaviour.prediction.EmotionalRegression;
import velo.ladaalpha.fields.psychology.personality.Profile;

class emotinalRegressionTest {

	@Test
	void test() {
		Profile profile = new Profile();
		profile.setcontextual_struggle(0.7);
		profile.setResponsibility(0.8);
		profile.setExternal_disappointment(0.6);		
		assertEquals(Math.round(10*new EmotionalRegression(profile).anxiety()), 9);
	}

}
