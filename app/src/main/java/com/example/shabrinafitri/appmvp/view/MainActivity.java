package com.example.shabrinafitri.appmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.shabrinafitri.appmvp.R;
import com.example.shabrinafitri.appmvp.presenter.MainRepoInject;
import com.example.shabrinafitri.appmvp.model.PojoMain;
import com.example.shabrinafitri.appmvp.model.PojoMain.ResultsBean;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    RecyclerView recyclerView;
    MainActivityPresenter mainActivityPresenter;
    ArrayList<PojoMain.ResultsBean> data;
    Adapter adapter;
    private static final String save = "save";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewMain);
        mainActivityPresenter = new MainActivityPresenter(MainRepoInject.
                provideToMainRepo(getApplicationContext()));
        mainActivityPresenter.onAttachView(this);
        data = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(MainActivity.this, data);
        recyclerView.setAdapter(adapter);
        mainActivityPresenter.getData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(save, data);
    }

    @Override
    public void onSucces(List<ResultsBean> data) {
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
        Log.i("response", data.toString());
    }

    @Override
    public void onError(String msg) {

    }
}