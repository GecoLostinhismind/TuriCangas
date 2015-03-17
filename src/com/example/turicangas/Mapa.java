package com.example.turicangas;

//Activity que maneja el comportamiento del mapa. 

import com.google.android.gms.maps.GoogleMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Mapa  extends Activity{
	
	private GoogleMap googleMap;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);
		
	initilizeMap();
	
	//Añdadí estos markers de manera manual para comprobar que funcionaban. Lo perfecto sería que un metodo situe un marker en cada ubicación segun el
	//item(lugar) que se haya seleccionado en la ActivityPrincipal, no se si eso es posible...
	
	//La ubicaciónes son reales y son las definitivas
	MarkerOptions markerPuente = new MarkerOptions().position(new LatLng(43.350155,-5.131990)).title("Puente Romano");
	googleMap.addMarker(markerPuente);
	
	MarkerOptions markerErmita = new MarkerOptions().position(new LatLng(43.352665, -5.130273)).title("Ermita de la Cruz");
	googleMap.addMarker(markerErmita);
	
	MarkerOptions markerDolmen = new MarkerOptions().position(new LatLng(43.352666, -5.130388)).title("Dolmen");
	googleMap.addMarker(markerDolmen);
	
	MarkerOptions markerParroq = new MarkerOptions().position(new LatLng(43.350683, -5.127166)).title("Iglesia Parroquial");
	googleMap.addMarker(markerParroq);
	
	MarkerOptions markerPelayo = new MarkerOptions().position(new LatLng(43.350895, -5.126334)).title("Estatua de Don Pelayo");
	googleMap.addMarker(markerPelayo);
	
	MarkerOptions markerAula = new MarkerOptions().position(new LatLng(43.350723, -5.130297)).title("Aula del Reino de Asturias");
	googleMap.addMarker(markerAula);
	
	MarkerOptions markerCapilla = new MarkerOptions().position(new LatLng(43.348593, -5.125287)).title("Capilla de San Antonio");
	googleMap.addMarker(markerCapilla);
	
	MarkerOptions markerPintu = new MarkerOptions().position(new LatLng(43.350648, -5.126478)).title("Palacio Pintu");
	googleMap.addMarker(markerPintu);
	
	MarkerOptions markerPlaza = new MarkerOptions().position(new LatLng(43.350615, -5.126276)).title("Plaza del mercado");
	googleMap.addMarker(markerPlaza);
	
	MarkerOptions markerDago = new MarkerOptions().position(new LatLng(43.350954, -5.125379)).title("Casa Dago");
	googleMap.addMarker(markerDago);
		
	}
	
	
	private void initilizeMap() {
      if (googleMap == null) {
          googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

          // check if map is created successfully or not
          if (googleMap == null) {
              Toast.makeText(getApplicationContext(),
                      "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                      .show();
          }
      }
      
      
	}
	
	@Override
  protected void onResume() {
      super.onResume();
      initilizeMap();
  }

}
