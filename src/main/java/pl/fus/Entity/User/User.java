package pl.fus.Entity.User;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
public class User {
    @SerializedName("address")
    private Address address;
    private int id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private String phone;

    public User(Address address, int id) {
        this.address = address;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }


}