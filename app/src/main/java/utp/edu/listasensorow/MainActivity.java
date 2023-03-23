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
    // Magnetic field sensor
    private Sensor msensor;
    private float[] mGeomagnetic = new float[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mRotationV = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        msensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        boolean listener = mSensorManager.registerListener(this, mRotationV, SensorManager.SENSOR_DELAY_UI);
        boolean mlistener = mSensorManager.registerListener(this, msensor, SensorManager.SENSOR_DELAY_GAME);

        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        TextView sensorList = findViewById(R.id.sensorList);
        for (Sensor sensor : sensors) {
            sensorList.append(sensor.getName()+"\n");
            Log.d("Sensors", "" + sensor.getName());
        }
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        synchronized (this) {

            if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
                // azymut
                SensorManager.getRotationMatrixFromVector(rMat, event.values);
                mAzimuth = (int) (Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]) + 360) % 360;
                mAzimuth = Math.round(mAzimuth);

                TextView azimuthValue = findViewById(R.id.azimuth);
                azimuthValue.setText(String.valueOf(mAzimuth));
            }

            if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                // magnetic sensor
                mGeomagnetic = event.values;

                TextView mX = findViewById(R.id.mx);
                TextView mY = findViewById(R.id.my);
                TextView mZ = findViewById(R.id.mz);

                mX.setText(String.valueOf(mGeomagnetic[0]));
                mY.setText(String.valueOf(mGeomagnetic[1]));
                mZ.setText(String.valueOf(mGeomagnetic[2]));
            }
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}