package id.xyzsystem.budiono.paham2;

import java.util.List;

/**
 * Created by budiono on 22/01/18.
 */

public class EventKedelapan {
    private boolean success;
    private String message;
    private List<ModelKeempat> forecastList;

    public EventKedelapan(boolean success, List<ModelKeempat> forecastList) {
        this.success = success;
        this.forecastList = forecastList;
    }

    public EventKedelapan(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<ModelKeempat> getForecastList() {
        return forecastList;
    }
}
