package com.yuxue.imageloadutils.likeCache;

import android.graphics.Bitmap;

import java.io.IOException;
import java.io.InputStream;

/**
 * <pre>
 *     author : zhangchuanliang
 *     wx     : 644924861
 *     time   : 2018/02/09
 *     desc   :
 * </pre>
 */

public class User {


    ImageLoader imageLoader = new ImageLoader();

    public void chooseCachetype() {
        imageLoader.setImageCache(new MemoryCache());

        //or
        imageLoader.setImageCache(new DiskCache());

        //or
        imageLoader.setImageCache(new DoubleCache());

        //or
        imageLoader.setImageCache(new ICache() {
            @Override
            public void put(String url, Bitmap bitmap) {

            }

            @Override
            public Bitmap get(String url) {
                return null;
            }
        });

    }
}
