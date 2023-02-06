package com.example.rebook;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
    ImageView imageView;
    public DownloadImageFromInternet(ImageView imageView) {
        this.imageView=imageView;
       // Toast.makeText(getApplicationContext(), "Please wait, it may take a few minute...",Toast.LENGTH_SHORT).show();
    }
    protected Bitmap doInBackground(String... urls) {
        URL url = null;
        try {
            url = new URL("https://covers.openlibrary.org/b/isbn/9780399501487-L.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream in = null;
        try {
            assert url != null;
            in = new BufferedInputStream(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (true)
        {
            try {
                assert in != null;
                if (-1 == (n = in.read(buf))) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.write(buf, 0, n);

        }
        try {
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bimage=null;
        bimage= BitmapFactory.decodeStream(in);




        return bimage;
    }
    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }
}
