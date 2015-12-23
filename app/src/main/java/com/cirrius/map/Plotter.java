//package com.example.mapview;
//
//import java.util.ArrayList;
//
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.graphics.Color;
//import android.os.AsyncTask;
//import android.provider.DocumentsContract.Document;
//
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.PolylineOptions;
//
//public class Plotter {
//	LatLng location1,location2;
//	Context context;
//	Document document;
//	GmapV2GetRouteDirection v2GetRouteDirection=new GmapV2GetRouteDirection();
//public Plotter(LatLng location1,LatLng location2,Context context) {
//	this.location1=location1;
//	this.location2=location2;
//	this.context=context;
//	
//	
//	// TODO Auto-generated constructor stub
//}
//
//private class GetRouteTask extends AsyncTask<String, Void, String> {
//
//	private ProgressDialog Dialog;
//	String response = "";
//
//	@Override
//	protected void onPreExecute() {
//		Dialog = new ProgressDialog(context);
//		Dialog.setMessage("Loading route...");
//		Dialog.show();
//	}
//
//	@Override
//	protected String doInBackground(String... urls) {
//		
////		for (int i = 0; i < latlongarr.length-1; i++) {
////			Double lat1 = Double.parseDouble(latlongarr[0][0]);
////			Double lang1  =Double.parseDouble(latlongarr[0][1]);
////			String city1=latlongarr[0][2];
////			
////			Double lat2 = Double.parseDouble(latlongarr[0+1][0]);
////			Double lang2 =Double.parseDouble(latlongarr[0+1][1]);
////			String city2=latlongarr[0+1][2];
////			
////			LOCATION = new LatLng(lat1, lang1);
////			LOCATION1 = new LatLng(lat2, lang2);
//			
//			// drawMarker(new LatLng(lat1,  lang1),city1); 
//			 //drawMarker(new LatLng(lat2,  lang2),city2); 
//			 document = v2GetRouteDirection.getDocument(location1,location1 ,
//						GmapV2GetRouteDirection.MODE_DRIVING);
//			 
//	//	}
//		
//	//LO/CATION = new LatLng(15.6, 73.95);
//		// Get All Route values
//		
//		response = "Success";
//		return response;
//
//	}
//
//	@Override
//	protected void onPostExecute(String result) {
//		map.clear();
//		if (response.equalsIgnoreCase("Success")) {
//			ArrayList<LatLng> directionPoint = v2GetRouteDirection
//					.getDirection(document);
//			PolylineOptions rectLine = new PolylineOptions().width(10)
//					.color(Color.RED);
//
//			for (int i = 0; i < directionPoint.size(); i++) {
//				rectLine.add(directionPoint.get(i));
//			}
//			// Adding route on the map
//			map.addPolyline(rectLine);
//			markerOptions.position(LOCATION);
//			markerOptions.draggable(false);
//			map.addMarker(markerOptions);
//			markerOptions.position(MUMBAI);
//			map.addMarker(markerOptions);
//
//		}
//
//		Dialog.dismiss();
//	}
//}
//
//}
