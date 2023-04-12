package pl.fus.Entity.User;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Address {
//    @SerializedName("geolocation")
    @SerializedName("geolocation")
    private Geolocation geolocation;
    private String city;
    private String street;
    private int number;
    private String zipcode;
}