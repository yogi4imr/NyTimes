package com.yohendrakumar.technologyassessment.view.acivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yohendrakumar.technologyassessment.R;
import com.yohendrakumar.technologyassessment.model.ResultsItem;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    private CircleImageView circleImageView;
    private TextView title, adx_keywords, column, section, byline, type, abstractid, published_date, source, id, asset_id, views;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ResultsItem resultsItem = getIntent().getParcelableExtra("ARTICALE");
        initViews();
        setData(resultsItem);

    }

    public void initViews() {
        circleImageView =  findViewById(R.id.details_image);
        title = findViewById(R.id.title);
        adx_keywords = findViewById(R.id.adx_keywords);
        column = findViewById(R.id.column);
        section = findViewById(R.id.section);
        byline = findViewById(R.id.byline);
        type = findViewById(R.id.type);
        abstractid = findViewById(R.id.abstractid);
        published_date = findViewById(R.id.published_date);
        source = findViewById(R.id.source);
        id = findViewById(R.id.id);
        asset_id = findViewById(R.id.asset_id);
        views = findViewById(R.id.views);
    }

    public void setData(ResultsItem resultsItem) {
        String imageUrl = resultsItem.getMedia().get(0).getMediaMetadata().get(0).getUrl();
        Picasso.with(DetailActivity.this)
                .load(imageUrl)
                .into(circleImageView);
        title.setText(resultsItem.getTitle());
        byline.setText(resultsItem.getByline());
        id.setText("Id: "+String.valueOf(resultsItem.getId()));
        //column.setText("Column: "+resultsItem.getColumn());
        section.setText("Section: "+resultsItem.getSection());

        type.setText("Type: "+resultsItem.getType());
        published_date.setText("Published Date: "+resultsItem.getPublishedDate());
        source.setText("Source: "+resultsItem.getSource());

        asset_id.setText("Asset Id: "+String.valueOf(resultsItem.getAssetId()));
        views.setText("Views: "+String.valueOf(String.valueOf(resultsItem.getViews())));
        }
}
