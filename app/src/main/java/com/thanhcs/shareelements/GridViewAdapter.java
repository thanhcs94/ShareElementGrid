package com.thanhcs.shareelements;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private Context mContext;
    private List<Mobject> listObject;
    public GridViewAdapter(Context context, List<Mobject> listObject) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        this.listObject = listObject;
    }

    @Override
    public int getCount() {
        return listObject.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View v = mInflater.inflate(R.layout.grid_item, null);
        SquareImageLayout img = (SquareImageLayout)v.findViewById(R.id.image);
        img.setImageResource(listObject.get(position).getResource());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(mContext, DialogActivity.class));
                i.putExtra("data", listObject.get(position));
                ActivityOptions options = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    options = ActivityOptions
                            .makeSceneTransitionAnimation((Activity) mContext,
                                    Pair.create(v, "background_transition"),
                                    Pair.create(v.findViewById(R.id.image), "image_transition"));
                    mContext.startActivity(i, options.toBundle());
                }else
                    mContext.startActivity(i);
            }
        });

        return v;
    }
}
