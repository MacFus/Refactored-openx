package pl.fus;

import pl.fus.Entity.User.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Utils {
    public static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public static ArrayList<User> findLongestDistanceBetweenUsers(ArrayList<User> users) {
        double maxDistance = 0;

        ArrayList<User> usersToReturn = new ArrayList<>();
        for (User u1 : users) {
            double tempDistance = 0;
            for (User u2 : users) {
//                if(u1.getId() == u2.getId())
//                    break;
                tempDistance = distance(
                        u1.getAddress().getGeolocation().getLat(),
                        u1.getAddress().getGeolocation().getLon(),
                        u2.getAddress().getGeolocation().getLat(),
                        u2.getAddress().getGeolocation().getLon());
                if (maxDistance < tempDistance) {
                    if(usersToReturn.isEmpty()){
                        usersToReturn.add(u1);
                        usersToReturn.add(u2);
                    }else{
                        usersToReturn.set(0,u1);
                        usersToReturn.set(1,u2);
                    }
                    maxDistance = tempDistance;
                    System.out.println(u1 + " " + u2 + " distance: " + tempDistance);
                }
            }
        }
        System.out.println("Furthest distance is between: " + usersToReturn.get(0) + " and " + usersToReturn.get(1) + "\nDistance: " + maxDistance + " km\n");
        return usersToReturn;
    }



    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

}
