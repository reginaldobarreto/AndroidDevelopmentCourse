package br.com.barrsoft.androiddevelopmentcourse.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import br.com.barrsoft.androiddevelopmentcourse.R;
import br.com.barrsoft.androiddevelopmentcourse.adapters.RecyclerAdapter;
import br.com.barrsoft.androiddevelopmentcourse.interfaces.APIService;
import br.com.barrsoft.androiddevelopmentcourse.models.RocketModel;
import br.com.barrsoft.androiddevelopmentcourse.services.RestClient;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycleView) RecyclerView recyclerView;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    private String TAG = MainActivity.class.getName();
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<RocketModel> rocketModels = new ArrayList<>();
    APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        progressBar.setVisibility(View.VISIBLE);
        //retrofit api
        apiService = RestClient.getService();

        //chamada desincronizada
        apiService.getRocket("asc","2018").enqueue(new Callback<List<RocketModel>>() {
            @Override
            public void onResponse(Call<List<RocketModel>> call, Response<List<RocketModel>> response) {
                rocketModels.addAll(response.body());
                recyclerView.setAdapter(new RecyclerAdapter(rocketModels));
                progressBar.setVisibility(View.GONE);
                Log.i(TAG,"onResponse" );
            }

            @Override
            public void onFailure(Call<List<RocketModel>> call, Throwable t) {
                Log.i(TAG, "onFailure "+ t.getMessage().toString());
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(rocketModels));
    }
}