package com.udsoft.udsalary.ViewController;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.udsoft.udsalary.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewUserActivity extends AppCompatActivity {

    private final static String TAG = "NewUserActivity.Class";

    @BindView(R.id.bt_create_new_job)
    Button btCreateNewJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bt_create_new_job)
    public void onViewClicked() {
        Intent intentToCreateRule = new Intent(getApplication(),CreateNewJobActivity.class);
        startActivity(intentToCreateRule);
        Log.i(TAG,"Intent to create new job.");
    }
}
