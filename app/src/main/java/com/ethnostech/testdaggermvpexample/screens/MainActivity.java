package com.ethnostech.testdaggermvpexample.screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.ethnostech.testdaggermvpexample.App;
import com.ethnostech.testdaggermvpexample.GithubService;
import com.ethnostech.testdaggermvpexample.R;
import com.ethnostech.testdaggermvpexample.models.GithubRepo;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.repo_home_list)
    ListView listView;
    @Inject
    AdapterRepos adapterRepos;

    @Inject
    GithubService githubService;
    @Inject Picasso picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        App.getAppComponent().plus(new MainActivityModule(this))
                .inject(this);



      //  adapterRepos = new AdapterRepos(this, picasso);

        listView.setAdapter(adapterRepos);
        githubService.getAllRepos().enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                Toast.makeText(MainActivity.this, "Successsss.....", Toast.LENGTH_SHORT).show();
                adapterRepos.swapData(response.body());
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error getting repos " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
