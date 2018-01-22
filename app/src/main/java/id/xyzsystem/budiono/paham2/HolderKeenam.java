package id.xyzsystem.budiono.paham2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by budiono on 22/01/18.
 */

public class HolderKeenam extends RecyclerView.ViewHolder {
    @BindView(R.id.weather_item_image)
    ImageView weatherImage;

    @BindView(R.id.weather_item_desc)
    TextView weatherDesc;

    private static final int weatherLayout = R.layout.view_holder_weather;

    public HolderKeenam(View itemView) {
        super(itemView);

        //mulai disini
        ButterKnife.bind(this, itemView);
    }

    public TextView ambilWeatherDesc() {
        return weatherDesc;
    }

    public ImageView ambilWeatherImage() {
        return weatherImage;
    }
    public static int getWeatherLayout() {
        return weatherLayout;
    }
}
