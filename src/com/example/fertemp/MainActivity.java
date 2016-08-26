package com.example.fertemp;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fertemp.loaders.TemperatureAsyncTaskLoader;

public class MainActivity extends ActionBarActivity implements LoaderCallbacks<String[]>{
	
	private TextView textView;
	private EditText editText;
	private Button button;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView = (TextView)findViewById(R.id.moj_textview);
        editText = (EditText)findViewById(R.id.moj_edit_text);
        button = (Button)findViewById(R.id.moj_btn);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	protected void onStart() {
		super.onStart();
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, 
						"Kliknuosi na gumb: " + editText.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		
		getSupportLoaderManager().initLoader(0, null, this).forceLoad();
	}

	@Override
	public Loader<String[]> onCreateLoader(int arg0, Bundle arg1) {
		TemperatureAsyncTaskLoader loader = new TemperatureAsyncTaskLoader(this);
		return loader;
	}

	@Override
	public void onLoadFinished(Loader<String[]> arg0, String[] arg1) {
		Toast.makeText(MainActivity.this, 
				"Loader je zavrsio " + arg1[2], Toast.LENGTH_SHORT).show();
		textView.setText(arg1[0]);
		
	}

	@Override
	public void onLoaderReset(Loader<String[]> arg0) {
	}
    
    
}
