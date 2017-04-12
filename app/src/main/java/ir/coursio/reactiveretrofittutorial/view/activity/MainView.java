package ir.coursio.reactiveretrofittutorial.view.activity;

import ir.coursio.reactiveretrofittutorial.model.api.Responses.JokeListResponse;
import ir.coursio.reactiveretrofittutorial.view.adapter.JokeAdapter;

/**
 * Created by Taher on 12/04/2017.
 * Project: ReactiveRetrofitTutorial
 */

public interface MainView {
    void getPermissions();

    void makeAdapter(JokeListResponse response);

    void initRecyclerView();
}
