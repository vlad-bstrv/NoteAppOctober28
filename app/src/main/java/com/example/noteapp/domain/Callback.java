package com.example.noteapp.domain;

public interface Callback<T> {
    void onSuccess(T result);
    void onError(Throwable error);
}
