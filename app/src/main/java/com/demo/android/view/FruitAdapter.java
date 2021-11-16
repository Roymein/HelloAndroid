package com.demo.android.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.demo.android.pojo.Fruit;
import com.demo.android.R;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int mResourceId;

    public FruitAdapter(@NonNull Context context,
                        int textViewResourceId,
                        @NonNull List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        mResourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(mResourceId, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.mImageView = view.findViewById(R.id.fruit_image);
            viewHolder.mTextView = view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.mImageView.setImageResource(fruit.getImageId());
        viewHolder.mTextView.setText(fruit.getImageId());
        return view;
    }

    class ViewHolder {
        ImageView mImageView;
        TextView mTextView;
    }
}
