package com.example.megha.instawallet;

import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import api.ApiClient;
import api.LoginApiEndPoint;
import model.api.BaseResponse;
import model.api.UserAuthenticate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private LoginApiEndPoint loginApiEndPoint;
    boolean success;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        loginApiEndPoint =
                ApiClient.getClient().create(LoginApiEndPoint.class);


    }

    @Override
    protected void onStart() {
        super.onStart();
        setListners();
    }

    private void setListners() {
        if (username.getText().toString() != null && password.getText().toString() != null) {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Call<BaseResponse> call = loginApiEndPoint.userLogin(new UserAuthenticate(username.getText().toString(),password.getText().toString()));
                    call.enqueue(new Callback<BaseResponse>() {
                        @Override
                        public void onResponse(Call<BaseResponse>call, Response<BaseResponse> response) {
                            success=response.body().isSuccess();
                            Toast.makeText(MainActivity.this, "Registered User" ,Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onFailure(Call<BaseResponse>call, Throwable t) {
                            // Log error here since request failed
                            Log.e("Failure Reason", t.toString());
                        }
                    });

                }
            });
        }
    }
}
