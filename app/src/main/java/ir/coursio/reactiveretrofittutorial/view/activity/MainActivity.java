package ir.coursio.reactiveretrofittutorial.view.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ir.coursio.reactiveretrofittutorial.R;
import ir.coursio.reactiveretrofittutorial.api.ApiClient;
import ir.coursio.reactiveretrofittutorial.api.ApiService;
import ir.coursio.reactiveretrofittutorial.model.api.Responses.JokeListResponse;
import ir.coursio.reactiveretrofittutorial.presenter.interfaces.MainPresenter;
import ir.coursio.reactiveretrofittutorial.presenter.implementations.MainPresenterImpl;
import ir.coursio.reactiveretrofittutorial.utils.PermissionHandler;
import ir.coursio.reactiveretrofittutorial.view.BaseActivity;
import ir.coursio.reactiveretrofittutorial.view.adapter.JokeAdapter;


public class MainActivity extends BaseActivity implements MainView {

    private ApiService service;
    MainPresenter presenter;

    JokeAdapter mAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getPermissions();
        service = ApiClient.getClient().create(ApiService.class);
        initRecyclerView();

        presenter = new MainPresenterImpl(this);
    }


    /**
     * Listener for btnGetJoke
     */
    @OnClick(R.id.btnGetJoke)
    public void getJoke() {
        presenter.getJokes(service);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }


    @Override
    public void makeAdapter(JokeListResponse response) {
        mAdapter = new JokeAdapter(response.getJokes());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void getPermissions() {
        String[] permissions = {Manifest.permission.INTERNET};
        new PermissionHandler().checkPermission(MainActivity.this, permissions, new PermissionHandler.OnPermissionResponse() {
            @Override
            public void onPermissionGranted() {
            }

            @Override
            public void onPermissionDenied() {
            }
        });
    }

}
