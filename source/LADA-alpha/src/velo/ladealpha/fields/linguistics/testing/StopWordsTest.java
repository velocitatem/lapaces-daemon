package velo.ladealpha.fields.linguistics.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.linguistics.LinguisticParser;

class StopWordsTest {

	@Test
	void test() {
		String body = "Where these stops words belong to English, French, German or other normally they include prepositions, particles, interjections, unions, adverbs, pronouns, introductory words, numbers from 0 to 9 (unambiguous), other frequently used official, independent parts of speech, symbols, punctuation. Relatively recently, this list was supplemented by such commonly used on the Internet sequences of symbols as www, com, http, etc.";
		System.out.println(LinguisticParser.removeStopWords(body));
	}

}
