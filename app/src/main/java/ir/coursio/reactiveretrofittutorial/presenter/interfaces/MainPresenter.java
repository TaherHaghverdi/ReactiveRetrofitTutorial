package ir.coursio.reactiveretrofittutorial.presenter.interfaces;

import android.support.v7.widget.RecyclerView;

import ir.coursio.reactiveretrofittutorial.api.ApiService;
import ir.coursio.reactiveretrofittutorial.model.api.Responses.JokeListResponse;

/**
 * Created by Taher on 12/04/2017.
 * Project: ReactiveRetrofitTutorial
 */

public interface MainPresenter {
    void handleResponse(JokeListResponse response);

    void handleError(Throwable error);

    void getJokes(ApiService service);

    RecyclerView.LayoutManager getRecyclerViewLayoutManager();
    void getPermissions();

    void onDestroy();
}
