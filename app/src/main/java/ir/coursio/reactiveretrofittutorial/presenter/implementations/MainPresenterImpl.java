package ir.coursio.reactiveretrofittutorial.presenter.implementations;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ir.coursio.reactiveretrofittutorial.api.ApiService;
import ir.coursio.reactiveretrofittutorial.model.api.Responses.JokeListResponse;
import ir.coursio.reactiveretrofittutorial.presenter.interfaces.MainPresenter;
import ir.coursio.reactiveretrofittutorial.view.activity.MainView;

/**
 * Created by Taher on 12/04/2017.
 * Project: ReactiveRetrofitTutorial
 */

public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;
    private CompositeDisposable mCompositeDisposable;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void handleResponse(JokeListResponse response) {
        mainView.makeAdapter(response);
    }

    @Override
    public void handleError(Throwable error) {
        error.printStackTrace();
    }



    @Override
    public void getJokes(ApiService service) {

        mCompositeDisposable.add(service.getJokes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));
    }

    @Override
    public void onDestroy() {
        mCompositeDisposable.clear();
        mainView = null;
    }
}
