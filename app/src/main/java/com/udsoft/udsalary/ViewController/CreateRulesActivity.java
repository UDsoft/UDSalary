package com.udsoft.udsalary.ViewController;


import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.udsoft.udsalary.Model.Rule;
import com.udsoft.udsalary.R;
import java.util.Calendar;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateRulesActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

    private final String TAG = "CREATERULEACTIVITY";

    @BindView(R.id.spinner_rule_type)
    Spinner spinnerRuleType;
    @BindView(R.id.text_start_time)
    EditText textStartTime;
    @BindView(R.id.text_end_time)
    EditText textEndTime;
    @BindView(R.id.btn_start_time)
    Button btnStartTime;
    @BindView(R.id.btn_end_timer)
    Button btnEndTimer;
    @BindView(R.id.btn_OK)
    Button btnOK;
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.guideline3)
    Guideline guideline3;

    MODETIME timeMode;
    Rule rule;
    String job_name;
    UUID job_ID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_rules);
        ButterKnife.bind(this);
        //Getting Data from the previous Intent.
        if(savedInstanceState == null){
            Log.i(TAG,"savedInstanceState is null");
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                job_name = null;
                job_ID = null;
                Log.e(TAG,"Job name and Job ID is null");
            }else{
                job_name = extras.getString(getResources().getString(R.string.KEY_JOB_NAME));
                job_ID = (UUID)extras.getSerializable(getResources().getString(R.string.KEY_JOB_ID));
                Log.i(TAG,"Job name : "+ job_name + " and Job ID : " + job_ID);
            }
        }else{
            job_ID = (UUID) savedInstanceState.getSerializable(getResources().getString(R.string.KEY_JOB_ID));
            job_name = (String )savedInstanceState.getSerializable(getResources().getString(R.string.KEY_JOB_NAME));
            Log.i(TAG,"Job name : "+ job_name + " and Job ID : " + job_ID);
        }
        //Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Job_type, android.R.layout.simple_spinner_dropdown_item);
        //Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerRuleType.setAdapter(adapter);


    }


    @OnClick({R.id.btn_start_time, R.id.btn_end_timer, R.id.btn_OK, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_start_time:
                showTimePickerView();
                timeMode = MODETIME.START;
                break;
            case R.id.btn_end_timer:
                showTimePickerView();
                timeMode = MODETIME.END;
                break;
            case R.id.btn_OK:
                processData();
                break;
            case R.id.btn_cancel:
                cancelChoice();
                break;
        }
    }

    private void processData(){

    }

    private void cancelChoice(){

    }

     private void showTimePickerView() {
         Calendar calendar = Calendar.getInstance();
         int hour = calendar.get(Calendar.HOUR_OF_DAY);
         int min = calendar.get(Calendar.MINUTE);
         TimePickerDialog timePickerDialog = new TimePickerDialog(CreateRulesActivity.this,CreateRulesActivity.this,hour,min,DateFormat.is24HourFormat(CreateRulesActivity.this));
         timePickerDialog.show();

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        switch (timeMode){
            case START:
                textStartTime.setText(timeFormat(hourOfDay,minute));
                break;
            case END:
                textEndTime.setText(timeFormat(hourOfDay,minute));
                break;
            default:
                Log.e(TAG,"Time mode is not set.");
        }
    }

    private String timeFormat(int hour , int min){
        String displayHour;
        String displayMin;

        if(hour < 10){
            displayHour = "0" + hour;
        }else
            displayHour = String.valueOf(hour);

        if(min < 10){
            displayMin = "0" + min;
        }else{
            displayMin = String .valueOf(min);
        }

        String result = displayHour +":"+ displayMin;
        return result;
    }


    public enum MODETIME{
        START,END
    }

}
