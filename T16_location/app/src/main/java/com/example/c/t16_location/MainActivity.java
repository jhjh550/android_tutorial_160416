package com.example.c.t16_location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Geocoder geocoder = new Geocoder(this);

        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        final TextView textView = (TextView) findViewById(R.id.textView);

        String str = "";
        List<String> providers = manager.getAllProviders();
        for (int i = 0; i < providers.size(); i++) {
            str += "provider : " + providers.get(i) + " state : " +
                    manager.isProviderEnabled(providers.get(i)) + "\n";
        }
        textView.setText(str);

        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                String s = "lat : " + location.getLatitude() + " lon : " + location.getLongitude() +
                        " alt : " + location.getAltitude() + "\n";

                try {
                    List<Address> list =
                            geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 10);
                    Address address = list.get(0);
                    s += address.toString();

                } catch (IOException e) {
                    e.printStackTrace();
                }


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
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
        }
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
//        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,listener);
        manager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER,0,0,listener);

    }
}
