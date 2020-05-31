package com.example.admin.myapplication;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.service.autofill.RegexValidator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.TextView;

import com.plug.oaid.Oaid;
import com.plug.reg.Reg;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }

        // Example of a call to a native method
        final TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tv.setText( Reg.rand_str(12) );
//
//                Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.template);
//                Reg.SaveImage(MainActivity.this,Reg.rand_str(12),Reg.rand_str(12));
//            }
//        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Oaid.go(new SparseArray<ValueCallback<JSONObject>>(),0,new JSONObject(),MainActivity.this);
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
