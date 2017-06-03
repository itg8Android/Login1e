package com.example.vaibhav.login1e.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vaibhav.login1e.assessor.AddAssessor;
import com.example.vaibhav.login1e.common.SharedPrefClass;
import com.example.vaibhav.login1e.dashboard.Dashboard;
import com.example.vaibhav.login1e.R;
import com.example.vaibhav.login1e.exams.ExamExpActivity;
import com.example.vaibhav.login1e.login.model.LoginModel;
import com.example.vaibhav.login1e.login.model.ResponseLoginModel;
import com.example.vaibhav.login1e.rest.Retro;
import com.example.vaibhav.login1e.rest.RetroControler;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText EmailEditText, PasswordEditText;
    private Button LoginButton, CreateButton;
    private RecyclerView recyclerView;
   // private TodayExamsAdapter adapter;

    public void asset() {

        EmailEditText = (EditText) findViewById(R.id.Email_edit_text);
        PasswordEditText = (EditText) findViewById(R.id.password_edit_text);
        LoginButton = (Button) findViewById(R.id.Button_login);
        CreateButton = (Button) findViewById(R.id.createButton);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asset();
        checkIfAlreadyLogin();
        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this, AddAssessor.class);
                startActivity(intent);
            }
        });

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   LoginButtonOnClick(v);
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
            }


        });
    }

    private void checkIfAlreadyLogin() {
        if(SharedPrefClass.getInstance(this).havePreference(SharedPrefClass.USERNAME)){
            goToDashboard();
        }
    }

    public void initRecyclerView(){
           recyclerView.setLayoutManager(new LinearLayoutManager(this));


       }

    private void LoginButtonOnClick(View v) {


       LoginModel model=new LoginModel();
       model.setUsername(EmailEditText.getText().toString());
        model.setPassword(PasswordEditText.getText().toString());
        model.setMethod("login");
        RetroControler controler= Retro.getInstance().getRetrofit();
        Call<ResponseBody> call=controler.login(EmailEditText.getText().toString(),
                PasswordEditText.getText().toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
//                    SharedPrefClass.getInstance(getBaseContext()).savePref(SharedPrefClass.USERNAME,response.body().getUserid());
                    goToDashboard();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }


        });

    }

    private void goToDashboard() {
        Intent intent=new Intent(this,Dashboard.class);
        startActivity(intent);
        finish();
    }

}