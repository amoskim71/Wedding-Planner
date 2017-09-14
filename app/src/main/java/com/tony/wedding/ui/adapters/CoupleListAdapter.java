package com.tony.wedding.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tony.wedding.R;
import com.tony.wedding.callbacks.CoupleListCallback;
import com.tony.wedding.model.Couple;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tinashe on 2016/02/17.
 */
public class CoupleListAdapter extends RecyclerViewSlidingAdapter<CoupleListAdapter.CoupleHolder> {

    private List<Couple> coupleList = new ArrayList<>();

    private CoupleListCallback mCallback;

    public CoupleListAdapter(Context mContext, CoupleListCallback callback) {
        super(mContext);
        this.mCallback = callback;
    }

    public void setCoupleList(List<Couple> coupleList) {
        this.coupleList = coupleList;
        this.notifyDataSetChanged();
    }


    @Override
    public CoupleHolder onCreateViewHolder(ViewGroup parent, int position) {
        return new CoupleHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.feed_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(CoupleHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        final Couple couple = coupleList.get(position);

        /*holder.feedImg.setImageResource(R.drawable.ic_account_circle);
        Glide.with(holder.itemView.getContext())
                .load(couple.getOwnerUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.feedImg);

        holder.owner.setText(couple.getOwner());
        holder.text.setText(Html.fromHtml(couple.getDisplay().replace("\n", "<br/>")));

        holder.time.setText(
                DateUtils.getRelativeTimeSpanString(
                        couple.getTimestampCreated(),
                        Calendar.getInstance().getTimeInMillis(), 0)
        );

        if (FeedUtil.isOwner(couple)) {
            holder.feedDelete.setVisibility(View.VISIBLE);
            holder.feedDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallback.deleteFeed(couple);
                }
            });
        } else {
            holder.feedDelete.setVisibility(View.GONE);
        }*/
    }

    @Override
    public int getItemCount() {
        return coupleList.size();
    }

    class CoupleHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.feed_img)
        ImageView feedImg;

        @Bind(R.id.feed_owner)
        TextView owner;

        @Bind(R.id.feed_time)
        TextView time;

        @Bind(R.id.feed_text)
        TextView text;

        @Bind(R.id.feed_delete)
        ImageView feedDelete;

        public CoupleHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
