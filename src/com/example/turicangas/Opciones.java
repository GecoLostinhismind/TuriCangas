package com.example.turicangas;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Opciones extends ActionBarActivity {
	
	private static final int CODE_CAMERA = 0;
	private static final String SRC="/sdcard/TuriCangas/images/";
	private String fileSrc;
	private TextView nameView;
	private Button CameraButton;
	private Button GalButton;
	private Button mapButton;
	private Button ArButton;
	private String name;
	private String lat;
	private String lng;
	private PlacesDbAdapter dbHelper;
	private String src;
	private File folder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.opciones);
		
		dbHelper = new PlacesDbAdapter(this);
		
		nameView = (TextView) findViewById(R.id.Text2);
		CameraButton = (Button) findViewById(R.id.Camara);
		GalButton = (Button) findViewById(R.id.Galeria);
		mapButton = (Button) findViewById(R.id.Mapa);
		ArButton = (Button) findViewById(R.id.AR);
		
		Bundle extras = getIntent().getExtras();
		name = extras.getString("name");
		lat = extras.getString("lat");
		lng = extras.getString("lng");
		
		
		nameView.setText(name);
		
		
		
		
		
		
		CameraButton.setOnClickListener(new OnClickListener() {
	 
	            @Override
	            public void onClick(View view) {
	           

	            	File folder = new File(SRC);
	            	if (!folder.exists())
	            		folder.mkdirs();
	            	
	            	
	            	String file_name = new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
	            	file_name =  file_name + ".jpg";
	            	
	            	fileSrc = file_name;
	            
	            	
	            	File file = new File(folder, fileSrc);
	                Uri outputFileUri = Uri.fromFile( file );
	                
	                	
	                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE );
	                intent.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );
	                	
	                startActivityForResult( intent, CODE_CAMERA );
	            }
	 
	        });
		
		GalButton.setOnClickListener(new OnClickListener() {
			 
            @Override
            public void onClick(View view) {
           
            	
            	Bundle extras = new Bundle();
	        	extras.putString("name",name);
	        	extras.putString("src", SRC);
	        	
	        	Intent intent = new Intent(Opciones.this, Galeria.class);
	        	intent.putExtras(extras);
	    		startActivity(intent);
            }
 
        });
		
		
		mapButton.setOnClickListener(new OnClickListener() {
			 
            @Override
            public void onClick(View view) {
           
            	
            	//Bundle extras = new Bundle();
	        	//extras.putString("name",name);
	        	//extras.putString("Lat", lat);
	        	//extras.putString("Lng", lng);
	        	
	        	Intent intent = new Intent(Opciones.this, Mapa.class);
	        	//intent.putExtras(extras);
	    		startActivity(intent);
            }
 
        });
		
		
		
		
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

	
		if ((requestCode == CODE_CAMERA )){
			if(resultCode == Activity.RESULT_OK){
			
		    	
		        dbHelper.insertPic(name, fileSrc);        
			}
	    }
		
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prueba, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
