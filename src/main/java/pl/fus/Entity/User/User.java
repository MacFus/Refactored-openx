package pl.fus.Entity.User;

//import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @SerializedName("address")
    private Address address;
    private int id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private String phone;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }

    //    public User(ObjectMapper objectMapper, URL url) {
//        this.objectMapper = objectMapper;
//        this.url = url;
//    }
//
//    @Override
//    public Map<Integer, User> map(ArrayList<User> list) {
//        Map<Integer, User> userMap = new HashMap<>();
//        for (User u : list)
//            userMap.put(u.getId(), u);
//        return userMap;
//    }
//
//    @Override
//    public User[] init() {
//        User[] value;
//        try {
//            value = objectMapper.readValue(url, User[].class);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return value;
//    }
}