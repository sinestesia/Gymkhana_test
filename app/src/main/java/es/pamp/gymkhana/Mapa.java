package es.pamp.gymkhana;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker mInicio;
    private CameraUpdate campUp1;
    private LatLng posicionInicio;
    private LocationListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Marker https://developers.google.com/maps/documentation/android-api/marker?hl=es-419
        posicionInicio = new LatLng(40.4095457,-3.6914855);
        mInicio = mMap.addMarker(new MarkerOptions()
                .position(posicionInicio)
                .title("Inicio")
                .snippet("texto snippet")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icontest))
        );
        mInicio.setTag(0);
        campUp1 = CameraUpdateFactory.newLatLngZoom(posicionInicio, (float)17);
        mMap.moveCamera(campUp1);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            //TODO Error no encuentra el permiso
            mMap.setMyLocationEnabled(true);



        } else {
            // Show rationale and request permission.
            //TODO Solicitar petición de permisos si no se dispone de ellos
            // http://stackoverflow.com/questions/35484767/activitycompat-requestpermissions-not-showing-dialog-box
            // https://github.com/googlemaps/android-samples/blob/master/ApiDemos/app/src/main/java/com/example/mapdemo/MyLocationDemoActivity.java
        }


    }


    /** Se llama al hacer click en un marcador */
    @Override
    public boolean onMarkerClick(final Marker marker) {

        // Recupera la información del marcador
        Integer marcadorId = (Integer) marker.getTag();

        switch (marcadorId){
            case 0:

                //TODO realizar acción al clicar en el marcador 0
                Toast.makeText(this, "Has clicado en: " + marker.getTitle() , Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }


        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }

}

