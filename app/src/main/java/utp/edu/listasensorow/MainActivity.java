package utp.edu.listasensorow;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    int mAzimuth;
    float[] rMat = new float[9];
    float[] orientation = new float[3];
    private SensorManager mSensorManager;
    private Sensor mRotationV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mRotationV = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        boolean listener = mSensorManager.registerListener(this, mRotationV, SensorManager.SENSOR_DELAY_UI);

        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        TextView sensorList = findViewById(R.id.sensorList);
        for (Sensor sensor : sensors) {
            sensorList.append(sensor.getName()+"\n");
            Log.d("Sensors", "" + sensor.getName());
        }
    }


    @Override
    public void onSensorChanged(SensorEvent event){
        SensorManager.getRotationMatrixFromVector(rMat, event.values);
        mAzimuth = (int) (Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]) + 360) % 360;

        mAzimuth = Math.round(mAzimuth);

        TextView azimuthValue = findViewById(R.id.azimuth);
        azimuthValue.setText(String.valueOf(mAzimuth));
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}