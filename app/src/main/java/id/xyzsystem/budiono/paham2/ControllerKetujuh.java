package id.xyzsystem.budiono.paham2;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by budiono on 22/01/18.
 */

public class ControllerKetujuh {
    private static final String TAG = "WeatherController";
    private EventBus eventBus = AppPertama.getInstance().ambilEventBus();

    public void getWeatherList() {
        Call<ResponseKetiga> dailyForecast =
                AppPertama.getInstance().getWeatherApi().getDailyForecast
                        ("Jakarta"
                        , "json"
                        , "metric"
                        , 10
                                , InterfaceKedua.API_KEY);

        dailyForecast.enqueue(new Callback<ResponseKetiga>() {
            @Override
            public void onResponse(Call<ResponseKetiga> call, Response<ResponseKetiga> response) {
                Log.d(TAG, "onResponse: Success");
                Log.d(TAG, "onResponse: JSON = " + AppPertama.getInstance().ambilGson().toJson(response.body()));
                List<ModelKeempat> forecastList = response.body().ambilmodelList();
                EventKedelapan weatherEvent = new EventKedelapan(true, forecastList);
                eventBus.post(weatherEvent);
            }

            @Override
            public void onFailure(Call<ResponseKetiga> call, Throwable t) {
                Log.e(TAG, "onFailure: Failed");
                Log.e(TAG, "onFailure: Message = " + t.getMessage());
                EventKedelapan weatherEvent = new EventKedelapan(false, t.getMessage());
                eventBus.post(weatherEvent);
            }
        });
    }
}
