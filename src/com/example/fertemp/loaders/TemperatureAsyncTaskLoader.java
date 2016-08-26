package com.example.fertemp.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class TemperatureAsyncTaskLoader extends AsyncTaskLoader<String[]> {

	public TemperatureAsyncTaskLoader(Context context) {
		super(context);
	}

	@Override
	public String[] loadInBackground() {
		String[] mockTemp = new String[] {"1", "2","3" };
		return mockTemp;
	}

}
