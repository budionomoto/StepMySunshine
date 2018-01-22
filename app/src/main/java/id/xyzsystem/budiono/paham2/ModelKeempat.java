package id.xyzsystem.budiono.paham2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by budiono on 22/01/18.
 */

public class ModelKeempat {

    @SerializedName("weather")
    private List<Weather> weatherList;

    public class Weather {
        @SerializedName("description")
        private String weatherDesc;

        @SerializedName("icon")
        private String weatherIcon;


        public String ambilWeatherDesc() {
            return weatherDesc;
        }

        public String ambilWeatherIcon() {
            return weatherIcon;
        }
    }
    public List<Weather> getWeatherList() {
        return weatherList;
    }

}
