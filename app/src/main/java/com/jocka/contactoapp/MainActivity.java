package com.jocka.contactoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtFullName;
    private TextInputEditText txtPhone;
    private TextInputEditText txtEmail;
    private TextInputEditText txtContactDescription;
    private DatePicker dtBirthDate;
    private MaterialButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parameters = getIntent().getExtras();
        init(parameters);
    }

    private void init(Bundle parameters) {

        txtFullName = (TextInputEditText) findViewById(R.id.txt_full_name);
        txtPhone = (TextInputEditText) findViewById(R.id.txt_phone);
        txtEmail = (TextInputEditText) findViewById(R.id.txt_email);
        txtContactDescription = (TextInputEditText) findViewById(R.id.txt_contact_description);
        dtBirthDate = (DatePicker) findViewById(R.id.dt_birth_date);

        if (parameters != null) {
            int month = parameters.getInt(getResources().getString(R.string.lbl_month)) - 1;
            txtFullName.setText(parameters.getString(getResources().getString(R.string.lbl_full_name)));
            dtBirthDate.updateDate(
                    parameters.getInt(getResources().getString(R.string.lbl_year)),
                    month,
                    parameters.getInt(getResources().getString(R.string.lbl_day)));
            txtPhone.setText(parameters.getString(getResources().getString(R.string.lbl_phone)));
            txtEmail.setText(parameters.getString(getResources().getString(R.string.lbl_email)));
            txtContactDescription.setText(parameters.getString(getResources().getString(R.string.lbl_contact_description)));
        }

        btnNext = (MaterialButton) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                intent.putExtra(getResources().getString(R.string.lbl_full_name), txtFullName.getText().toString());
                intent.putExtra(getResources().getString(R.string.lbl_phone), txtPhone.getText().toString());
                intent.putExtra(getResources().getString(R.string.lbl_email), txtEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.lbl_contact_description), txtContactDescription.getText().toString());
                intent.putExtra(getResources().getString(R.string.lbl_day), dtBirthDate.getDayOfMonth());
                intent.putExtra(getResources().getString(R.string.lbl_month), dtBirthDate.getMonth());
                intent.putExtra(getResources().getString(R.string.lbl_year), dtBirthDate.getYear());
                startActivity(intent);
            }
        });
    }
}