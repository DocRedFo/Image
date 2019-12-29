package com.wtf.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageView;
    private Bitmap image;

    //Конструктор, связывает главный view с imageView
    public DownloadImageTask(ImageView imageView) {
        this.imageView = imageView;
    }

    //Метод, загружающий изображение в фоне (в случае неудачи ставит bitmap = null)
    @Override
    protected Bitmap doInBackground(String... urls) {
        String urlDisplay = urls[0];
        try {
            InputStream in = new java.net.URL(urlDisplay).openStream();
            image = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            image = null;
        }
        return image;
    }

    //Финальный метод для вывода изображения на экран, в случае удачи
    @Override
    protected void onPostExecute(Bitmap result) {
        if (result != null) {
            imageView.setImageBitmap(result);
        }
    }
}