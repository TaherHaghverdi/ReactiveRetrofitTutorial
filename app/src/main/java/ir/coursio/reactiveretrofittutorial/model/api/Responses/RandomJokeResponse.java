package ir.coursio.reactiveretrofittutorial.model.api.Responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import ir.coursio.reactiveretrofittutorial.model.api.Subs.JokeStruct;


/**
 * Created by Taher on 16/03/2017.
 * Project: RetrofitTutorial
 */

public class RandomJokeResponse implements Serializable {

    @SerializedName("type")
    private String type;

    @SerializedName("value")
    private JokeStruct joke;

    public String getType() {
        return type;
    }

    public JokeStruct getJoke() {
        return joke;
    }
}
