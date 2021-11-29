package com.example.digitalrestaurant.Authentications;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.R;

public class SignupPageForFoodSeller2 extends AppCompatActivity {

    EditText signupName,signupEmail,signupPaswd;

    Button signSubBtn;

    DatabaseHelper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page_for_vendor);

        signupName = findViewById(R.id.signupName);
        signupEmail = findViewById(R.id.signupEmail);
        signupPaswd = (findViewById(R.id.signupPaswd));

        signSubBtn = (findViewById(R.id.signSubBtn));


        signup();

    }

    public void signup(){
        signSubBtn.setOnClickListener(v -> {

            helper=new DatabaseHelper(this);

            String name= signupName.getText().toString();
            String email= signupEmail.getText().toString();
            String password= signupPaswd.getText().toString();

            if (name.equals("") || email.equals("")|| password.equals("")){

                Toast.makeText(this, "All fields must be complete", Toast.LENGTH_SHORT).show();

            }


            else {


                boolean signup =
                        helper.addVendorData(name, email, password);

                if (signup == true) {
                    Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    signupName.setText("");
                    signupEmail.setText("");
                    signupPaswd.setText("");
                    Intent i = new Intent(this, LoginPageForFoodSeller2.class);
                    startActivity(i);

                } else Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();


            }

        });
        }




}