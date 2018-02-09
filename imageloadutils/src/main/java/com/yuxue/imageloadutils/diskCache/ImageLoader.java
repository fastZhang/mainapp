package com.yuxue.imageloadutils.diskCache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.yuxue.imageloadutils.ImageCache.ImageCache;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 *     author : zhangchuanliang
 *     wx     : 644924861
 *     time   : 2018/02/09
 *     desc   :
 * </pre>
 */

public class ImageLoader {

    DoubleCache mDoubleCache = new DoubleCache();

    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public void displayImage(final String url, final ImageView imageView) {
        Bitmap bitmap = mDoubleCache.get(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }


        imageView.setTag(url);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = downLoadImage(url);

                if (bitmap == null || bitmap.isRecycled()) {
                    return;

                }
                if (imageView.getTag().equals(url)) {
                    imageView.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(bitmap);

                        }
                    });
                }

                mDoubleCache.put(url, bitmap);
            }
        });

    }

    private Bitmap downLoadImage(String url) {
        Bitmap bitmap = null;

        try {
            URL url1 = new URL(url);

            final HttpURLConnection connection = (HttpURLConnection) url1.openConnection();

            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return bitmap;


    }
}
