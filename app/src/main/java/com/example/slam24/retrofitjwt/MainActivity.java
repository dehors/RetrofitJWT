package com.example.slam24.retrofitjwt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.slam24.retrofitjwt.Session.Session;
import com.example.slam24.retrofitjwt.common.ApiClient;
import com.example.slam24.retrofitjwt.models.Auth;
import com.example.slam24.retrofitjwt.pokeapi.APIService;
import com.example.slam24.retrofitjwt.responses.AuthResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnretrofit;
    EditText edtusername, edtpass;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);
        btnretrofit = (Button)findViewById(R.id.btnsend);
        edtusername = (EditText) findViewById(R.id.edt1);
        edtpass = (EditText) findViewById(R.id.edt2);

        btnretrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void Login() {
        String username = edtusername.getText().toString();
        String password = edtpass.getText().toString();

        final APIService service = ApiClient.getClient().create(APIService.class);

        Call<AuthResponse> userCall = service.userLogIn(username,password);

        userCall.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.code() == 200){
                    AuthResponse authresponse = response.body();
                    Auth auth = authresponse.getData();
                    session.setvarString("token",auth.getToken());
                    session.setvarString("username",auth.getUsername());
                    session.setvarString("email",auth.getEmail());

                    Intent intent = new Intent(MainActivity.this, NavigationDrawer.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),Integer.toString(response.code()),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
