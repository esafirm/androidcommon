package com.incendiary.androidcommon.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by esafirm on 8/9/16.
 */
public static RecyclerAttacherBuilder with(RecyclerView recyclerView) {
    return new RecyclerAttacherBuilder(recyclerView);
    }

public static class RecyclerAttacherBuilder {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private RecyclerView.ItemDecoration[] itemDecorations;

    private boolean hasFixedSize;

    RecyclerAttacherBuilder(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        hasFixedSize = true;
    }

    public RecyclerAttacherBuilder hasFixedSize(boolean hasFixedSize) {
        this.hasFixedSize = hasFixedSize;
        return this;
    }

    public RecyclerAttacherBuilder layoutManager(RecyclerView.LayoutManager manager) {
        this.layoutManager = manager;
        return this;
    }

    public RecyclerAttacherBuilder adapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
        return this;
    }

    public RecyclerAttacherBuilder itemDecoration(RecyclerView.ItemDecoration... itemDecoration) {
        this.itemDecorations = itemDecoration;
        return this;
    }

    public void build() {
        if (layoutManager == null) {
            layoutManager = new LinearLayoutManager(recyclerView.getContext());
        }

        if (itemDecorations != null) {
            for (RecyclerView.ItemDecoration decoration : itemDecorations) {
                recyclerView.addItemDecoration(decoration);
            }
        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(hasFixedSize);
        recyclerView.setAdapter(adapter);
    }
}
