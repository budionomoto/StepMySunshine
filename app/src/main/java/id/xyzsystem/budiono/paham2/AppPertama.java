package id.xyzsystem.budiono.paham2;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by budiono on 22/01/18.
 */

public class AppPertama extends Application {
    private static AppPertama instance;
    private EventBus eventBus;
    private Gson gson;

    public AppPertama() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        bikinEventBus();
        bikinGson();

    }

    private void bikinGson() {
        gson = new GsonBuilder().create();
    }

    private void bikinEventBus() {
        eventBus = EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .build();

    }
    public Gson ambilGson() {
        return gson;
    }

    public EventBus ambilEventBus() {
        return eventBus;
    }

    public InterfaceKedua getWeatherApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(InterfaceKedua.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(InterfaceKedua.class);
    }

    public static AppPertama getInstance() {
        return instance;
    }
}
