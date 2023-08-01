package ru.neco_tutor.pocketsommelier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;

    String wineList[];
    int imgList[];
    LayoutInflater inflater;

    public CustomBaseAdapter(Context context, String[] wineList, int[] imgList) {
        this.context = context;
        this.wineList = wineList;
        this.imgList = imgList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return wineList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView =inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView textView = convertView.findViewById(R.id.text_list);
        ImageView imageView = convertView.findViewById(R.id.image_list);
        textView.setText(wineList[position]);
        imageView.setImageResource(imgList[position]);
        return convertView;
    }
}
