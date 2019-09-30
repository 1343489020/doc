package com.example.constraintset;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.transition.TransitionManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioGroup;

public class ConstraintSetActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintSet mConstraintSet = new ConstraintSet();
    private ConstraintSet mConstraintSetBackUp = new ConstraintSet();
    private ConstraintLayout mContentWrapper;
    private Button mChanger;
    private RadioGroup mTestChooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContentWrapper = findViewById(R.id.content_wrapper);
        mConstraintSet.clone(mContentWrapper);
        mConstraintSetBackUp.clone(mConstraintSet);
        mTestChooser = findViewById(R.id.chooser);
        mChanger = findViewById(R.id.changer_btn);
        mChanger.setOnClickListener(this);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onClick(View v) {
        TransitionManager.beginDelayedTransition(mContentWrapper);
        if (mTestChooser.getCheckedRadioButtonId() == R.id.reset) {
            mConstraintSetBackUp.applyTo(mContentWrapper);
            return;
        }
        switch (mTestChooser.getCheckedRadioButtonId()) {
            case R.id.size_test:
                mConstraintSet.constrainWidth(R.id.title_tv, 300);
                break;
            case R.id.connect_test:
                mConstraintSet.connect(R.id.chooser, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
                break;
            case R.id.center_test:
                mConstraintSet.center(R.id.chooser, R.id.title_tv, ConstraintSet.TOP, 0, R.id.changer_btn, ConstraintSet.BOTTOM, 0, 0.5f);
                break;
            default:
                break;
        }
        mConstraintSet.applyTo(mContentWrapper);
    }
}
