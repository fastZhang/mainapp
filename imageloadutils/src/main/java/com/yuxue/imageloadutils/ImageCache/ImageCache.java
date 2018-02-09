package com.yuxue.imageloadutils.ImageCache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * <pre>
 *     author : zhangchuanliang
 *     wx     : 644924861
 *     time   : 2018/02/09
 *     desc   :
 * </pre>
 */

public class ImageCache {
    private LruCache<String, Bitmap> bitmapLruCache;


    public ImageCache() {

        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        final int cacheSize = maxMemory / 4;

        bitmapLruCache = new LruCache<String, Bitmap>(cacheSize) {

            @Override
            protected int sizeOf(String key, Bitmap value) {
                //return size of add a bitmap
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }


    public void put(String url, Bitmap bitmap) {
        bitmapLruCache.put(url, bitmap);
    }

    public Bitmap get(String url) {
        return bitmapLruCache.get(url);
    }
}
