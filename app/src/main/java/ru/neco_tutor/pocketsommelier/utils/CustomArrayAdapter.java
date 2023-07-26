package ru.neco_tutor.pocketsommelier.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ru.neco_tutor.pocketsommelier.R;

public class CustomArrayAdapter extends ArrayAdapter<ListItemClass> {
    private LayoutInflater layoutInflater;
    private List<ListItemClass> listItemClasses = new ArrayList<>();
    private Context context;
    public CustomArrayAdapter(@NonNull Context context, int resource, List<ListItemClass> listItemClasses, LayoutInflater layoutInflater) {
        super(context, resource);
        this.layoutInflater = layoutInflater;
        this.listItemClasses = listItemClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        ListItemClass listItemClass = listItemClasses.get(position);
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_view_item_1, null, false);
            viewHolder = new ViewHolder();
            viewHolder.image = convertView.findViewById(R.id.image_wine);
            viewHolder.name = convertView.findViewById(R.id.name_wine);
            viewHolder.secondName = convertView.findViewById(R.id.second_name_wine);


        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(listItemClass.getNameWine());
        viewHolder.secondName.setText(listItemClass.getSecondNameWine());
        viewHolder.image.setImageResource(listItemClass.getImage());


        return convertView;
    }
    private class ViewHolder{
        TextView name;
        TextView secondName;
        ImageView image;

    }
}
