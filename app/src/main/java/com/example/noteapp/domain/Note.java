package com.example.noteapp.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    private String title;
    private String text;

    public Note(String name, String text) {
        this.title = name;
        this.text = text;
    }

    protected Note(Parcel in) {
        title = in.readString();
        text = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(text);
    }
}
