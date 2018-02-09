package com.zcl.mainapp.annotation;

/**
 * <pre>
 *     author : huangzhengneng
 *     e-mail : 943852572@qq.com
 *     time   : 2018/01/08
 *     desc   :
 * </pre>
 */

public class AtInterface {


    public @interface Author {
        String name();

        String created();

        int revision() default 1;

        String[] reviewers() default {};
    }

    public @interface Complexity {
        ComplexityLevel value() default ComplexityLevel.MEDIUM;
    }

    public enum ComplexityLevel {
        VERY_SIMPLE, SIMPLE, MEDIUM, COMPLEX, VERY_COMPLEX;
    }
}
