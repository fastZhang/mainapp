package com.yuxue.imageloadutils.diskCache;

import android.graphics.Bitmap;

import com.yuxue.imageloadutils.ImageCache.ImageCache;

/**
 * <pre>
 *     author : zhangchuanliang
 *     wx     : 644924861
 *     time   : 2018/02/09
 *     desc   :
 * </pre>
 */

public class DoubleCache {

    ImageCache mImageCache = new ImageCache();
    DiskCache diskCache = new DiskCache();

    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url, bitmap);
        diskCache.put(url, bitmap);
    }

    public Bitmap get(String url) {

        Bitmap bitmap = mImageCache.get(url);
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = diskCache.get(url);
            if (bitmap != null && !bitmap.isRecycled()) {

                mImageCache.put(url, bitmap);

            }
        }
        return bitmap;
    }
}
