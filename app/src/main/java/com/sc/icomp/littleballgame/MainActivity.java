package com.sc.icomp.littleballgame;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    Sensor accelerometer;
    SensorManager sensorManager;

    float sensorX; // largura
    float sensorY; // altura
    float sensorZ; // angulo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

       /* Outras opções ao SENSOR_DELAY_NORMAL, pela ordem de velocidade são:
        SENSOR_DELAY_UI, SENSOR_DELAY_GAME, e SENSOR_DELAY_FASTEST. Essas
        opções determinam a velocidade com que o acelerômetro atualiza a leitura
        de seus dados. Vale lembrar que na opção fastest, dependendo do dispositivo
        que você está utilizando, pode resultar em travamento.
       */
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        sensorX = event.values[0];
        sensorY = event.values[1];
        sensorZ = event.values[2];
        float sensorA = (event.values[0] + event.values[1] + event.values[2]);

        /* O código event.values[] com os valores 0,1 e 2
        representam respectivamente as variações nos dados do sensor nos eixos X, Y e Z
         */

        TextView tx = (TextView) findViewById(R.id.tX);
        TextView ty = (TextView) findViewById(R.id.tY);
        TextView tz = (TextView) findViewById(R.id.tZ);
        TextView ta = (TextView) findViewById(R.id.tA);
        tx.setText("X: " + (sensorX));
        ty.setText("Y: " + (sensorY));
        tz.setText("Z: " + (sensorZ));
        ta.setText("A: " + (sensorA));
        
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
