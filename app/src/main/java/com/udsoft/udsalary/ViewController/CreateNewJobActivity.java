package com.udsoft.udsalary.ViewController;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.udsoft.udsalary.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateNewJobActivity extends AppCompatActivity {

    @BindView(R.id.input_job_name)
    EditText inputJobName;
    @BindView(R.id.input_company_name)
    EditText inputCompanyName;
    @BindView(R.id.input_description)
    EditText inputDescription;
    @BindView(R.id.bt_ok)
    Button btOk;
    @BindView(R.id.bt_cancel)
    Button btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_job);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_ok)
    public void onBtOkClicked() {
        Intent intentToCreateRules = new Intent(getApplication(),CreateRulesActivity.class);
        startActivity(intentToCreateRules);
    }

    @OnClick(R.id.bt_cancel)
    public void onBtCancelClicked() {
        Intent intentToNewUser = new Intent(getApplication(),NewUserActivity.class);
        startActivity(intentToNewUser);
    }
}
