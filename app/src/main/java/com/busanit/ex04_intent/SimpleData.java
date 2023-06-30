package com.busanit.ex04_intent;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class SimpleData implements Parcelable {
    int number;
    String message;

    public SimpleData(int number, String message){
        this.number = number;
        this.message = message;
    }

    protected SimpleData(Parcel in) {
        this.number = in.readInt();
        this.message = in.readString();
    }

    public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() {
        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
