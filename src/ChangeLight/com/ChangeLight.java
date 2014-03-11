package ChangeLight.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ChangeLight extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Intent StartIntent=new Intent(this,LightService.class);
        System.out.println("create-service-before");
        startService(StartIntent);
        System.out.println("create-service-after");
        
    }
}