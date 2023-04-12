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
            StringBuffer buffer = new StringBuffer();
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

    public static void findLongestDistanceBetweenUsers(ArrayList<User> users) {
        double maxDistance = 0;
        User user1 = null, user2 = null;
        for (User u1 : users) {
            double tempDistance = 0;
            for (User u2 : users) {
                tempDistance = distance(
                        u1.getAddress().getGeolocation().getLat(),
                        u1.getAddress().getGeolocation().getLon(),
                        u2.getAddress().getGeolocation().getLat(),
                        u2.getAddress().getGeolocation().getLat());
                if (maxDistance < tempDistance) {
                    user1 = u1;
                    user2 = u2;
                    maxDistance = Math.max(maxDistance, tempDistance);
                }
            }
            maxDistance = Math.max(maxDistance, tempDistance);
        }
        System.out.println("Furthest distance is between: " + user1 + " and " + user2);
    }

    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return dist;
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
