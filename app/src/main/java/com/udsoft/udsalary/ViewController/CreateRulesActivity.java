package com.udsoft.udsalary.ViewController;


import android.app.TimePickerDialog;
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
import com.udsoft.udsalary.R;
import java.util.Calendar;
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

    private String timeMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_rules);
        ButterKnife.bind(this);
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
                timeMode = "startTime";
                break;
            case R.id.btn_end_timer:
                showTimePickerView();
                timeMode = "endTime";
                break;
            case R.id.btn_OK:
                intentMode("ok");
                break;
            case R.id.btn_cancel:
                intentMode("cancel");
                break;
        }
    }

    private  void intentMode(String mode) {

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
            case "startTime":
                textStartTime.setText(timeFormat(hourOfDay,minute));
                break;
            case "endTime":
                textEndTime.setText(timeFormat(hourOfDay,minute));
                break;
            default:
                Log.e(TAG,"Time mode variable is not set.");
        }


    }

    private String timeFormat(int hour , int min){
        String result = hour +":"+ min;
        return result;
    }


}
