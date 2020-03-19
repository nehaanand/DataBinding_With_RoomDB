package com.neha.butterknife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Database;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.neha.butterknife.databinding.ActivityRegisterScreenBinding;
import com.neha.butterknife.entity.Login_Register_Entity;

import org.json.JSONObject;

public class Register_Screen extends AppCompatActivity implements Click_Events {

    ActivityRegisterScreenBinding registerScreenBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_register__screen);
        registerScreenBinding.setClickEvents(Register_Screen.this);

    }

    @Override
    public void on_Register_Button_Click() {
        Toast.makeText(Register_Screen.this, "Register clicked!  " + registerScreenBinding.etEmail.getText().toString(), Toast.LENGTH_LONG).show();
        save_user();

    }


    public void save_user(){
        if (registerScreenBinding.etFirstName.getText().toString().isEmpty()) {
            registerScreenBinding.etFirstName.setError("Field Required");
            registerScreenBinding.etFirstName.requestFocus();
            return;
        }
        if (registerScreenBinding.etLastName.getText().toString().isEmpty()) {
            registerScreenBinding.etLastName.setError("Field Required");
            registerScreenBinding.etLastName.requestFocus();
            return;
        }

        if (registerScreenBinding.etEmail.getText().toString().isEmpty()) {
            registerScreenBinding.etEmail.setError("Field Required");
            registerScreenBinding.etEmail.requestFocus();
            return;
        }

        if (registerScreenBinding.etPassword.getText().toString().isEmpty()) {
            registerScreenBinding.etPassword.setError("Field Required");
            registerScreenBinding.etPassword.requestFocus();
            return;
        }


        class Save_User_To_Room extends AsyncTask<Void,Void,Void>{
            @Override
            protected Void doInBackground(Void... voids) {
                Login_Register_Entity entity = new Login_Register_Entity();
                entity.setEmail(registerScreenBinding.etEmail.getText().toString());
                entity.setFirstName(registerScreenBinding.etFirstName.getText().toString());
                entity.setLastName(registerScreenBinding.etLastName.getText().toString());
                entity.setPassword(registerScreenBinding.etPassword.getText().toString());

                //adding to database
                Database_Client.getInstance(getApplicationContext()).getAppDatabase()
                        .dao_obj()
                        .insert(entity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_LONG).show();
            }
        }


        Save_User_To_Room st = new Save_User_To_Room();
        st.execute();
    }

}


