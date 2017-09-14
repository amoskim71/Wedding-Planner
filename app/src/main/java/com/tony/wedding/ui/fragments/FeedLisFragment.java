package com.tony.wedding.ui.fragments;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.tony.wedding.R;
import com.tony.wedding.callbacks.FeedListCallback;
import com.tony.wedding.model.Feed;
import com.tony.wedding.ui.adapters.FeedListAdapter;

import java.util.List;

/**
 * Created by tinashe on 2016/02/17.
 */
public class FeedLisFragment extends BaseTabFragment implements FeedListCallback {

    FeedListAdapter mAdapter;

    @Override
    protected void initialize() {
        super.initialize();

        fastScroller.setVisibility(View.GONE);
        sectionTitleIndicator.setVisibility(View.GONE);

        mAdapter = new FeedListAdapter(getContext(), this);
        recyclerView.setAdapter(mAdapter);

        if (controller.getFeedList() != null) {
            setFeedList(controller.getFeedList());
        }
    }

    public void setFeedList(List<Feed> feedList) {
        mAdapter.setFeedList(feedList);

        progressBar.setVisibility(View.GONE);

        emptyView.setVisibility(feedList.isEmpty() ? View.VISIBLE : View.GONE);
    }


    @Override
    public void deleteFeed(final Feed feed) {
        new AlertDialog.Builder(getContext())
                .setTitle("Remove Post")
                .setMessage("Are you sure you want to remove this post?")
                .setNegativeButton(R.string.action_remove, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        controller.deleteFeed(feed);
                    }
                })
                .setPositiveButton("No", null)
                .create().show();
    }
}
