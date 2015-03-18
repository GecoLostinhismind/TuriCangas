package com.example.turicangas;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class Galeria extends Activity {
	
	private Cursor cursor; 
	private int columnIndex;
	private TextView nameView;
	private GridView grid;
	private String name;
	private List<String> picList;
	private PlacesDbAdapter dbHelper;
	private ImageAdapter myImageAdapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.galeria);
		
		dbHelper = new PlacesDbAdapter(this);
		picList = new ArrayList<String>();
		
		Bundle extras = getIntent().getExtras();
		name = extras.getString("name");
		String src = extras.getString("src");

		nameView = (TextView) findViewById(R.id.Text3);
		nameView.setText(name);
		
		grid = (GridView) findViewById(R.id.gridview);
		myImageAdapter = new ImageAdapter(this);
		grid.setAdapter(myImageAdapter);
		
		picList = dbHelper.getPics(name);
		
		if(picList.contains("null"))
			picList.remove("null");
		
		for(int i=0;i<picList.size();i++){
	
			String path = src+picList.get(i);
			myImageAdapter.add(path);
		}
		
		
		grid.setOnItemClickListener(new OnItemClickListener(){

			  @Override
			  public void onItemClick(AdapterView<?> parent, View view, int position,
			    long id) {
				  
				 
				  //IMplementar Código para que cargue la imagen en grande en nueva Activity
				  
				
			   
			  }

			});


	
	}
	
    public class ImageAdapter extends BaseAdapter {
        
        private Context mContext;
        ArrayList<String> itemList = new ArrayList<String>();
        
        public ImageAdapter(Context c) {
         mContext = c; 
        }
        
        void add(String path){
         itemList.add(path); 
        }

     @Override
     public int getCount() {
      return itemList.size();
     }

     @Override
     public Object getItem(int arg0) {
      // TODO Auto-generated method stub
      return null;
     }

     @Override
     public long getItemId(int position) {
      // TODO Auto-generated method stub
      return 0;
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
      ImageView imageView;
            if (convertView == null) {  // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(220, 220));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            Bitmap bm = decodeSampledBitmapFromUri(itemList.get(position), 220, 220);

            imageView.setImageBitmap(bm);
            return imageView;
     }
     
     public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) {
      
      Bitmap bm = null;
      // First decode with inJustDecodeBounds=true to check dimensions
      final BitmapFactory.Options options = new BitmapFactory.Options();
      options.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(path, options);
          
      // Calculate inSampleSize
      options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
          
      // Decode bitmap with inSampleSize set
      options.inJustDecodeBounds = false;
      bm = BitmapFactory.decodeFile(path, options); 
          
      return bm;   
     }
     
     public int calculateInSampleSize(
       
      BitmapFactory.Options options, int reqWidth, int reqHeight) {
      // Raw height and width of image
      final int height = options.outHeight;
      final int width = options.outWidth;
      int inSampleSize = 1;
      
      if (height > reqHeight || width > reqWidth) {
       if (width > height) {
        inSampleSize = Math.round((float)height / (float)reqHeight);    
       } else {
        inSampleSize = Math.round((float)width / (float)reqWidth);    
       }   
      }
      
      return inSampleSize;    
     }

    }
		

}
