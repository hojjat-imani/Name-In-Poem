package com.hojjat.nameInPoem;

import android.util.Log;

public class PoemItem {
	String poem;
	String name;
	
	//type 1 : esm dar matne sher
	//type 2 : horuf avval sazande esm - shoru az mesrae aval
	//type 3 : horuf avval sazande esm - shoru az mesrae dovvom
	int type;
	String poet;
	String[] verses;
	int numberOfVerses;

	public PoemItem(String Poem, String name, int type, String poet,
			int numberOfVerses) {
		this.poem = Poem;
		this.name = name;
		verses = new String[numberOfVerses];
		verses = Poem.split(";");
		this.poet = poet;
		this.type = type;
		this.numberOfVerses = numberOfVerses;
	}

	public String getFirstSentence() {
		return verses[0];
	}

	public String getStyledPoem() {
		String styledPoem = "";
		for (String verse : verses) {
			styledPoem += verse + "\n";
		}
		styledPoem = styledPoem.substring(0, styledPoem.length() - 1);
		return styledPoem;
	}
	
	public String getVerse(int verseNumber){
		if(verseNumber > verses.length){
			Log.d("hojjat", "demanded verse num is larger than poem size!");
			return "";
		}
		return verses[verseNumber - 1];
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfSentences(int numberOfSentences) {
		this.numberOfVerses = numberOfSentences;
	}

	public void setPoem(String poem) {
		poem = poem;
	}

	public void setPoet(String poet) {
		poet = poet;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfVerses() {
		return numberOfVerses;
	}

	public String getPoem() {
		return poem;
	}

	public String getPoet() {
		return poet;
	}

	public int getType() {
		return type;
	}
	public int getNameLength(){
		return name.length();
	}
}