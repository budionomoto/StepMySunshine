package id.xyzsystem.budiono.paham2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_weather_list)
    RecyclerView mainWeatherList;

    private AdapterKelima weatherAdapter;
    private EventBus eventBus = AppPertama.getInstance().ambilEventBus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventBus.register(this);

        initView();

        ControllerKetujuh controller = new ControllerKetujuh();
        controller.getWeatherList();
    }

    @Override
    protected void onDestroy() {
        eventBus.unregister(this);
        super.onDestroy();
    }

    private void initView() {
        ButterKnife.bind(this);

        mainWeatherList.setLayoutManager(new GridLayoutManager(this,2) );
        mainWeatherList.setHasFixedSize(true);

        weatherAdapter = new AdapterKelima();
        mainWeatherList.setAdapter(weatherAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveWeatherList(EventKedelapan event) {
        if (event.isSuccess()) {
            List<ModelKeempat> forecasts = event.getForecastList();
            ModelKeempat todayForecast = forecasts.get(0);

            //mainToday.setText(strDate);

            //Glide.with(this).load(getWeatherImageUrl(todayForecast.getWeatherList().get(0).getWeatherIcon())).into(mainWeatherImage);
            //mainWeatherDesc.setText(todayForecast.getWeatherList().get(0).getWeatherDesc());
            //long tempDay = Math.round(todayForecast.getTemperature().getTempDay());
            //mainWeatherTemp.setText(tempDay + getString(R.string.degree));

            weatherAdapter.kirimData(forecasts);
        }else{

        }
    }
}
