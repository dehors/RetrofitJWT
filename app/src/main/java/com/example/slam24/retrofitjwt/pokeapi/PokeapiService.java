package com.example.slam24.retrofitjwt.pokeapi;

import com.example.slam24.retrofitjwt.models.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by SLAM24 on 10/15/2017.
 */

public interface PokeapiService {
    @GET("pokemon")
    Call<PokemonResponse> getListPokemon();
}
