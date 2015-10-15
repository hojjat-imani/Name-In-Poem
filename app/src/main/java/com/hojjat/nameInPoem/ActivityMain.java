package com.hojjat.nameInPoem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.hojjat.nameInPoem.util.Constants;
import com.nineoldandroids.animation.ObjectAnimator;

import java.util.ArrayList;


public class ActivityMain extends ActionBarActivity {

    AutoCompleteTextView nameSearchField;
    ListView suggestList;
    AdapterNameSuggestion adapter;
    RelativeLayout suggestLayout;
    RelativeLayout mainButtonsLayout;
    RelativeLayout searchLayout;
    View searchLayoutBackground;
    RelativeLayout rootLayout;

    Toolbar toolbar;

    boolean isSearching = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.windowBackground));

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeViews();
        setTexts();
        setFonts();
        setAnimations();
        setListeners();
        loadData();
        nameSearchField.setAdapter(adapter);
        // as customizing the view of the suggestion list of
        // autoCompleteTextView
        // is a little bit hard, i will use my own list view as suggestion list
        // by
        // setting the same adapter to it and setting the size of default list
        // to zero
        nameSearchField.setDropDownWidth(0);
        nameSearchField.setDropDownHeight(0);
        nameSearchField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showSuggestList();
                } else {
                    hideSuggestList();
                }
            }
        });
        suggestList.setAdapter(adapter);
        suggestList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = adapter.getItem(position);
                Intent intent = new Intent(ActivityMain.this, ActivityDesign.class);
                intent.putExtra(Constants.CHOOSED_NAME, name);
                startActivity(intent);
            }
        });
    }

    private void showSuggestList() {
        isSearching = true;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        //set height of searchLayoutBackground
        ViewGroup.LayoutParams layoutParams = searchLayoutBackground.getLayoutParams();
        layoutParams.height = searchLayout.getMeasuredHeight();
        searchLayoutBackground.setLayoutParams(layoutParams);
        suggestLayout.setPadding(0,searchLayout.getMeasuredHeight() , 0 , 0);

        //animate serachLayoutBackground
        AlphaAnimation searchBackgoundAnimation = new AlphaAnimation(0, 1);
        searchBackgoundAnimation.setDuration(Constants.ANIMATION_DURATION_SHORT);
        searchBackgoundAnimation.setFillAfter(true);
        searchLayoutBackground.startAnimation(searchBackgoundAnimation);

        //animate search layout and toolbar
        ObjectAnimator.ofFloat(searchLayout, "translationY", - getSupportActionBar().getHeight()).setDuration(Constants.ANIMATION_DURATION_SHORT).start();
        ObjectAnimator.ofFloat(toolbar, "translationY",  - getSupportActionBar().getHeight()).setDuration(Constants.ANIMATION_DURATION_SHORT).start();

        //animate suggestLayout
        TranslateAnimation suggestLayoutAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.ABSOLUTE, displayMetrics.heightPixels, Animation.ABSOLUTE, 0 );
        suggestLayoutAnimation.setDuration(Constants.ANIMATION_DURATION_SHORT);
        suggestLayoutAnimation.setFillAfter(true);
        suggestLayout.startAnimation(suggestLayoutAnimation);

        //set visibility of views
        suggestLayout.setVisibility(View.VISIBLE);
        mainButtonsLayout.setVisibility(View.INVISIBLE);
    }

    private void hideSuggestList(){
        isSearching = false;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        //animate serachLayoutBackground
        AlphaAnimation searchBackgoundAnimation = new AlphaAnimation(1, 0);
        searchBackgoundAnimation.setDuration(Constants.ANIMATION_DURATION_SHORT);
        searchBackgoundAnimation.setFillAfter(true);
        searchLayoutBackground.startAnimation(searchBackgoundAnimation);

        //animate search layout and toolbar
        ObjectAnimator.ofFloat(searchLayout, "translationY", 0).setDuration(Constants.ANIMATION_DURATION_SHORT).start();
        ObjectAnimator.ofFloat(toolbar, "translationY",  0).setDuration(Constants.ANIMATION_DURATION_SHORT).start();



        //animate suggestLayout
        TranslateAnimation suggestLayoutAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.ABSOLUTE, 0, Animation.ABSOLUTE, displayMetrics.heightPixels);
        suggestLayoutAnimation.setDuration(Constants.ANIMATION_DURATION_SHORT);
        suggestLayoutAnimation.setFillAfter(true);
        suggestLayoutAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                //set visibility of views
                suggestLayout.setVisibility(View.INVISIBLE);
                mainButtonsLayout.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        suggestLayout.startAnimation(suggestLayoutAnimation);
    }

    private void loadData() {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            names.add("item " + i);
        }
        names.add("hojjat");
        names.add("hojjat4");
        names.add("hojjat2");
        names.add("hojjat1");
        names.add("hojkjdf");
        names.add("kljsdf");
        names.add("lkjsf");
        names.add("lejfdfs");
        names.add("lskf");
        names.add("iuywefds");
        names.add("v,mnls");
        names.add("kloef");
        names.add("wuryif");
        names.add("wkjljie");
        names.add("q[ijsdf");
        names.add("akjhd");
        names.add("zcnbxhj");
        names.add("anbvmd");
        names.add("vnnkjdfa");
        names.add("bzmnbd");
        names.add("mnbvjds");
        names.add("m,jd");
        names.add("wytnbc");
        names.add("rjbc");
        names.add("yutwyfb");
        names.add("nbjhafsd");
        names.add("wutf");
        names.add("mnzvsd");
        names.add("zjhfdf");
        names.add("منستیبنت");
        names.add("بمنهث ");
        names.add("بسبسشبس");
        names.add("سبس بیبیس");
        names.add("سبسیب یب");
        names.add("ابا");
        names.add("یلیبص");
        names.add("شضصب");
        names.add("لیسیاتب");
        names.add("لتغف");
        names.add("بشثب");
        names.add("تغ");
        names.add("غسش");
        names.add("خغهخه");
        names.add("شبافع");
        names.add("شقغت");
        names.add("شطظر");
        names.add("فغعخغ");
        names.add("شب");
        names.add("ضض");
        names.add("بیسا6هف");
        names.add("باهخغع");
        names.add("اسظذزذ");
        names.add("عمهحح9ج");
        names.add("شبظر");
        names.add("یالثفص");
        names.add("شبصفث");
        names.add("خهع");
        names.add("خممعخل");
        names.add("غفقعقن");
        names.add("سغهفههع");
        names.add("شابا");
        names.add("قثغثق");
        names.add("شبشظ");
        names.add("رثثصبس");
        names.add("بشسل");
        names.add("شبث");
        names.add("دزظذر");
        names.add("ظبیشبص");
        adapter = new AdapterNameSuggestion(this, names);
    }

    private void initializeViews() {
        nameSearchField = (AutoCompleteTextView) findViewById(R.id.nameSearchField);
        suggestList = (ListView) findViewById(R.id.suggest_list);
        suggestLayout = (RelativeLayout) findViewById(R.id.suggest_layout);
        mainButtonsLayout = (RelativeLayout) findViewById(R.id.buttons_layout);
        searchLayout = (RelativeLayout) findViewById(R.id.search_layout);
        searchLayoutBackground = findViewById(R.id.search_layout_background);
        rootLayout = (RelativeLayout) findViewById(R.id.root_layout);
    }

    private void setTexts() {
//        ((TextView) findViewById(R.id.app_name)).setText(PersianReshape
//                .reshape(Constants.APP_NAME));
//        inputBox.setHint(PersianReshape.reshape("جستجو"));
//        ((TextView) findViewById(R.id.text_view)).setText(PersianReshape
//                .reshape("نام خود را از لیست انتخاب کنید"));
    }

    private void setFonts() {

    }

    private void setAnimations() {

    }

    private void setListeners() {
//        suggestList.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1,
//                                    int position, long arg3) {
//                // Intent i = new Intent(ActivityChooseName.this,
//                // ActivityChoosePoem.class);
//                Intent i = new Intent(ActivityChooseName.this,
//                        ActivityDesign.class);
//                i.putExtra(Constants.CHOOSED_NAME, adapter.getItem(position));
//                startActivity(i);
//            }
//        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Log.d("hojjat", "back pressed. isSearching  : " + isSearching);
        if(isSearching){
            nameSearchField.setText("");
            nameSearchField.clearFocus();
        }else{
            //handle exit
            super.onBackPressed();
        }
    }
}
