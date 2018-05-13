package englishToPigTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import englishToPig.Translator;

public class TranslatorTest {
	
	@Test
	public void translateSentanceTest() {
		Translator translator = new Translator();
		String result1 = translator.translateSentence("This is a test Sentence.");
		String result2 = translator.translateSentence("And now, for my first trick, I shall perform an act that has never been seen before!  Witness, Terry's Turnaround!");
		assertEquals("Is-thay is-yay a-yay est-tay Entence-say.", result1);
		assertEquals("And-yay ow-nay, or-fay y-may irst-fay ick-tray, I-yay all-shay erform-pay an-yay act-yay at-thay as-hay ever-nay een-bay een-say efore-bay!  Itness-way, Erry's-tay Urnaround-tay!", result2);
	}
	
	@Test
	public void translateWordTest() {
		Translator translator = new Translator();
		String result1 = translator.translateWord("test");
		String result2 = translator.translateWord("strength");
		assertEquals("est-tay", result1);
		assertEquals("ength-stray", result2);
	}
	
	@Test
	public void findFirstVowelTest() {
		Translator translator = new Translator();
		int result1 = translator.findFirstVowel("Strength");
		int result2 = translator.findFirstVowel("are");
		int result3 = translator.findFirstVowel("Strngth");
		assertEquals(3, result1);
		assertEquals(0, result2);
		assertEquals(-1, result3);
	}

}
