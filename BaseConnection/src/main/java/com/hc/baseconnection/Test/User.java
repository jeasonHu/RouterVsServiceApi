package com.hc.baseconnection.Test;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public String name;

    public User(String name) {
        this.name = name;
    }

    protected User(Parcel in) {
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

}
