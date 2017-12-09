package com.example.shabrinafitri.appmvp.view;


import com.example.shabrinafitri.appmvp.model.PojoMain.ResultsBean;
import com.example.shabrinafitri.appmvp.presenter.MainActivityDataResource.MainActivityGetCallBack;
import com.example.shabrinafitri.appmvp.presenter.MainActivityRepositories;

import java.util.List;

/**
 * Created by shabrinafitri on 09/12/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter{
    MainActivityContract.View view;
    private MainActivityRepositories mainActivityRepositories;

    public MainActivityPresenter(MainActivityRepositories mainActivityRepositories) {
        this.mainActivityRepositories = mainActivityRepositories;
    }

    @Override
    public void onAttachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void getData() {
        mainActivityRepositories.getMainActivityList(new MainActivityGetCallBack() {

            @Override
            public void onSuccses(List<ResultsBean> data) {
                view.onSucces(data);
            }

            @Override
            public void onError(String msg) {
                view.onError(msg);
            }
        });
    }
}
