package com.example.shabrinafitri.appmvp.presenter;

import android.content.Context;

/**
 * Created by shabrinafitri on 09/12/17.
 */

public class MainRepoInject {
    public static MainActivityRepositories provideToMainRepo(Context context){
        return new MainActivityRepositories(new MainActivityDataRemote(context));
    }
}
