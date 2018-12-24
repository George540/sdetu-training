package opp;

public class MusicalNote {
	
	private int syllable;
	private int duration;
	
	public MusicalNote() {
		syllable = 1;
		duration = 1;
	}
	
	public MusicalNote(int syl, int dur) {
		if (dur < 1 || dur > 7) {
			syllable = 1;
		}
		else
			setSyllable(syl);
		
		if (dur <= 0)
			duration = 1;
		else
			setDuration(dur);
	}
	
	public void setSyllable(int syl) {
		syllable = syl;
	}
	
	public void setDuration(int dur) {
		duration = dur;
	}
	
	public int getSyllables() {
		return syllable;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public int shorten() {
		if (duration <= 1)
			return duration;
		else
			return duration--;
	}

	public String toString() {
		return (syllable + "-" + duration);
	}
	
	public boolean sameSyllable(MusicalNote m2) {
		return(syllable == m2.syllable);
	}
	
	public boolean equals(MusicalNote m2) {
		return((syllable == m2.syllable) && (duration == m2.duration));
	}
}
