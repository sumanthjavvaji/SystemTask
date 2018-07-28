package com.dev.systemtask.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dev.systemtask.Adapters.AuthorAdapter;
import com.dev.systemtask.Model.Data;
import com.dev.systemtask.R;
import com.dev.systemtask.RetrofitUtils.APIClient;
import com.dev.systemtask.RetrofitUtils.APIInterface;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    ArrayList<Data.Entrylist> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        APIInterface apiService =
                APIClient.getClient().create(APIInterface.class);

        Call<Data> call = apiService.getData();

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                list = response.body().feed.entry;

                recyclerView.setAdapter(new AuthorAdapter(MainActivity.this,list));
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }
}
