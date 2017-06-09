package com.udsoft.udsalary.ViewController;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.udsoft.udsalary.Model.Job;
import com.udsoft.udsalary.R;

import java.util.UUID;

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

    private Job job;
    private String job_name;
    private String company_name;
    private String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_job);
        ButterKnife.bind(this);
    }



    @OnClick(R.id.bt_ok)
    public void onBtOkClicked() {
        if(dataValid()){
            job = new Job(description,job_name,company_name);
            UUID job_ID = job.getID();
            Intent intentToCreateRules = new Intent(getApplication(),CreateRulesActivity.class);
            intentToCreateRules.putExtra(getResources().getString(R.string.KEY_JOB_NAME),job_name);
            intentToCreateRules.putExtra(getResources().getString(R.string.KEY_JOB_ID),job_ID);
            startActivity(intentToCreateRules);
        }else {
            Toast error = Toast.makeText(getApplicationContext(),getResources().getString(R.string.error_incomplete_job_details),Toast.LENGTH_SHORT);
        }

    }

    private boolean dataValid() {
        job_name = inputJobName.getText().toString();
        company_name= inputCompanyName.getText().toString();
        description = inputDescription.getText().toString();
        boolean isdataValid = true;

        if(job_name.isEmpty()){
            inputJobName.setError(getResources().getString(R.string.error_job_name_empty));
            isdataValid = false;
        }

        if(company_name.isEmpty()){
            inputCompanyName.setError(getResources().getString(R.string.error_company_name_empty));
            isdataValid =false;
        }

        if(description.isEmpty()){
            description = getResources().getString(R.string.default_job_description);
        }


        return isdataValid;
    }

    @OnClick(R.id.bt_cancel)
    public void onBtCancelClicked() {
        Intent intentToNewUser = new Intent(getApplication(),NewUserActivity.class);
        startActivity(intentToNewUser);
    }
}
