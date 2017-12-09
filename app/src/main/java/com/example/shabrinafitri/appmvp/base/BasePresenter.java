package com.example.shabrinafitri.appmvp.base;

/**
 * Created by shabrinafitri on 09/12/17.
 */

public interface BasePresenter<T> {
    void onAttachView(T view);
}