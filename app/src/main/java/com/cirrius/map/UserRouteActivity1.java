package com.cirrius.map;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import com.cirrius.iclmcipla.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class UserRouteActivity1 extends Activity {

	// static double userLat = 19.1190;
	// static double userLong = 72.8470;

	static String latitude = "19.1190";
	static String longitude = "72.8470";

	//
	// static double userLat = Double.parseDouble(Launcher.latitude);
	// static double userLong = Double.parseDouble(Launcher.longitude);
	static double userLat = Double.parseDouble(latitude);
	static double userLong = Double.parseDouble(longitude);

	static LatLng MUMBAI = null;
	LatLng LOCATION = null;

	Document document;
	MarkerOptions markerOptions;
	GmapV2GetRouteDirection v2GetRouteDirection;
	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		System.out.println("GEOGRAPHY =" + userLat);
		System.out.println("GEOGRAPHY =" + userLong);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapactivity);
		Bundle extras = getIntent().getExtras();
//		GpsTrac gpstrac = new GpsTrac(this);
		// DBHandler rw = DBHandler.getInstance(UserRouteActivity.this);

		

		MUMBAI = new LatLng(Double.parseDouble(latitude),
				Double.parseDouble(longitude));
		// String address = extras.getString("address");
		String address = "414003";
		Double[] g = getLocationFromAddress(address + ",India");

		if (g != null) {
			Double lat = g[0];
			Double lang = g[1];
			LOCATION = new LatLng(lat, lang);
			v2GetRouteDirection = new GmapV2GetRouteDirection();

			map = ((MapFragment) getFragmentManager()
					.findFragmentById(R.id.map)).getMap();
			// MapView map = (MapView)findViewById(R.id.map);
			//

			map.setMyLocationEnabled(true);
			map.getUiSettings().setZoomControlsEnabled(true);
			map.getUiSettings().setCompassEnabled(true);
			map.getUiSettings().setMyLocationButtonEnabled(false);
			map.getUiSettings().setAllGesturesEnabled(true);
			map.setTrafficEnabled(true);
			markerOptions = new MarkerOptions();

			// Move the camera instantly to hamburg with a zoom of 15.
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(LOCATION, 15));

			// Zoom in, animating the camera.
			map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
			GetRouteTask getRoute = new GetRouteTask();
			getRoute.execute();
		} else {
			AlertDialog.Builder alertbox = new AlertDialog.Builder(
					UserRouteActivity1.this);
			alertbox.setMessage("No Network").setPositiveButton("OK",
					new OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							finish();
							dialog.cancel();

						}
					});
			alertbox.create();
			alertbox.show();
		}
	}

	private class GetRouteTask extends AsyncTask<String, Void, String> {

		private ProgressDialog Dialog;
		String response = "";

		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(UserRouteActivity1.this);
			Dialog.setMessage("Loading route...");
			Dialog.show();
		}

		@Override
		protected String doInBackground(String... urls) {
			// Get All Route values
			document = v2GetRouteDirection.getDocument(MUMBAI, LOCATION,
					GmapV2GetRouteDirection.MODE_DRIVING);
			response = "Success";
			return response;

		}

		@Override
		protected void onPostExecute(String result) {
			map.clear();
			if (response.equalsIgnoreCase("Success")) {
				ArrayList<LatLng> directionPoint = v2GetRouteDirection
						.getDirection(document);
				PolylineOptions rectLine = new PolylineOptions().width(10)
						.color(Color.RED);

				MarkerOptions markerOptions1 = new MarkerOptions();

				for (int i = 0; i < directionPoint.size(); i++) {
					rectLine.add(directionPoint.get(i));
				}
				// Adding route on the map
				map.addPolyline(rectLine);
				markerOptions.position(LOCATION);
				markerOptions.draggable(false);
				map.addMarker(markerOptions);
				markerOptions1.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
				markerOptions1.position(MUMBAI);
				map.addMarker(markerOptions1);

			}

			Dialog.dismiss();
		}
	}

	public Double[] getLocationFromAddress(String strAddress) {

		// Geocoder coder = new Geocoder(this, Locale.getDefault());
		Geocoder cd = new Geocoder(UserRouteActivity1.this);

		List<Address> address;
		Double str[] = null;

		try {
			// address = coder.getFromLocationName("mumbai", 5);
			address = cd.getFromLocationName(strAddress, 5);
			if (address == null) {
				return null;
			}
			Address location = address.get(0);
			location.getLatitude();
			location.getLongitude();
			Double str1[] = { location.getLatitude(), location.getLongitude() };

			// p1 = new GeoPoint((int) (location.getLatitude() * 1E6),
			// (int) (location.getLongitude() * 1E6));

			return str1;
		} catch (Exception e) {
			System.out.println("Exception" + e);
		}
		return str;
	}
}
