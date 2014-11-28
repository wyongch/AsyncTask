package com.example.asynctask;

import java.io.IOException;
import java.net.URL;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	ImageView mImageView ;
	Button button ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

		
		mImageView = (ImageView)findViewById(R.id.imageview1) ;
		button=(Button)findViewById(R.id.button1) ;
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new DownloadImageTask().execute("http://img0.bdstatic.com/img/image/6446027056db8afa73b23eaf953dadde1410240902.jpg") ;
			}
		});
//		button.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
////				new DownloadImageTask().execute("http://img0.bdstatic.com/img/image/6446027056db8afa73b23eaf953dadde1410240902.jpg") ;
//			}
//		}); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
//			rootView.findViewById(R.id.button1) ;
			return rootView;
		}
	}
	
	public class DownloadImageTask extends AsyncTask<String, Void, Drawable> {

		@Override
		protected Drawable doInBackground(String... urls) {
			// TODO Auto-generated method stub
			return loadImageFromNetwork(urls[0]);
		}
		
		private Drawable loadImageFromNetwork(String imageUrl) {
			// TODO Auto-generated method stub
			Drawable drawable = null;  
		    try {  
		        // 可以在这里通过文件名来判断，是否本地有此图片  
		        drawable = Drawable.createFromStream(  
		                new URL(imageUrl).openStream(), "image.jpg");  
		    } catch (IOException e) {  
		        Log.d("test", e.getMessage());  
		    }  
		    if (drawable == null) {  
		        Log.d("test", "null drawable");  
		    } else {  
		        Log.d("test", "not null drawable");  
		    }  
		      
		    return drawable ;  
		}

		protected void onPostExecute(Drawable result){
			 mImageView.setImageDrawable(result);
		}
		
	}

}
