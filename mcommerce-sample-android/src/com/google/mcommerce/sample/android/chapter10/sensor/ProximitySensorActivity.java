package com.google.mcommerce.sample.android.chapter10.sensor;

import com.google.mcommerce.sample.android.R;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class ProximitySensorActivity extends Activity implements SensorEventListener {
    private SensorManager mgr;
    private Sensor proximity;
    private TextView text;
    private StringBuilder msg = new StringBuilder(2048);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c10_sensor_proximity_layout);

        mgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);

        proximity = mgr.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        
        text = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void onResume() {
        mgr.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
    	super.onResume();
    }

    @Override
    protected void onPause() {
        mgr.unregisterListener(this, proximity);
    	super.onPause();
    }

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// ignore
	}

	public void onSensorChanged(SensorEvent event) {
		msg.insert(0, "Got a sensor event: " + event.values[0] + " centimeters\n");
		text.setText(msg);
		text.invalidate();
	}
}