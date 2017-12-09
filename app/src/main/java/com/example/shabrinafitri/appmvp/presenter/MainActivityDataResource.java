package com.example.shabrinafitri.appmvp.presenter;

import android.support.annotation.NonNull;

import com.example.shabrinafitri.appmvp.model.PojoMain;

import java.util.List;

/**
 * Created by shabrinafitri on 09/12/17.
 */

public interface MainActivityDataResource {

    interface MainActivityGetCallBack {

        void onSuccses(List<PojoMain.ResultsBean> data);

        void onError(String msg);
    }

    void getMainActivityList(@NonNull MainActivityGetCallBack mainActivityGetCallBack);
}