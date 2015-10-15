package com.hojjat.nameInPoem;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hojjat.nameInPoem.util.Constants;
import com.hojjat.nameInPoem.util.PersianReshape;
import com.hojjat.nameInPoem.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ActivityDesign extends Activity {

    RelativeLayout image;
    ImageView background;
    TextView title;
    RelativeLayout verse1;
    RelativeLayout verse2;
    RelativeLayout verse3;
    RelativeLayout verse4;
    RelativeLayout verse5;
    RelativeLayout verse6;
    TextView verseText1;
    TextView verseText2;
    TextView verseText3;
    TextView verseText4;
    TextView verseText5;
    TextView verseText6;
    TextView verseFirstLetter1;
    TextView verseFirstLetter2;
    TextView verseFirstLetter3;
    TextView verseFirstLetter4;
    TextView verseFirstLetter5;
    TextView verseFirstLetter6;
    TextView poet;

    ImageButton changeAlignment;
    ImageButton changeTextStyle;
    ImageButton changeBackground;
    ImageButton changeColors;
    ImageButton alignTwoSide;
    ImageButton alignCenter;
    ImageButton alignRight;

    ImageButton effects;
    ImageButton edit;

    RelativeLayout mainSettingLayout;
    RelativeLayout alignmentSettingLayout;


    ArrayList<PoemItem> poems;
    PoemItem choosedPoem;
    String name;
    String[] fonts = {StringUtil.FONT_AFSANEH, StringUtil.FONT_DAST_NEVESHTE,
            StringUtil.FONT_DROID_ARABIK, StringUtil.FONT_FANTECY,
            StringUtil.FONT_IRAN_NASTALIQ, StringUtil.FONT_KOODAK,
            StringUtil.FONT_MASHIN_TAHRIR, StringUtil.FONT_NASKH,
            StringUtil.FONT_NAZANIN_BOLD, StringUtil.FONT_NEGAR,
            StringUtil.FONT_SANS, StringUtil.FONT_SETAREH};
    String[] colors = {"#FFFFFF", "#446712", "#000000"};

    int currentBackground;
    int numberOfBackgrounds = 21;

    int currentAlignment;
    int numberOfAlignments = 3;
    int currentFont;
    int currentMainColor;
    int currentSecondColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_design);
        initializeViews();
        loadData();
        setTexts();
        setFonts();
        setAnimations();
        setListeners();
        setInitialStyleForImage();
    }

    private void setInitialStyleForImage() {
        Display display = getWindowManager().getDefaultDisplay();
        int screenWidth = display.getWidth();
        image.getLayoutParams().height = image.getLayoutParams().width = screenWidth;

        setPoemsFont(5);
        setPoemsMainColor(0);
        setPoemsSecondColor(1);
        setPoemsBackground(0);
    }

    private void setListeners() {
        ButtonClickListener listener = new ButtonClickListener();
        changeAlignment.setOnClickListener(listener);
        alignRight.setOnClickListener(listener);
        alignCenter.setOnClickListener(listener);
        alignTwoSide.setOnClickListener(listener);
    }

    private void setAnimations() {

    }

    private void setFonts() {
        Typeface appMainFont = StringUtil.getAppMainFont(this);

    }

    private void setTexts() {
        setPoemsTexts();

    }

    private void setPoemsTexts() {
        title.setText(PersianReshape.reshape(name));
        if (choosedPoem.type == 1) {
            verseFirstLetter1.setVisibility(View.GONE);
            verseFirstLetter2.setVisibility(View.GONE);
            verseFirstLetter3.setVisibility(View.GONE);
            verseFirstLetter4.setVisibility(View.GONE);
            verseFirstLetter5.setVisibility(View.GONE);
            verseFirstLetter6.setVisibility(View.GONE);
            if (choosedPoem.getNumberOfVerses() >= 1) {
                verseText1.setText(choosedPoem.getVerse(1));
            } else {
                verse1.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 2) {
                verseText2.setText(choosedPoem.getVerse(2));
            } else {
                verse2.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 3) {
                verseText3.setText(choosedPoem.getVerse(3));
            } else {
                verse3.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 4) {
                verseText4.setText(choosedPoem.getVerse(4));
            } else {
                verse4.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 5) {
                verseText5.setText(choosedPoem.getVerse(5));
            } else {
                verse5.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 6) {
                verseText6.setText(choosedPoem.getVerse(6));
            } else {
                verse6.setVisibility(View.GONE);
            }
        } else if (choosedPoem.getType() == 2) {
            if (choosedPoem.getNameLength() >= 1) {
                verseFirstLetter1.setText("" + choosedPoem.getName().charAt(0));
            } else {
                verseFirstLetter1.setVisibility(View.GONE);
            }
            if (choosedPoem.getNameLength() >= 2) {
                verseFirstLetter2.setText("" + choosedPoem.getName().charAt(1));
            } else {
                verseFirstLetter2.setVisibility(View.GONE);
            }
            if (choosedPoem.getNameLength() >= 3) {
                verseFirstLetter3.setText("" + choosedPoem.getName().charAt(2));
            } else {
                verseFirstLetter3.setVisibility(View.GONE);
            }
            if (choosedPoem.getNameLength() >= 4) {
                verseFirstLetter4.setText("" + choosedPoem.getName().charAt(3));
            } else {
                verseFirstLetter4.setVisibility(View.GONE);
            }
            if (choosedPoem.getNameLength() >= 5) {
                verseFirstLetter5.setText("" + choosedPoem.getName().charAt(4));
            } else {
                verseFirstLetter5.setVisibility(View.GONE);
            }
            if (choosedPoem.getNameLength() >= 6) {
                verseFirstLetter6.setText("" + choosedPoem.getName().charAt(5));
            } else {
                verseFirstLetter6.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 1) {
                verseText1.setText(choosedPoem.getVerse(1).substring(1));
            } else {
                verse1.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 2) {
                if (choosedPoem.getNameLength() >= 2) {
                    verseText2.setText(choosedPoem.getVerse(2).substring(1));
                } else {
                    verseText2.setText(choosedPoem.getVerse(2));
                }
            } else {
                verse2.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 3) {
                verseText3.setText(choosedPoem.getVerse(3).substring(1));
            } else {
                verse3.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 4) {
                if (choosedPoem.getNameLength() >= 4) {
                    verseText4.setText(choosedPoem.getVerse(4).substring(1));
                } else {
                    verseText4.setText(choosedPoem.getVerse(4));
                }
            } else {
                verse4.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 5) {
                verseText5.setText(choosedPoem.getVerse(5).substring(1));
            } else {
                verse5.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 6) {
                if (choosedPoem.getNameLength() >= 6) {
                    verseText6.setText(choosedPoem.getVerse(6).substring(1));
                } else {
                    verseText6.setText(choosedPoem.getVerse(6).substring(1));
                }
            } else {
                verse6.setVisibility(View.GONE);
            }
        } else {
            verseFirstLetter1.setVisibility(View.GONE);
            verseText1.setText(choosedPoem.getVerse(1));
            if (choosedPoem.getNameLength() >= 1) {
                verseFirstLetter2.setText("" + choosedPoem.getName().charAt(0));
            } else {
                verseFirstLetter2.setVisibility(View.GONE);
            }
            if (choosedPoem.getNameLength() >= 2) {
                verseFirstLetter3.setText("" + choosedPoem.getName().charAt(1));
            } else {
                verseFirstLetter3.setVisibility(View.GONE);
            }
            if (choosedPoem.getNameLength() >= 3) {
                verseFirstLetter4.setText("" + choosedPoem.getName().charAt(2));
            } else {
                verseFirstLetter4.setVisibility(View.GONE);
            }
            if (choosedPoem.getNameLength() >= 4) {
                verseFirstLetter5.setText("" + choosedPoem.getName().charAt(3));
            } else {
                verseFirstLetter5.setVisibility(View.GONE);
            }
            if (choosedPoem.getNameLength() >= 5) {
                verseFirstLetter6.setText("" + choosedPoem.getName().charAt(4));
            } else {
                verseFirstLetter6.setVisibility(View.GONE);
            }

            if (choosedPoem.getNumberOfVerses() >= 2) {
                verseText2.setText(choosedPoem.getVerse(2).substring(1));
            } else {
                verse2.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 3) {
                verseText3.setText(choosedPoem.getVerse(3).substring(1));
            } else {
                verse3.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 4) {
                if (choosedPoem.getNameLength() >= 3) {
                    verseText4.setText(choosedPoem.getVerse(4).substring(1));
                } else {
                    verseText4.setText(choosedPoem.getVerse(4));
                }
            } else {
                verse4.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 5) {
                verseText5.setText(choosedPoem.getVerse(5).substring(1));
            } else {
                verse5.setVisibility(View.GONE);
            }
            if (choosedPoem.getNumberOfVerses() >= 6) {
                if (choosedPoem.getNameLength() >= 5) {
                    verseText6.setText(choosedPoem.getVerse(6).substring(1));
                } else {
                    verseText6.setText(choosedPoem.getVerse(6));
                }
            } else {
                verse6.setVisibility(View.GONE);
            }
        }
        if (choosedPoem.getPoet() == null
                || "".equals(choosedPoem.getPoem().trim())) {
            poet.setVisibility(View.GONE);
        } else {
            poet.setText(choosedPoem.getPoet());
        }
    }

    private void loadData() {
        poems = new ArrayList<>();
        name = getIntent().getExtras().getString(Constants.CHOOSED_NAME);
        name = PersianReshape.reshape("آبناز");
        // TODO poems must be loaded from db
        poems.add(new PoemItem(
                "بهار گشت، ز خود عارفانه بیرون آی;اگر ز خود نتوانی، ز خانه بیرون آی;بود رفیق سبکروح تازیانهٔ شوق;نگشته است صبا تا روانه بیرون آی;اگر به کاهلی طبع برنمی‌آیی;ز خود به زور شراب شبانه بیرون آی",
                "آبناز", 3, "وحشی بافقی", 6));
        poems.add(new PoemItem(
                "صبحست خیز کاین نفس از گلشن بهشت;بزم صبوحیان سحرخیز خوشترست;اول بنوش ساغر و وانگه بده شراب;زیرا که بادهٔ شکرآمیز خوشترست",
                "صبا", 2, "انوری", 4));
        choosedPoem = poems.get(0);
    }

    private void initializeViews() {
        image = (RelativeLayout) findViewById(R.id.image);
        background = (ImageView) findViewById(R.id.background);
        title = (TextView) findViewById(R.id.title);
        verse1 = (RelativeLayout) findViewById(R.id.verse1);
        verse2 = (RelativeLayout) findViewById(R.id.verse2);
        verse3 = (RelativeLayout) findViewById(R.id.verse3);
        verse4 = (RelativeLayout) findViewById(R.id.verse4);
        verse5 = (RelativeLayout) findViewById(R.id.verse5);
        verse6 = (RelativeLayout) findViewById(R.id.verse6);
        verseText1 = (TextView) findViewById(R.id.verse1_text);
        verseText2 = (TextView) findViewById(R.id.verse2_text);
        verseText3 = (TextView) findViewById(R.id.verse3_text);
        verseText4 = (TextView) findViewById(R.id.verse4_text);
        verseText5 = (TextView) findViewById(R.id.verse5_text);
        verseText6 = (TextView) findViewById(R.id.verse6_text);
        verseFirstLetter1 = (TextView) findViewById(R.id.verse1_firse_letter);
        verseFirstLetter2 = (TextView) findViewById(R.id.verse2_firse_letter);
        verseFirstLetter3 = (TextView) findViewById(R.id.verse3_firse_letter);
        verseFirstLetter4 = (TextView) findViewById(R.id.verse4_firse_letter);
        verseFirstLetter5 = (TextView) findViewById(R.id.verse5_firse_letter);
        verseFirstLetter6 = (TextView) findViewById(R.id.verse6_firse_letter);
        poet = (TextView) findViewById(R.id.poet);

        mainSettingLayout = (RelativeLayout) findViewById(R.id.main_setting_layout);
        alignmentSettingLayout = (RelativeLayout) findViewById(R.id.alignment_setting_layout);

        effects = (ImageButton) findViewById(R.id.effect);
        edit = (ImageButton) findViewById(R.id.edit);

        changeAlignment = (ImageButton) findViewById(R.id.change_alignment);
        changeBackground = (ImageButton) findViewById(R.id.change_background);
        changeTextStyle = (ImageButton) findViewById(R.id.change_text_style);
        changeColors = (ImageButton) findViewById(R.id.change_colors);
        alignTwoSide = (ImageButton) findViewById(R.id.align_two_side);
        alignCenter = (ImageButton) findViewById(R.id.align_center);
        alignRight = (ImageButton) findViewById(R.id.align_right);


    }

    private void setPoemsFont(int fontIndex) {
        Typeface typeface = StringUtil.getFont(this, fonts[fontIndex]);
        title.setTypeface(typeface);
        verseText1.setTypeface(typeface);
        verseText2.setTypeface(typeface);
        verseText3.setTypeface(typeface);
        verseText4.setTypeface(typeface);
        verseText5.setTypeface(typeface);
        verseText6.setTypeface(typeface);
        verseFirstLetter1.setTypeface(typeface);
        verseFirstLetter2.setTypeface(typeface);
        verseFirstLetter3.setTypeface(typeface);
        verseFirstLetter4.setTypeface(typeface);
        verseFirstLetter5.setTypeface(typeface);
        verseFirstLetter6.setTypeface(typeface);
        poet.setTypeface(typeface);
    }

    private void setPoemsFontSize(int size) {
        title.setTextSize(TypedValue.COMPLEX_UNIT_PX, size + 6);
        verseText1.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        verseText2.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        verseText3.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        verseText4.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        verseText5.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        verseText6.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        verseFirstLetter1.setTextSize(TypedValue.COMPLEX_UNIT_PX, size + 3);
        verseFirstLetter2.setTextSize(TypedValue.COMPLEX_UNIT_PX, size + 3);
        verseFirstLetter3.setTextSize(TypedValue.COMPLEX_UNIT_PX, size + 3);
        verseFirstLetter4.setTextSize(TypedValue.COMPLEX_UNIT_PX, size + 3);
        verseFirstLetter5.setTextSize(TypedValue.COMPLEX_UNIT_PX, size + 3);
        verseFirstLetter6.setTextSize(TypedValue.COMPLEX_UNIT_PX, size + 3);
        poet.setTextSize(TypedValue.COMPLEX_UNIT_PX, size - 5);
    }

    private void setPoemsMainColor(int index) {
        verseText1.setTextColor(Color.parseColor(colors[index]));
        verseText2.setTextColor(Color.parseColor(colors[index]));
        verseText3.setTextColor(Color.parseColor(colors[index]));
        verseText4.setTextColor(Color.parseColor(colors[index]));
        verseText5.setTextColor(Color.parseColor(colors[index]));
        verseText6.setTextColor(Color.parseColor(colors[index]));
        poet.setTextColor(Color.GRAY);
    }

    private void setPoemsSecondColor(int index) {
        title.setTextColor(Color.parseColor(colors[index]));
        verseFirstLetter1.setTextColor(Color.parseColor(colors[index]));
        verseFirstLetter2.setTextColor(Color.parseColor(colors[index]));
        verseFirstLetter3.setTextColor(Color.parseColor(colors[index]));
        verseFirstLetter4.setTextColor(Color.parseColor(colors[index]));
        verseFirstLetter5.setTextColor(Color.parseColor(colors[index]));
        verseFirstLetter6.setTextColor(Color.parseColor(colors[index]));
    }

    private void setPoemsBackground(int index) {
        switch (index) {
            case 0:
                background.setImageResource(R.drawable.bg0);
                background.setBackgroundColor(Color.rgb(193, 187, 41));
                break;
            case 1:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg1);
                break;
            case 2:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg2);
                break;
            case 3:
                background.setImageResource(R.drawable.bg0);
                background.setBackgroundColor(Color.rgb(152, 203, 128));
                break;
            case 4:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg4);
                break;
            case 5:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg5);
                break;
            case 6:
                background.setImageResource(R.drawable.bg0);
                background.setBackgroundColor(Color.rgb(157, 39, 25));
                break;
            case 7:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg7);
                break;
            case 8:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg8);
                break;
            case 9:
                background.setImageResource(R.drawable.bg0);
                background.setBackgroundColor(Color.rgb(18, 123, 90));
                break;
            case 10:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg10);
                break;
            case 11:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg11);
                break;
            case 12:
                background.setImageResource(R.drawable.bg0);
                background.setBackgroundColor(Color.rgb(100, 160, 161));
                break;
            case 13:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg13);
                break;
            case 14:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg3);
                break;
            case 15:
                background.setImageResource(R.drawable.bg0);
                background.setBackgroundColor(Color.rgb(254, 163, 145));
                break;
            case 16:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg9);
                break;
            case 17:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg12);
                break;
            case 18:
                background.setImageResource(R.drawable.bg0);
                background.setBackgroundColor(Color.rgb(166, 130, 116));
                break;
            case 19:
                background.setImageBitmap(null);
                background.setBackgroundResource(R.drawable.bg6);
                break;
            case 20:
                background.setImageResource(R.drawable.bg0);
                background.setBackgroundColor(Color.rgb(170, 165, 11));
                break;
            default:
                break;
        }
    }

    /*
    index:
    0 = align right
    1 = align two side
    2 = align center
     */

    private void setPoemsAlignment(int index) {
        switch (index) {
            case 0:
                verse1.setGravity(Gravity.RIGHT);
                verse2.setGravity(Gravity.RIGHT);
                verse3.setGravity(Gravity.RIGHT);
                verse4.setGravity(Gravity.RIGHT);
                verse5.setGravity(Gravity.RIGHT);
                verse6.setGravity(Gravity.RIGHT);
                break;
            case 1:
                verse1.setGravity(Gravity.RIGHT);
                verse2.setGravity(Gravity.LEFT);
                verse3.setGravity(Gravity.RIGHT);
                verse4.setGravity(Gravity.LEFT);
                verse5.setGravity(Gravity.RIGHT);
                verse6.setGravity(Gravity.LEFT);
                break;
            case 2:
                verse1.setGravity(Gravity.CENTER);
                verse2.setGravity(Gravity.CENTER);
                verse3.setGravity(Gravity.CENTER);
                verse4.setGravity(Gravity.CENTER);
                verse5.setGravity(Gravity.CENTER);
                verse6.setGravity(Gravity.CENTER);
                break;
        }
    }

    class ButtonClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == changeAlignment.getId()) {
                changeSettingLayout(mainSettingLayout, alignmentSettingLayout);
            } else if (id == alignCenter.getId()) {
                setPoemsAlignment(2);
            } else if (id == alignTwoSide.getId()) {
                setPoemsAlignment(1);
            } else if (id == alignRight.getId()) {
                setPoemsAlignment(0);
            }

//			if (v.getId() == chooseFontNext.getId()) {
//				setPoemsFont(++currentFont % fonts.length);
//			} else if (v.getId() == chooseFontPrevious.getId()) {
//				if (currentFont == 0) {
//					currentFont = fonts.length;
//				}
//				setPoemsFont(--currentFont % fonts.length);
//			} else if (v.getId() == chooseFontColor1Next.getId()) {
//				setPoemsMainColor(++currentMainColor % colors.length);
//			} else if (v.getId() == chooseFontColor1Previous.getId()) {
//				if (currentMainColor == 0) {
//					currentMainColor = colors.length;
//				}
//				setPoemsMainColor(--currentMainColor % colors.length);
//			} else if (v.getId() == chooseFontColor2Next.getId()) {
//				setPoemsSecondColor(++currentSecondColor % colors.length);
//			} else if (v.getId() == chooseFontColor2Previous.getId()) {
//				if (currentSecondColor == 0) {
//					currentSecondColor = colors.length;
//				}
//				setPoemsMainColor(--currentSecondColor % colors.length);
//			} else if (v.getId() == chooseFontSizeNext.getId()) {
//				setPoemsFontSize((int) verseText1.getTextSize() + 1);
//			} else if (v.getId() == chooseFontSizePrevious.getId()) {
//				if ((int) verseText1.getTextSize() > 8) {
//					setPoemsFontSize((int) verseText1.getTextSize() - 1);
//				}
//			} else if (v.getId() == chooseBackgroundNext.getId()) {
//				setPoemsBackground(++currentBackground % numberOfBackgrounds);
//			} else if (v.getId() == chooseBackgroundPrevious.getId()) {
//				if (currentBackground == 0) {
//					currentBackground = numberOfBackgrounds;
//				}
//				setPoemsBackground(--currentBackground % numberOfBackgrounds);
//			} else if (v.getId() == chooseAlignmentNext.getId()) {
//				setPoemsAlignment(++currentAlignment % numberOfAlignments);
//			} else if (v.getId() == chooseAlignmentPrevious.getId()) {
//				if (currentAlignment == 0) {
//					currentAlignment = numberOfAlignments;
//				}
//				setPoemsAlignment(--currentAlignment % numberOfAlignments);
//			}else if(v.getId() == share.getId()){
////				Intent intent = new Intent();
////				intent.setAction(Intent.ACTION_SEND);
////				intent.setType("image/*");
////				startActivity(intent);
//
//				String[] nameOfAppsToShareWith = new String[] { "facebook", "instagram", "mail", "whatsapp", "viber", "line", "tango"};
//				String[] blacklist = new String[]{"com.any.package", "net.other.package", "bluetooth"};
//				// your share intent
//				Intent intent = new Intent(Intent.ACTION_SEND);
//				intent.setType("text/plain");
//				intent.putExtra(Intent.EXTRA_TEXT, "some text");
//				intent.putExtra(Intent.EXTRA_SUBJECT, "a subject");
//				// ... anything else you want to add invoke custom chooser
//				startActivity(generateCustomChooserIntent(intent, blacklist, nameOfAppsToShareWith));
//
//
//			}

        }


        private Intent generateCustomChooserIntent(Intent prototype,
                                                   String[] forbiddenChoices, String[] nameOfAppsToShareWith) {
            List<Intent> targetedShareIntents = new ArrayList<>();
            List<HashMap<String, String>> intentMetaInfo = new ArrayList<HashMap<String, String>>();
            Intent chooserIntent;

            Intent dummy = new Intent(prototype.getAction());
            dummy.setType(prototype.getType());
            List<ResolveInfo> resInfo = getPackageManager().queryIntentActivities(dummy, 0);

            if (!resInfo.isEmpty()) {
                for (ResolveInfo resolveInfo : resInfo) {
                    if (resolveInfo.activityInfo == null
                            || Arrays.asList(forbiddenChoices).contains(
                            resolveInfo.activityInfo.packageName))
                        continue;
                    //Get all the posible sharers
                    HashMap<String, String> info = new HashMap<String, String>();
                    info.put("packageName", resolveInfo.activityInfo.packageName);
                    info.put("className", resolveInfo.activityInfo.name);
                    String appName = String.valueOf(resolveInfo.activityInfo
                            .loadLabel(getPackageManager()));
                    info.put("simpleName", appName);
                    //Add only what we want
                    Log.d("hojjat", appName.toLowerCase());
                    if (Arrays.asList(nameOfAppsToShareWith).contains(
                            appName.toLowerCase())) {
                        intentMetaInfo.add(info);
                    }
                }

                if (!intentMetaInfo.isEmpty()) {
                    // sorting for nice readability
                    Collections.sort(intentMetaInfo,
                            new Comparator<HashMap<String, String>>() {
                                @Override
                                public int compare(
                                        HashMap<String, String> map,
                                        HashMap<String, String> map2) {
                                    return map.get("simpleName").compareTo(
                                            map2.get("simpleName"));
                                }
                            });

                    // create the custom intent list
                    for (HashMap<String, String> metaInfo : intentMetaInfo) {
                        Intent targetedShareIntent = (Intent) prototype.clone();
                        targetedShareIntent.setPackage(metaInfo.get("packageName"));
                        targetedShareIntent.setClassName(
                                metaInfo.get("packageName"),
                                metaInfo.get("className"));
                        targetedShareIntents.add(targetedShareIntent);
                    }
                    String shareVia = PersianReshape.reshape("اشتراک گذاری از طریق");
                    String shareTitle = shareVia.substring(0, 1).toUpperCase()
                            + shareVia.substring(1);
                    chooserIntent = Intent.createChooser(targetedShareIntents
                            .remove(targetedShareIntents.size() - 1), shareTitle);
                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS,
                            targetedShareIntents.toArray(new Parcelable[]{}));
                    return chooserIntent;
                }
            }
            return Intent.createChooser(prototype,
                    PersianReshape.reshape("اشتراک گذاری از طریق"));
        }
    }

    private void changeSettingLayout(View old, View new_) {
        old.setVisibility(View.INVISIBLE);
        new_.setVisibility(View.VISIBLE);
    }
}