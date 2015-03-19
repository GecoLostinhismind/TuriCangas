package com.example.turicangas;

//Activity que maneja el comportamiento del mapa. 

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Mapa  extends FragmentActivity{
	
	private GoogleMap googleMap;
	private String name;
	private String lat;
	private String lng;
	private PlacesDbAdapter dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);
		
		//dbHelper = new PlacesDbAdapter(this);
		
		//prueba para usar las LatLng de la base de datos, no rula.
		//Bundle extras = getIntent().getExtras();
		//name = extras.getString("name");
		//lat = extras.getString("lat");
		//lng = extras.getString("lng");
		//Double latfinal = Double.parseDouble(lat);
		//Double lngfinal = Double.parseDouble(lng);
		
		
		//LatLng toPosition = new LatLng(lat, lng); 
		
		//Initialize map
		FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment =  (SupportMapFragment)
            fragmentManager.findFragmentById(R.id.map);
        googleMap = mapFragment.getMap();
        
        //marker de prueba...
        //MarkerOptions markerPuente = new MarkerOptions().position(new LatLng(latfinal,lngfinal)).title(name);
    	//googleMap.addMarker(markerPuente);	
    	
    	//animation to marker (prueba)   	
    	//CameraPosition cameraPosition = new CameraPosition.Builder().target( new LatLng(latfinal, lngfinal)).zoom(15).build();
    	//googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        
    	//dbHelper.getPlaces();
    	
        //Markers
        //MarkerOptions markerPuente = new MarkerOptions().position(new LatLng(43.350155,-5.131990)).title("Puente Romano");
    	//googleMap.addMarker(markerPuente);	

    	//MarkerOptions markerErmita = new MarkerOptions().position(new LatLng(43.352665, -5.130273)).title("Ermita de la Cruz");
    	//googleMap.addMarker(markerErmita);
    	
    	//MarkerOptions markerDolmen = new MarkerOptions().position(new LatLng(43.352666, -5.130388)).title("Dolmen");
    	//googleMap.addMarker(markerDolmen);
    	
    	//MarkerOptions markerParroq = new MarkerOptions().position(new LatLng(43.350683, -5.127166)).title("Iglesia Parroquial");
    	//googleMap.addMarker(markerParroq);
    	
    	//MarkerOptions markerPelayo = new MarkerOptions().position(new LatLng(43.350895, -5.126334)).title("Estatua de Don Pelayo");
    	//googleMap.addMarker(markerPelayo);
    	
    	//MarkerOptions markerAula = new MarkerOptions().position(new LatLng(43.350723, -5.130297)).title("Aula del Reino de Asturias");
    	//googleMap.addMarker(markerAula);
    	
    	//MarkerOptions markerCapilla = new MarkerOptions().position(new LatLng(43.348593, -5.125287)).title("Capilla de San Antonio");
    	//googleMap.addMarker(markerCapilla);
    	
    	//MarkerOptions markerPintu = new MarkerOptions().position(new LatLng(43.350648, -5.126478)).title("Palacio Pintu");
    	//googleMap.addMarker(markerPintu);
    	
    	//MarkerOptions markerPlaza = new MarkerOptions().position(new LatLng(43.350615, -5.126276)).title("Plaza del mercado");
    	//googleMap.addMarker(markerPlaza);
    	
    	//MarkerOptions markerDago = new MarkerOptions().position(new LatLng(43.350954, -5.125379)).title("Casa Dago");
    	//googleMap.addMarker(markerDago);
    	
    	
    	//animation to marker
    	//CameraPosition cameraPosition = new CameraPosition.Builder().target( new LatLng(43.350155,-5.131990)).zoom(15).build();
    	//googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	
		
		

		
	//initilizeMap();
	
	//Añdadí estos markers de manera manual para comprobar que funcionaban. Lo perfecto sería que un metodo situe un marker en cada ubicación segun el
	//item(lugar) que se haya seleccionado en la ActivityPrincipal, no se si eso es posible...
	
	//La ubicaciónes son reales y son las definitivas
	
	
	
	
		
	}
	
	
	//private void initilizeMap() {
      //if (googleMap == null) {
        //  googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

          // check if map is created successfully or not
          //if (googleMap == null) {
            //  Toast.makeText(getApplicationContext(),
                     // "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                      //.show();
          //}
      //}
      
      
	//}
	
	//@Override
  //protected void onResume() {
     // super.onResume();
      //initilizeMap();
  //}

}
