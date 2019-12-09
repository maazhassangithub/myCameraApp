package com.example.mycameraapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE=1;
    ImageView myImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = (Button) findViewById(R.id.button);
        ImageView myImageView = (ImageView) findViewById(R.id.imageView);

        if(!hasCamera()){
            myButton.setEnabled(false);
        }


    }

    public boolean hasCamera() {
//getpackmanger.hasfeature.packmange.feature.camera.any
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);

    }

    public void launchCamera(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){

            Bundle extras = data.getExtras();
            Bitmap photos = (Bitmap) extras.get("data");
            ImageView myImageView = (ImageView) findViewById(R.id.imageView);
            double aa = photos.getHeight();
            double ab= photos.getWidth();

            String at = Double.toString(aa);
            String au = Double.toString(ab);
            //218 by 164
            Toast.makeText(this, "Height: " + at + " Width: " + au, Toast.LENGTH_LONG).show();



            //myImageView.setImageBitmap(photos);


        }
    }


}
