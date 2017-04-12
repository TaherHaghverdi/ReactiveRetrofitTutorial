package ir.coursio.reactiveretrofittutorial.api;


import io.reactivex.Observable;
import ir.coursio.reactiveretrofittutorial.model.api.Responses.JokeListResponse;
import ir.coursio.reactiveretrofittutorial.model.api.Responses.RandomJokeResponse;
import retrofit2.http.GET;

/**
 * Created by Taher on 2/5/2017.
 * Project: ReactiveRetrofitTutorial
 */


public interface ApiService {
    // 1. Method    -> Get
    // 2. Url       -> http://api.icndb.com/jokes/ + random
    // 3. Response  -> RandomJokeResponse

    @GET("jokes/random")
    Observable<RandomJokeResponse> getRandomJoke();

    @GET("jokes")
    Observable<JokeListResponse> getJokes();

}