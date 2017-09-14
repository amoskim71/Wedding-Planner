package com.tony.wedding.ui.fragments;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.tony.wedding.R;
import com.tony.wedding.callbacks.CoupleListCallback;
import com.tony.wedding.model.Couple;
import com.tony.wedding.ui.adapters.CoupleListAdapter;

import java.util.List;

/**
 * Created by tinashe on 2016/02/17.
 */
public class CoupleListFragment extends BaseTabFragment implements CoupleListCallback {

    CoupleListAdapter mAdapter;

    @Override
    protected void initialize() {
        super.initialize();

        fastScroller.setVisibility(View.GONE);
        sectionTitleIndicator.setVisibility(View.GONE);

        mAdapter = new CoupleListAdapter(getContext(), this);
        recyclerView.setAdapter(mAdapter);

        if (controller.getCoupleList() != null) {
            setCoupleList(controller.getCoupleList());
        }
    }

    public void setCoupleList(List<Couple> feedList) {
        mAdapter.setCoupleList(feedList);

        progressBar.setVisibility(View.GONE);

        emptyView.setVisibility(feedList.isEmpty() ? View.VISIBLE : View.GONE);
    }

    @Override
    public void deleteCouple(Couple couple) {

    }
}
