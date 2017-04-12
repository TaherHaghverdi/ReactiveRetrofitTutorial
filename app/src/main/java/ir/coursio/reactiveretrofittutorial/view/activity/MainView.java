package ir.coursio.reactiveretrofittutorial.view.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import ir.coursio.reactiveretrofittutorial.model.api.Responses.JokeListResponse;
import ir.coursio.reactiveretrofittutorial.view.adapter.JokeAdapter;

/**
 * Created by Taher on 12/04/2017.
 * Project: ReactiveRetrofitTutorial
 */

public interface MainView {

    void makeAdapter(JokeListResponse response);

    AppCompatActivity getActivity();

    Context getAppContext();
}
