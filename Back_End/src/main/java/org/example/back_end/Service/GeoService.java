package org.example.back_end.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class GeoService {

    private final String API_KEY = "AIzaSyBDFfiXFeKcF2nARdPNGOlp1IP8GQSKVis";

    public String getLocationName(Double lat, Double lng){

        String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng="
                + lat + "," + lng + "&key=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();

        try{
            Map response = restTemplate.getForObject(url, Map.class);

            var results = (java.util.List) response.get("results");

            if(results != null && !results.isEmpty()){
                Map first = (Map) results.get(0);

                return first.get("formatted_address").toString();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return "Unknown Location";
    }
}
