package com.incendiary.androidcommon.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by esafirm on 9/2/16.
 */

/**
 * Only work for LinearLayoutManager
 **/
public class Paginate {

    private void checkEndOffset() {
        int visibleItemCount = recyclerView.getChildCount();
        int totalItemCount = recyclerView.getLayoutManager().getItemCount();

        int firstVisibleItemPosition;
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            firstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        } else {
            throw new IllegalStateException("LayoutManager needs to subclass LinearLayoutManager");
        }

        if ((totalItemCount - visibleItemCount) <= (firstVisibleItemPosition) || totalItemCount == 0) {
            if (!callback.isLoading() && !callback.hasLoadedAllItems()) {
                callback.onLoadMore();
            }
        }
    }

    public interface Callback {
        void onLoadMore();

        boolean isLoading();

        boolean hasLoadedAllItems();
    }

    private RecyclerView recyclerView;
    private Callback callback;

    public static Paginate attach(RecyclerView recyclerView) {
        return new Paginate(recyclerView);
    }

    private Paginate(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public Paginate withCallback(Callback callback) {
        this.callback = callback;
        return this;
    }

    public void install() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                checkEndOffset();
            }
        });
    }
}
