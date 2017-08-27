package com.awok.movieslist.popular;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.awok.movieslist.R;
import com.awok.movieslist.moviesDetails.MovieDetailsActivity;
import com.awok.movieslist.utilities.AppConstants;

import java.util.List;

/**
 * Created by Manu on 8/27/2017.
 */

public class MovieGridAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private List<PopularMoviesModel.ResultsEntity> mValues;
    private Context context;
    private int type;

    public MovieGridAdapter(Context context, List<PopularMoviesModel.ResultsEntity> items, int type) {
        this.context = context;
        mValues = items;
        this.type = type;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_grid_item, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, final int position) {
      //  holder.titleTV.setText(mValues.get(position).getTitle());
       // holder.popularityTV.setText(context.getString(R.string.popularity) + "  " + mValues.get(position).getPopularity() + "");
       // holder.releaseDateTV.setText(context.getString(R.string.releaseDate) + "  " + mValues.get(position).getRelease_date());
        Uri uri = Uri.parse(AppConstants.IMAGE_URL_SMALL + mValues.get(position).getPoster_path());
        // SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        holder.simpleDraweeView.setImageURI(uri);
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MovieDetailsActivity.class);
                intent.putExtra("TITLE", mValues.get(position).getTitle());
                intent.putExtra("IMAGE_URL", mValues.get(position).getPoster_path());
                intent.putExtra("RELEASE_DATE", mValues.get(position).getRelease_date());
//
                intent.putExtra("ID", mValues.get(position).getId()+"");
                intent.putExtra("TYPE",type);

                context.startActivity(intent);
            }
        });
        //http://image.tmdb.org/t/p/w500/o8u0NyEigCEaZHBdCYTRfXR8U4i.jpg


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
