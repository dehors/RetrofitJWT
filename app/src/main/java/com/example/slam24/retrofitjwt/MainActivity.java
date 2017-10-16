package com.example.slam24.retrofitjwt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.slam24.retrofitjwt.models.Pokemon;
import com.example.slam24.retrofitjwt.models.PokemonResponse;
import com.example.slam24.retrofitjwt.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button btnretrofit;
    private Retrofit retrofit;
    private static final String TAG = "POKEDEX";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        btnretrofit = (Button)findViewById(R.id.button);

        btnretrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }

    private void getData() {
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonResponse> pokemonResponseCall = service.getListPokemon();

        pokemonResponseCall.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()){
                    PokemonResponse pokemonresponse = response.body();
                    ArrayList<Pokemon> listPokemon = pokemonresponse.getResults();

                    for (int i = 0; i < listPokemon.size() ; i++) {
                        Pokemon p = listPokemon.get(i);
                        if (i == 3){
                            Toast.makeText(getApplicationContext(), "Pokemon: "+p.getName().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(getApplicationContext(), Log.e(TAG,"onResponse"+response.errorBody()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), Log.e(TAG,"onFailure"+t.getMessage()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
