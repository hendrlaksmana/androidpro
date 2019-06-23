package com.example.sumbermakmur;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by anupamchugh on 09/02/16.
 */
public class AdapterArtikel extends ArrayAdapter<ModelArtikel> implements View.OnClickListener{

    private ArrayList<ModelArtikel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView title;
        TextView deskripsi;
        ImageView Image;
    }



    public AdapterArtikel(ArrayList<ModelArtikel> data, Context context) {
        super(context, R.layout.list_artikel, data);
        this.dataSet = data;
        this.mContext=context;

    }


    @Override
    public void onClick(View v) {


        int position=(Integer) v.getTag();
        Object object= getItem(position);
        ModelArtikel Model=(ModelArtikel) object;



    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ModelArtikel Model = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_artikel, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.deskripsi = (TextView) convertView.findViewById(R.id.deskripsi);
            viewHolder.Image = (ImageView) convertView.findViewById(R.id.image);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.title.setText(Model.getTitle());
        viewHolder.deskripsi.setText(Model.getDeskripsi());
        viewHolder.Image.setImageResource(Model.getImage());
        // Return the completed view to render on screen
        return convertView;
    }


}
