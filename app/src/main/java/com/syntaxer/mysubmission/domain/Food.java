package com.syntaxer.mysubmission.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Android Studio.
 * User: FERREL JOHN FERNANDO
 * Date: 12/06/2019.
 * Time: 11:15.
 * To change this template use File | Settings | File and Code Templates.
 */
public class Food implements Parcelable {
    private String name, desc, photo, remarks, sourceName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Food() {

    }

    protected Food(Parcel in) {
        name = in.readString();
        desc = in.readString();
        photo = in.readString();
        remarks = in.readString();
        sourceName = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.desc);
        parcel.writeString(this.photo);
        parcel.writeString(this.remarks);
        parcel.writeString(this.sourceName);
    }
}
