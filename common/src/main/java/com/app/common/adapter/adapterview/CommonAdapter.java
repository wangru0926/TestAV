package com.app.common.adapter.adapterview;

import android.content.Context;
import android.view.LayoutInflater;
import com.app.common.adapter.adapterview.util.ItemViewDelegate;
import com.app.common.adapter.adapterview.util.ViewHolder;

import java.util.List;

/**
 * https://github.com/hongyangAndroid/baseAdapter
 * Created by zhy on 16/4/9.
 */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonAdapter(final Context context, final int layoutId, List<T> datas) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position, List<Object> payloads) {
                CommonAdapter.this.convert(holder, t, position, payloads);
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position, List<Object> payloads);

    public void setData(List<T> datas) {
        mDatas = datas;
    }
}
