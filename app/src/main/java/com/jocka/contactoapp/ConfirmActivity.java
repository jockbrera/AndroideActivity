package com.jocka.contactoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class ConfirmActivity extends AppCompatActivity {

    private TextView lblFullName;
    private TextView lblPhone;
    private TextView lblEmail;
    private TextView lblContactDescription;
    private TextView lblBirthDate;
    private MaterialButton btnEdit;

    private String fullName;
    private String phone;
    private String email;
    private String contactDescription;
    private int day;
    private int month;
    private int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Bundle parameters = getIntent().getExtras();
        init(parameters);
    }

    private void init(Bundle parameters) {

        lblFullName = (TextView) findViewById(R.id.lbl_full_name_edit);
        lblPhone = (TextView) findViewById(R.id.lbl_phone_edit);
        lblEmail = (TextView) findViewById(R.id.lbl_email_edit);
        lblContactDescription = (TextView) findViewById(R.id.lbl_contact_description_edit);
        lblBirthDate = (TextView) findViewById(R.id.lbl_birth_date_edit);
        btnEdit = (MaterialButton) findViewById(R.id.btn_edit);

        fullName = parameters.getString(getResources().getString(R.string.lbl_full_name));
        phone = parameters.getString(getResources().getString(R.string.lbl_phone));
        email = parameters.getString(getResources().getString(R.string.lbl_email));
        contactDescription = parameters.getString(getResources().getString(R.string.lbl_contact_description));
        day = parameters.getInt(getResources().getString(R.string.lbl_day));
        month = parameters.getInt(getResources().getString(R.string.lbl_month));
        year = parameters.getInt(getResources().getString(R.string.lbl_year));

        lblFullName.setText(fullName);
        lblBirthDate.setText(lblBirthDate.getText().toString()
                .concat(": ")
                .concat(String.valueOf(day))
                .concat("/")
                .concat(String.valueOf(month))
                .concat("/")
                .concat(String.valueOf(year)));
        lblPhone.setText(lblPhone.getText().toString().concat(": ").concat(phone));
        lblEmail.setText(lblEmail.getText().toString().concat(": ").concat(email));
        lblContactDescription.setText(lblContactDescription.getText().toString().concat(": ").concat(contactDescription));

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmActivity.this,  MainActivity.class);
                intent.putExtra(getResources().getString(R.string.lbl_full_name), fullName);
                intent.putExtra(getResources().getString(R.string.lbl_phone), phone);
                intent.putExtra(getResources().getString(R.string.lbl_email), email);
                intent.putExtra(getResources().getString(R.string.lbl_contact_description), contactDescription);
                intent.putExtra(getResources().getString(R.string.lbl_day), day);
                intent.putExtra(getResources().getString(R.string.lbl_month), month);
                intent.putExtra(getResources().getString(R.string.lbl_year), year);
                startActivity(intent);
            }
        });
    }
}
