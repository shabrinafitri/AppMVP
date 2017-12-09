package com.example.shabrinafitri.appmvp.view;

import com.example.shabrinafitri.appmvp.base.BasePresenter;
import com.example.shabrinafitri.appmvp.model.PojoMain;

import java.util.List;

/**
 * Created by shabrinafitri on 09/12/17.
 */

public class MainActivityContract {
    public interface View {
        void onSucces(List<PojoMain.ResultsBean> data);
        void onError(String msg);
    }

    public interface Presenter extends BasePresenter<View>{
        void getData();
    }
}
