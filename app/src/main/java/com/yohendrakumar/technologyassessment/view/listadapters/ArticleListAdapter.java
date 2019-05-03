package com.yohendrakumar.technologyassessment.view.listadapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yohendrakumar.technologyassessment.R;
import com.yohendrakumar.technologyassessment.model.ResultsItem;
import com.yohendrakumar.technologyassessment.view.acivities.DetailActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleItem>
{
    List<ResultsItem> articlesList;
    Context context;

    public ArticleListAdapter(Context context, List<ResultsItem> articlesList) {
        this.context =  context;
        this.articlesList = articlesList;
    }

    class ArticleItem extends RecyclerView.ViewHolder
    {
        CircleImageView thumbnailImageView;
        ImageView expendImageView;
        TextView haedingTextView, subheadingTextView, postedDateTimeTextView;


        public ArticleItem(@NonNull final View itemView) {
            super(itemView);

            thumbnailImageView = itemView.findViewById(R.id.article_thumbnail);
            expendImageView = itemView.findViewById(R.id.detail_image);
            haedingTextView = itemView.findViewById(R.id.article_heading);
            subheadingTextView = itemView.findViewById(R.id.article_sub_heading);
            postedDateTimeTextView = itemView.findViewById(R.id.article_posted_date_time);

        }
    }

    @NonNull
    @Override
    public ArticleItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View layout_view=layoutInflater.inflate(R.layout.article_item , viewGroup , false);
        final ArticleItem articleItem =  new ArticleItem(layout_view);



        layout_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = articleItem.getAdapterPosition();
                Intent intent =  new Intent(context, DetailActivity.class);
                intent.putExtra("ARTICALE", articlesList.get(pos));
                context.startActivity(intent);
            }
        });

        return articleItem;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleItem articleItem, int i) {
        ResultsItem resultsItem = articlesList.get(i);
        String imageUrl = resultsItem.getMedia().get(0).getMediaMetadata().get(0).getUrl();

        Picasso.with(context)
                .load(imageUrl)
                .into(articleItem.thumbnailImageView);

        articleItem.haedingTextView.setText(resultsItem.getTitle());
        articleItem.subheadingTextView.setText(resultsItem.getByline());
        articleItem.postedDateTimeTextView.setText(resultsItem.getPublishedDate());

    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

}
