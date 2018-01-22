package id.xyzsystem.budiono.paham2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by budiono on 22/01/18.
 */

public class AdapterKelima extends RecyclerView.Adapter {
    List<ModelKeempat> forecasts;

    public AdapterKelima() {
        forecasts = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(HolderKeenam.getWeatherLayout(), parent, false);
        return new HolderKeenam(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        setWeatherItem((HolderKeenam) holder);
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    private void setWeatherItem(HolderKeenam holder) {
        ModelKeempat forecast = forecasts.get(holder.getAdapterPosition());
        Glide.with(holder.itemView.getContext()).load(ambilWeatherImageUrl(forecast.getWeatherList().get(0).ambilWeatherIcon())).into(holder.ambilWeatherImage());

        //Date date = new Date(forecast.getForecastDate() * 1000);
        //String datePattern = "EEE, MMM dd";
        //SimpleDateFormat outputFormat = new SimpleDateFormat(datePattern, Locale.getDefault());
        //String strDate = outputFormat.format(date);
        //holder.getWeatherDate().setText(strDate);
        holder.ambilWeatherDesc().setText(forecast.getWeatherList().get(0).ambilWeatherDesc());
        //long tempDay = Math.round(forecast.getTemperature().getTempDay());
        //holder.getWeatherTemp().setText(tempDay + holder.itemView.getContext().getString(R.string.degree));
    }

    private String ambilWeatherImageUrl(String weatherIcon) {
        return "http://openweathermap.org/img/w/" + weatherIcon + ".png";
    }

    public void kirimData(List<ModelKeempat> forecasts) {
        this.forecasts.addAll(forecasts);
        notifyDataSetChanged();
    }

}
