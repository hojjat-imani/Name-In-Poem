package com.hojjat.nameInPoem.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

public class StringUtil {

	private static final String FONT_PATH_PREFIX = "fonts/";
	public static final String FONT_NAZANIN_BOLD = "b_nazanin_bold.ttf";
	public static final String FONT_AFSANEH = "a_afsaneh.ttf";
	public static final String FONT_SANS = "a_iranian_sans.ttf";
	public static final String FONT_MASHIN_TAHRIR = "a_mashin_tahrir.ttf";
	public static final String FONT_NASKH = "a_naskh_tahrir.ttf";
	public static final String FONT_NEGAR = "a_negar.ttf";
	public static final String FONT_FANTECY = "fantecy.ttf";
	public static final String FONT_DAST_NEVESHTE = "b_kamran_bold.ttf";
	public static final String FONT_KOODAK = "b_koodak.ttf";
	public static final String FONT_SETAREH = "b_setareh_bold.ttf";
	public static final String FONT_DROID_ARABIK = "droid_arabic_naskh.ttf";
	public static final String FONT_URDU = "urdu.ttf";
	public static final String FONT_IRAN_NASTALIQ = "Iran_nastaliq.ttf";

	private static Typeface nazanin, afsaneh, sans, mashinTahrir, naskh, negar,
			fantecy, dastNeveshte, koodak, serareh, droid, urdu, iranNastaliq;

	
	public static final float APP_DEFAULT_FONT_SIZE_SMALL = 18;
	public static final float APP_DEFAULT_FONT_SIZE_MEDIUM = 20;
	public static final float APP_DEFAULT_FONT_SIZE_LARGE = 22;
	public static final float APP_DEFAULT_FONT_SIZE_X_LARGE = 25;
	public static final float APP_DEFAULT_FONT_SIZE_XX_LARGE = 28;
	
	
	public static Typeface getAppMainFont(Context context){
		return getFont(context, FONT_AFSANEH);
	}
	
	public static Typeface getDefaultPoemFont(Context context){
		return getFont(context, FONT_MASHIN_TAHRIR);
	}
	public static Typeface getFont(Context context, String fontName) {
		if (fontName.equals(FONT_AFSANEH)) {
			return (afsaneh == null ? (afsaneh = Typeface.createFromAsset(
					context.getAssets(), FONT_PATH_PREFIX + FONT_AFSANEH))
					: afsaneh);
		} else if (fontName.equals(FONT_DAST_NEVESHTE)) {
			return (dastNeveshte == null ? (dastNeveshte = Typeface
					.createFromAsset(context.getAssets(), FONT_PATH_PREFIX
							+ FONT_DAST_NEVESHTE)) : dastNeveshte);
		} else if (fontName.equals(FONT_DROID_ARABIK)) {
			return (droid == null ? (droid = Typeface.createFromAsset(
					context.getAssets(), FONT_PATH_PREFIX + FONT_DROID_ARABIK))
					: droid);
		} else if (fontName.equals(FONT_FANTECY)) {
			return (fantecy == null ? (fantecy = Typeface.createFromAsset(
					context.getAssets(), FONT_PATH_PREFIX + FONT_FANTECY))
					: fantecy);
		} else if (fontName.equals(FONT_IRAN_NASTALIQ)) {
			return (iranNastaliq == null ? (iranNastaliq = Typeface
					.createFromAsset(context.getAssets(), FONT_PATH_PREFIX
							+ FONT_IRAN_NASTALIQ)) : iranNastaliq);
		} else if (fontName.equals(FONT_KOODAK)) {
			return (koodak == null ? (koodak = Typeface.createFromAsset(
					context.getAssets(), FONT_PATH_PREFIX + FONT_KOODAK))
					: koodak);
		} else if (fontName.equals(FONT_MASHIN_TAHRIR)) {
			return (mashinTahrir == null ? (mashinTahrir = Typeface
					.createFromAsset(context.getAssets(), FONT_PATH_PREFIX
							+ FONT_MASHIN_TAHRIR)) : mashinTahrir);
		} else if (fontName.equals(FONT_NASKH)) {
			return (naskh == null ? (naskh = Typeface.createFromAsset(
					context.getAssets(), FONT_PATH_PREFIX + FONT_NASKH))
					: naskh);
		} else if (fontName.equals(FONT_NAZANIN_BOLD)) {
			return (nazanin == null ? (nazanin = Typeface.createFromAsset(
					context.getAssets(), FONT_PATH_PREFIX + FONT_NAZANIN_BOLD))
					: nazanin);
		} else if (fontName.equals(FONT_NEGAR)) {
			return (negar == null ? (negar = Typeface.createFromAsset(
					context.getAssets(), FONT_PATH_PREFIX + FONT_NEGAR))
					: negar);
		} else if (fontName.equals(FONT_SANS)) {
			return (sans == null ? (sans = Typeface.createFromAsset(
					context.getAssets(), FONT_PATH_PREFIX + FONT_SANS)) : sans);
		} else if (fontName.equals(FONT_SETAREH)) {
			return (serareh == null ? (serareh = Typeface.createFromAsset(
					context.getAssets(), FONT_PATH_PREFIX + FONT_SETAREH))
					: serareh);
		} else if (fontName.equals(FONT_URDU)) {
			return (urdu == null ? (urdu = Typeface.createFromAsset(
					context.getAssets(), FONT_PATH_PREFIX + FONT_URDU)) : urdu);
		}
		Log.e("hojjat", "Error in loading typeface:  " + fontName);
		return null;
	}

}
