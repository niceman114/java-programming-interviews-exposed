package com.wiley.acinginterview.location;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.wiley.acinginterview.R;

public class LocationActivity extends Activity implements
        GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener, LocationListener
{
    private static final String TAG = "LocationActivity";

    // A request to connect to Location Services
    private LocationRequest mLocationRequest;

    // Stores the current instantiation of the location client in this object
    private LocationClient mLocationClient;
    
    private TextView locationLog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locations);
        
        locationLog = (TextView)findViewById(R.id.tv_location_log);
        createLocationRequest();
    }

    private void createLocationRequest()
    {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setFastestInterval(1000);

        mLocationClient = new LocationClient(this, this, this);
    }
    
    //control connecting and disconnecting during visible time
    //of the activity

    @Override
    public void onStop() {

        if (mLocationClient.isConnected()) 
        {
            stopPeriodicUpdates();
        }
        mLocationClient.disconnect();

        super.onStop();
    }

    @Override
    public void onStart() 
    {
        mLocationClient.connect();
        super.onStart();
    }

    @Override
    public void onConnected(Bundle bundle)
    {
        final int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        // If Google Play services is available
        if (ConnectionResult.SUCCESS == resultCode)
        {
            startPeriodicUpdates();
        } else
        {
            Log.e(TAG, "cannot connect to location services");
        }
    }

    private void startPeriodicUpdates()
    {
        mLocationClient.requestLocationUpdates(mLocationRequest, this);
    }

    public void stopPeriodicUpdates()
    {
        mLocationClient.removeLocationUpdates(this);
    }

    @Override
    public void onDisconnected()
    {
        Log.e(TAG, "disconnected");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult)
    {
        Log.e(TAG, "failed to connect");
    }

    @Override
    public void onLocationChanged(Location loc)
    {
        Log.d(TAG, "LOCATION UPDATE");
        final String summary = loc.getLatitude() + ", " + loc.getLongitude() + " "
                + loc.getAccuracy();
        locationLog.setText(summary);
    }
}
