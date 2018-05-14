# PigLatinJava
This is a nit-picky take on a classic coding challenge: Make some code that translates a string into Pig Latin, and is capable of translating Pig Latin back into in the native language.
Because this is often an early excersize in one's programming career, the anti should be upped.  Therefore, this translator must:
- Be absolutely working.  This includes punctuation, capitalization, and all that other nonsense that is typically ignoored.
- utilize Test Driven Development (this challenge is coded in Java, so Junit will be used)

## How Pig Latin Works
Basically, the Pig Latin system used here works as follows:

- Words that start with a vowel (A, E, I, O, U) simply have "yay" appended to the end of the word.
     - Examples are:
          - "eat" → "eat-yay"
          - "omelet" → "omelet-yay"
          - "are" → "are-yay" 

- Words that start with a consonant have all consonant letters up to the first vowel moved to the end of the word (as opposed to just the first consonant letter), and "-ay" is appended.
     -('Y' is counted as a vowel in this context)
     - Examples are:
          - "pig" → "ig-pay"
          - "banana" → "anana-bay"
          - "trash" → "ash-tray"
          - "happy" → "appy-hay"
          - "duck" → "uck-day"
          - "glove" → "ove-glay"