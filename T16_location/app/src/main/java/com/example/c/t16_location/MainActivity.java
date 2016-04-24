package com.example.c.t16_location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        final TextView textView = (TextView) findViewById(R.id.textView);

        String str="";
        List<String> providers = manager.getAllProviders();
        for(int i=0;i<providers.size(); i++){
            str += "provider : "+providers.get(i)+" state : "+
                    manager.isProviderEnabled(providers.get(i))+"\n";
        }
        textView.setText(str);

        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                String s = "lat : "+location.getLatitude()+" lon : "+location.getLongitude()+
                        " alt : "+location.getAltitude()+"\n";
                textView.append(s);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

    }
}
