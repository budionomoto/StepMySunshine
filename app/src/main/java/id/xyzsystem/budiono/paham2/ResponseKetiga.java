package id.xyzsystem.budiono.paham2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by budiono on 22/01/18.
 */

public class ResponseKetiga {
    @SerializedName("list")
    private List<ModelKeempat> modelList;

    public List<ModelKeempat> ambilmodelList() {
        return modelList;
    }
}
