package com.santam.nanosofttest;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

public class PersonEntry extends AppCompatActivity implements View.OnClickListener{
    SqLiteDBHelper mDatabaseHelper;
    String uniqueID = UUID.randomUUID().toString();
    EditText mName, mAge, mDob, mLatiude, mLongitude;
    Button mSubmit, mClose;
    protected static final String LATITUDE_PATTERN="^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$";
    protected static final String LONGITUDE_PATTERN="^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$";

    final Calendar myCalendar = Calendar.getInstance();
//    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_entry);

        mDatabaseHelper = new SqLiteDBHelper(this);

        mName = (EditText) findViewById(R.id.txtName);
        mAge = (EditText) findViewById(R.id.txtAge);
        mDob = (EditText) findViewById(R.id.txtBirthdt);
        mLatiude = (EditText) findViewById(R.id.txtLLatitude);
        mLongitude = (EditText) findViewById(R.id.txtLongitude);

        mSubmit = (Button) findViewById(R.id.btnReg);
        mClose = (Button) findViewById(R.id.btncls);
        mSubmit.setOnClickListener(this);
        mDob.setOnClickListener(this);
        mClose.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mDob){
            showDatePicker(mDob);
        }
        else if(v == mSubmit){
            if (mLongitude.getText().toString().length() !=0){
                if (mLongitude.getText().toString().length() != 0){
                    if (mLatiude.getText().toString().matches(LATITUDE_PATTERN)){
                        if (mLongitude.getText().toString().matches(LONGITUDE_PATTERN)){
                            AddData(uniqueID, mName.getText().toString(), Integer.parseInt(mAge.getText().toString().trim()), mDob.getText().toString(),
                                    (mLatiude.getText().toString()),
                                    (mLongitude.getText().toString()));
                        }
                        else {
                            ToastMsg("Please Insert Valid Longitude Value");
                        }
                    }
                    else {
                        ToastMsg("Please Insert Valid Longitude Value");
                    }

                }
                else {
                    AddData(uniqueID, mName.getText().toString(), Integer.parseInt(mAge.getText().toString().trim()), mDob.getText().toString(),
                            (mLatiude.getText().toString()), "");

                }
            }
            else{
                AddData(uniqueID, mName.getText().toString(), Integer.parseInt(mAge.getText().toString().trim()), mDob.getText().toString(),
                        "", (mLongitude.getText().toString()));
            }

        }
        else if (v == mClose){
            System.exit(0);
        }
    }

    private void AddData(String id, String name, int age, String dob, String latitude, String longitude) {

        if (uniqueID.length() > 0 && mName.getText().toString().length() != 0 && mDob.getText().toString().length() != 0)
        {
            boolean insertData = mDatabaseHelper.AddData(id, name, age, dob, latitude, longitude);
            if (insertData) {
                ToastMsg("Successfully Data Inserted");
                mName.setText("");
                mAge.setText("");
                mDob.setText("");
                mLongitude.setText("");
                mLatiude.setText("");
            } else
                ToastMsg("Data not Inserted! Please Try Again");
        }
        else{
            ToastMsg("Please Insert * Mark Field");
        }
    }
    public void ToastMsg(String msg){
        Toast.makeText(PersonEntry.this, msg, Toast.LENGTH_LONG).show();
    }

    public void showDatePicker(final TextView textView){
        DatePickerDialog.OnDateSetListener dpd= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
            private void updateLabel()
            {
                String myFormat = "yyyy-MM-dd"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                textView.setText(sdf.format(myCalendar.getTime()));
            }
        };
        //  Time now = new Time();
        DatePickerDialog d = new DatePickerDialog(PersonEntry.this, dpd, myCalendar.get(Calendar.YEAR) ,myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));
        d.show();
    }

}
