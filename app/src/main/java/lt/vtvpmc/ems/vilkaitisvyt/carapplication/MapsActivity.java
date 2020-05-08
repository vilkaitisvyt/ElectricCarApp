package lt.vtvpmc.ems.vilkaitisvyt.carapplication;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<Car> carData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    //  Adds a marker for each car and moves camera to the last one

        carData = (ArrayList)getIntent().getSerializableExtra("lt.vtvpmc.ems.vilkaitisvyt.carapplication.CARS");

        LatLng carLocation = null;

        if (carData != null && !carData.isEmpty()) {
            for (Car car: carData) {
                carLocation = new LatLng(car.getLocation().getLatitude(), car.getLocation().getLongitude());
                mMap.addMarker(new MarkerOptions().position(carLocation).title(car.getModel().getTitle()));
            }
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(carLocation, 12.0f));
        }
    }
}
