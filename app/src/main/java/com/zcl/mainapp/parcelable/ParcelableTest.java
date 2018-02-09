package com.zcl.mainapp.parcelable;


import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * <pre>
 *     author : huangzhengneng
 *     e-mail : 943852572@qq.com
 *     time   : 2018/01/08
 *     desc   :
 * </pre>
 */

//@SuppressLint("ParcelCreator")
public class ParcelableTest implements Parcelable {
    protected ParcelableTest(Parcel in) {
    }

    public static final Creator<ParcelableTest> CREATOR = new Creator<ParcelableTest>() {
        @Override
        public ParcelableTest createFromParcel(Parcel in) {
            return new ParcelableTest(in);
        }

        @Override
        public ParcelableTest[] newArray(int size) {
            return new ParcelableTest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
    //Parcelable接口实现方法

}
