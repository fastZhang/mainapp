package com.zcl.mainapp.annotation;

/**
 * <pre>
 *     author : huangzhengneng
 *     e-mail : 943852572@qq.com
 *     time   : 2018/01/08
 *     desc   :
 * </pre>
 */

public @interface Complexity {

    public enum Level {
        VERY_SIMPLE, SIMPLE, MEDIUM, COMPLEX, VERY_COMPLEX;
    }
}
