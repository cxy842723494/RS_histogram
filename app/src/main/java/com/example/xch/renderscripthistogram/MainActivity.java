package com.example.xch.renderscripthistogram;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private static int EDIT_RESULT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image1);
//        blur();
//        rgb2yuv();
//        remapping();
//        histo();
        binary();
        }


        public void blur()
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img1);
            Bitmap outimage = blurHandle.blurhandle2(getApplicationContext(),bitmap,25);
            imageView.setImageBitmap(outimage);
        }

        public void rgb2yuv()
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img1);
            Bitmap outimage = rgb2yuv.rgb2yuvhandle(bitmap,getApplicationContext());
            imageView.setImageBitmap(outimage);
        }

        public void remapping()
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img1);
            Bitmap outimage = rgb2yuv.rgb2yuvhandle(bitmap,getApplicationContext());
            Bitmap outimage2 = remapping.remaphandle(outimage,getApplicationContext());
            imageView.setImageBitmap(outimage2);
        }

        public void histo()
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img1);
            Bitmap outimage = histogramEqualization.histogramEqualization(bitmap,getApplicationContext());
            imageView.setImageBitmap(outimage);
        }

        public void binary()
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img1);
            Bitmap outimage = binary.binayhandle(getApplicationContext(),bitmap,0.5f);
            imageView.setImageBitmap(outimage);
        }
}
