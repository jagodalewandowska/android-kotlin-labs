package utp.edu.listasensorow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.google.android.material.textfield.TextInputLayout;

public class azimuthSMS extends AppCompatActivity implements SensorEventListener {
    int mAzimuth;
    float[] rMat = new float[9];
    float[] orientation = new float[3];
    private SensorManager mSensorManager;
    private Sensor mRotationV;

    // SMS
    Button sendSMS;
    String azimuthToSend;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static azimuthSMS ins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ins = this;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

            if (checkSelfPermission(android.Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
                String[] permissions = {android.Manifest.permission.SEND_SMS};
                requestPermissions(permissions, PERMISSION_REQUEST_CODE);
            }

            String[] permissions = {android.Manifest.permission.RECEIVE_SMS};
            int permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECEIVE_SMS);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mRotationV = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

        sendSMS = (Button)findViewById(R.id.SMSbutton);
        TextInputLayout mEdit = (TextInputLayout) findViewById(R.id.TextInput);

        sendSMS.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String message = String.valueOf(mEdit.getEditText().getText());
                    String azimuth = "Wartość azymutu: " + azimuthToSend;

                    String merged = message + "\n" + azimuth;

                    // Instancja Intent i PendingIntent
                    Intent intent = new Intent(getApplicationContext(), azimuthSMS.class);
                    PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_IMMUTABLE);

                    // Instancja SmsManager i wywoływanie metody sendTextMessage
                    SmsManager smgr = SmsManager.getDefault();
                    // numer emulatora +1-555-521-5554
                    smgr.sendTextMessage("+48505224240", null, merged, null, null);
                }
                catch (Exception e) {
                    Log.d("Error", String.valueOf(e));
                }
            }
        });
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
                azimuthToSend = String.valueOf(mAzimuth);
            }
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public static azimuthSMS getInstance(){
        return ins;
    }

    public void updateTheTextView(final String t) {
        azimuthSMS.this.runOnUiThread(new Runnable() {
            public void run() {
                TextView textSMS = (TextView) findViewById(R.id.messages);
                textSMS.append(t + "\n\n");
            }
        });
    }

}