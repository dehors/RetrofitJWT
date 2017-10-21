package com.example.slam24.retrofitjwt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.slam24.retrofitjwt.common.ApiClient;
import com.example.slam24.retrofitjwt.models.Auth;
import com.example.slam24.retrofitjwt.pokeapi.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnretrofit;
    EditText edtusername, edtpass;
    private static final String TAG = "POKEDEX";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;
        SharedPreferences sharedPreferences = getSharedPreferences("LocalStorage", context.MODE_PRIVATE);

        btnretrofit = (Button)findViewById(R.id.btnsend);
        edtusername = (EditText) findViewById(R.id.edt1);
        edtpass = (EditText) findViewById(R.id.edt2);

        btnretrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(context);
            }
        });
    }

    private void Login(final Context context) {
        String username = edtusername.getText().toString();
        String password = edtpass.getText().toString();

        APIService service = ApiClient.getClient().create(APIService.class);

        Call<Auth> userCall = service.userLogIn(username,password);

        userCall.enqueue(new Callback<Auth>() {
            @Override
            public void onResponse(Call<Auth> call, Response<Auth> response) {
                if (response.code() == 200){
                    SharedPreferences sharedPref = getPreferences(context.MODE_PRIVATE);
                    SharedPreferences.Editor editor  = sharedPref.edit();
                    editor.putString("token", response.body().getToken());
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, NavigationDrawer.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),Integer.toString(response.code()),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Auth> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
