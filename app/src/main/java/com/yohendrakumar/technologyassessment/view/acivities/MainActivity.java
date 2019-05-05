package com.yohendrakumar.technologyassessment.view.acivities;

import android.app.ProgressDialog;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.yohendrakumar.technologyassessment.R;
import com.yohendrakumar.technologyassessment.model.ApiResponse;
import com.yohendrakumar.technologyassessment.view.listadapters.ArticleListAdapter;
import com.yohendrakumar.technologyassessment.viewmodel.ArticleViewModel;

import io.reactivex.Single;

public class MainActivity extends AppCompatActivity {

    private RecyclerView articleListView;
    private ProgressDialog progressDialog;
    private LinearLayoutManager linearLayoutManager;
    private ArticleViewModel articleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        articleViewModel = ViewModelProviders.of(MainActivity.this).get(ArticleViewModel.class);
        initViews();
        loadArticle();
        }

        public void initViews() {
            articleListView=findViewById(R.id.article_list);
            linearLayoutManager = new LinearLayoutManager(MainActivity.this);
            articleListView.setLayoutManager(linearLayoutManager);
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setCancelable(false);
        }

    public void loadArticle() {
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        LiveData<ApiResponse> apiResponseLiveData = articleViewModel.getTask();
        apiResponseLiveData.observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(@Nullable ApiResponse apiResponse) {
                progressDialog.dismiss();
                articleListView.setAdapter(new ArticleListAdapter(MainActivity.this, apiResponse.getResults()));
            }
        });
    }
}
