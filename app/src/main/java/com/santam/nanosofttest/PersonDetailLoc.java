package com.santam.nanosofttest;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;


public class PersonDetailLoc extends    android.app.Fragment implements  OnMapReadyCallback {
    private static final String TAG = "Person Detail";
    public static View root;
    SqLiteDBHelper mDBHelper;
    private GoogleMap mGoogleMap ;
    MapView mapView;
    public static String id,Name;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root= inflater.inflate(R.layout.fragment_person_loc, container, false);


        mDBHelper = new SqLiteDBHelper(root.getContext());
        Bundle args = getArguments();
        id = args.getString("id");
        Name = args.getString("name");

        mapView = ((MapView) root.findViewById(R.id.mapid));
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
//        googleMap = mapView.getMapAsync(root.getContext());



        return root;
    }



    private void fillData(String id, String name) {

        Log.d(TAG, "viewData: Displaying Persons...");
        String latitude="", longitude="";
        Cursor data = mDBHelper.forGetLocation(id);

        while(data.moveToNext()){

            latitude = data.getString(0);
            longitude = data.getString(1);

        }

        mGoogleMap.addMarker(new MarkerOptions().position(new LatLng( Double.parseDouble(latitude), (Double.parseDouble(longitude)))));

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(new MarkerOptions().position(new LatLng( Double.parseDouble(latitude), (Double.parseDouble(longitude)))).getPosition());
        LatLngBounds bounds = builder.build();


        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (width * 0.10); // offset from edges of the map 10% of screen

        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);

        mGoogleMap.animateCamera(cu);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        if (mGoogleMap != null) {
            fillData(id,Name);
            // Add your functions to GoogleMap
        }
    }
}
