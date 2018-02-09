package com.yuxue.imageloadutils.likeCache;

import android.graphics.Bitmap;

import com.yuxue.imageloadutils.ImageCache.ImageCache;
import com.yuxue.imageloadutils.diskCache.DiskCache;

/**
 * <pre>
 *     author : zhangchuanliang
 *     wx     : 644924861
 *     time   : 2018/02/09
 *     desc   :
 * </pre>
 */

public class DoubleCache implements ICache {

    ImageCache mImageCache = new ImageCache();
    com.yuxue.imageloadutils.diskCache.DiskCache diskCache = new DiskCache();

    @Override
    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url, bitmap);
        diskCache.put(url, bitmap);
    }

    @Override
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
