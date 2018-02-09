package com.yuxue.imageloadutils.likeCache;

import android.graphics.Bitmap;

/**
 * <pre>
 *     author : zhangchuanliang
 *     wx     : 644924861
 *     time   : 2018/02/09
 *     desc   :
 * </pre>
 */

public interface ICache {

    public void put(String url, Bitmap bitmap);

    public Bitmap get(String url);
}
