package celine.chang.mynest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<ItemDTO> sample;

    public ItemAdapter(Context context, ArrayList<ItemDTO> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public ItemDTO getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = mLayoutInflater.inflate(R.layout.itemadapter, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.img);
        TextView title = (TextView)view.findViewById(R.id.title);
        TextView description = (TextView)view.findViewById(R.id.description);

        imageView.setImageResource(sample.get(position).getImg());
        title.setText(sample.get(position).getTitle());
        description.setText(sample.get(position).getDescription());

        return view;
    }
}