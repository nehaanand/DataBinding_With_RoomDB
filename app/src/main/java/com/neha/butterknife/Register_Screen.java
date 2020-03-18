package com.neha.butterknife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.neha.butterknife.databinding.ActivityRegisterScreenBinding;

import org.json.JSONObject;

public class Register_Screen extends AppCompatActivity implements Click_Events {

    ActivityRegisterScreenBinding register_binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        register_binding = DataBindingUtil.setContentView(Register_Screen.this, R.layout.activity_register__screen);
    }

    @Override
    public void on_Register_Button_Click(View view) {
        Toast.makeText(Register_Screen.this, "Register clicked!" + register_binding.etEmail.getText().toString(), Toast.LENGTH_LONG).show();


    }

//    public class Items_Click_listener {
//        Context context;
//
//        public Items_Click_listener(Context context) {
//            this.context = context;
//        }
//        public void on_Register_Button_Click(View view) {
//            Toast.makeText(context, "Register clicked!"+register_binding.etEmail.getText().toString(), Toast.LENGTH_LONG).show();
//        }
//    }
}


