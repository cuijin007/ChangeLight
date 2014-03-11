package ChangeLight.com;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.provider.Settings;

public class LightService extends Service {

	private SensorManager sensorManager;   
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		this.sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);  
		this.sensorManager.registerListener(this.myAccelerometerListener, this.sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
		System.out.println("create-service");
	}

	 final SensorEventListener myAccelerometerListener = new SensorEventListener(){

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 188);
			float x,y,z;
			x=event.values[0];
			y=event.values[1];
			z=event.values[2];
			System.out.println("x,y,z"+x+","+y+","+z);
			if((x*x+y*y+z*z)>5)
			{
				Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 255);
			}
		} 
         
	    
	    };  
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}



class LightControlThread extends Thread
{

	 private SensorManager sensorManager;   
	 public LightControlThread()
	 {
	//	 this.sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);  
	 }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	
}
