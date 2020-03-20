package com.neha.butterknife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.neha.butterknife.databinding.ActivityMainBinding;
import com.neha.butterknife.entity.Login_Register_Entity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Click_Events {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setClickEvents(MainActivity.this);


    }

    @Override
    public void on_Save_User() {

    }

    @Override
    public void on_Check_User() {

        final String email = mainBinding.etEmail.getText().toString();
        final String password = mainBinding.etPassword.getText().toString();
        if (email.isEmpty()) {
            mainBinding.etEmail.setError("Field Required");
            mainBinding.etEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            mainBinding.etPassword.setError("Field Required");
            mainBinding.etPassword.requestFocus();
            return;
        }

        class Check_User_Exist_In_Room extends AsyncTask<Void, Void, List<Login_Register_Entity>> {
            @Override
            protected List<Login_Register_Entity> doInBackground(Void... voids) {

                //adding to database
                List<Login_Register_Entity> login_register_entity = Database_Client.getInstance(getApplicationContext()).getAppDatabase()
                        .dao_obj()
                        .check_if_user_exists(email, password);
                return login_register_entity;


            }

            @Override
            protected void onPostExecute(List<Login_Register_Entity> login_register_entity) {
                super.onPostExecute(login_register_entity);

                if (login_register_entity.size() == 0) {

                    Toast.makeText(getApplicationContext(), "Invalid Username and Password", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();

                }
            }
        }


        Check_User_Exist_In_Room st = new Check_User_Exist_In_Room();
        st.execute();
    }

    @Override
    public void on_Register_Button() {
        Intent i = new Intent(MainActivity.this, Register_Screen.class);
        startActivity(i);
    }
}
