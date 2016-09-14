package course.labs.activitylab;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";


		// lifecycle counts
		//TODO:
		//Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
		// You will need to increment these variables' values when their corresponding lifecycle methods get called.
		private TextView onCreateDisplay;
	private int onCreateCounter = 0;

	private TextView onStartDisplay;
	private int onStartCounter = 0;

	private TextView onResumeDisplay;
	private int onResumeCounter = 0;

	private TextView onStopDisplay;
	private int onStopCounter = 0;

	private TextView onDestroyDisplay;
	private int onDestroyCounter = 0;

	private TextView onPauseDisplay;
	private int onPauseCounter = 0;

	private TextView onRestartDisplay;
	private int onRestartCounter = 0;

	private SharedPreferences prefs;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);

			prefs = getPreferences(MODE_PRIVATE);

			onCreateCounter = prefs.getInt("createCount", 0);
			if (onCreateCounter != 0) {
				onPauseCounter = prefs.getInt("pauseCount", 0);
				onResumeCounter = prefs.getInt("resumeCount", 0);
				onDestroyCounter = prefs.getInt("destroyCount", 0);
				onRestartCounter = prefs.getInt("restartCount", 0);
				onStopCounter = prefs.getInt("stopCount", 0);
				onStartCounter = prefs.getInt("startCount", 0);
				displayCounters();
			}
			else
			onCreateCounter++;

			//Log cat print out
			Log.i(TAG, "onCreate called");

			onCreateDisplay = (TextView) findViewById(R.id.create);
			onCreateDisplay.setText(getString(R.string.onCreate) + onCreateCounter);
			//TODO:
			//update the appropriate count variable
			//update the view
		}



		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}

		// lifecycle callback overrides

		@Override
		public void onStart(){
			super.onStart();
			onStartCounter++;


			//Log cat print out
			Log.i(TAG, "onStart called");

			onStartDisplay = (TextView) findViewById(R.id.start);
			onStartDisplay.setText(getString(R.string.onStart) + onStartCounter);
			//TODO:
			//update the appropriate count variable
			//update the view
		}

		@Override
	public void onResume(){
		super.onResume();
		onResumeCounter++;
			displayCounters();

		//Log cat print out
		Log.i(TAG, "onStart called");

		onResumeDisplay = (TextView) findViewById(R.id.resume);
		onResumeDisplay.setText(getString(R.string.onResume) + onResumeCounter);
		//TODO:
		//update the appropriate count variable
		//update the view
	}

	@Override
	public void onStop(){
		super.onStop();
		onStopCounter++;

		//Log cat print out
		Log.i(TAG, "onStart called");

		onStopDisplay = (TextView) findViewById(R.id.stop);
		onStopDisplay.setText(getString(R.string.onStop) + onStopCounter);
		//TODO:
		//update the appropriate count variable
		//update the view
	}

	@Override
	public void onDestroy(){
		super.onDestroy();
		onDestroyCounter++;

		//Log cat print out
		Log.i(TAG, "onStart called");

		onDestroyDisplay = (TextView) findViewById(R.id.destroy);
		onDestroyDisplay.setText(getString(R.string.onDestroy) + onDestroyCounter);
		//TODO:
		//update the appropriate count variable
		//update the view
	}

	@Override
	public void onPause(){
		super.onPause();
		onPauseCounter++;

		//Log cat print out
		Log.i(TAG, "onStart called");

		onPauseDisplay = (TextView) findViewById(R.id.pause);
		onPauseDisplay.setText(getString(R.string.onPause) + onPauseCounter);
		//TODO:
		//update the appropriate count variable
		//update the view
	}

	@Override
	public void onRestart(){
		super.onRestart();
		onRestartCounter++;

		//Log cat print out
		Log.i(TAG, "onStart called");

		onRestartDisplay = (TextView) findViewById(R.id.restart);
		onRestartDisplay.setText(getString(R.string.onRestart) + onRestartCounter);
		//TODO:
		//update the appropriate count variable
		//update the view
	}

	    // TODO: implement 5 missing lifecycle callback methods

		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){

			savedInstanceState.putInt("createCount", onCreateCounter);
			savedInstanceState.putInt("startCount", onStartCounter);
			savedInstanceState.putInt("resumeCount", onResumeCounter);
			savedInstanceState.putInt("pauseCount", onPauseCounter);
			savedInstanceState.putInt("stopCount", onStopCounter);
			savedInstanceState.putInt("restartCount", onRestartCounter);
			savedInstanceState.putInt("destroyCount", onDestroyCounter);
			saveUserInfo();
			//TODO:
			// save state information with a collection of key-value pairs
			// save all  count variables
		}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState){

		onCreateCounter = savedInstanceState.getInt("createCount");
		onStartCounter = savedInstanceState.getInt("startCount");
		onResumeCounter = savedInstanceState.getInt("resumeCount");
		onPauseCounter = savedInstanceState.getInt("pauseCount");
		onStopCounter = savedInstanceState.getInt("stopCount");
		onRestartCounter = savedInstanceState.getInt("restartCount");
		onDestroyCounter = savedInstanceState.getInt("destroyCount") + 1;
		//TODO:
		// save state information with a collection of key-value pairs
		// save all  count variables
	}
		public void launchActivityTwo(View view) {
			Intent activity2 = new Intent(this, ActivityTwo.class);
			startActivity(activity2);
			//TODO:
			// This function launches Activity Two.
			// Hint: use Context’s startActivity() method.
		}
		public void displayCounters(){
		onCreateDisplay = (TextView) findViewById(R.id.create);
		onCreateDisplay.setText(getString(R.string.onCreate) + onCreateCounter);
		onPauseDisplay = (TextView) findViewById(R.id.pause);
		onPauseDisplay.setText(getString(R.string.onPause) + onPauseCounter);
		onStartDisplay = (TextView) findViewById(R.id.start);
		onStartDisplay.setText(getString(R.string.onStart) + onStartCounter);
		onStopDisplay = (TextView) findViewById(R.id.stop);
		onStopDisplay.setText(getString(R.string.onStop) + onStopCounter);
		onResumeDisplay = (TextView) findViewById(R.id.resume);
		onResumeDisplay.setText(getString(R.string.onResume) + onResumeCounter);
		onRestartDisplay = (TextView) findViewById(R.id.restart);
		onRestartDisplay.setText(getString(R.string.onRestart) + onRestartCounter);
		onDestroyDisplay = (TextView) findViewById(R.id.destroy);
		onDestroyDisplay.setText(getString(R.string.onDestroy) + onDestroyCounter);
	}

	public void saveUserInfo() {

		int createCounter = onCreateCounter;
		int startCounter = onStartCounter;
		int resumeCounter = onResumeCounter;
		int pauseCounter = onPauseCounter;
		int stopCounter = onStopCounter;
		int restartCounter = onRestartCounter;
		int destroyCounter = onDestroyCounter;

		SharedPreferences.Editor editor = prefs.edit();

		editor.putInt("createCount", createCounter);
		editor.putInt("startCount", startCounter);
		editor.putInt("resumeCount", resumeCounter);
		editor.putInt("pauseCount", pauseCounter);
		editor.putInt("stopCount", stopCounter);
		editor.putInt("restartCount", restartCounter);
		editor.putInt("destroyCount", destroyCounter);

		editor.commit();
	}


}
