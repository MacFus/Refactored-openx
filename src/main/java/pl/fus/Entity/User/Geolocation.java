package pl.fus.Entity.User;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Geolocation {
    @SerializedName("lat")
    private String lat;
    @SerializedName("long")
    private String lon;

    public double getLat() {
        return Math.floor(Double.parseDouble(lat));
    }

    public double getLon() {
        return Math.floor(Double.parseDouble(lon));
    }
}
