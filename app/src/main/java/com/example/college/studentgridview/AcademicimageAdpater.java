package com.example.college.studentgridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.college.R;

class AcademicimageAdpater extends BaseAdapter {
    int imageid[]= {R.drawable.cocurricularactivities,R.drawable.leaventry,R.drawable.result,R.drawable.assingments,R.drawable.timetable,R.drawable.rules,R.drawable.internalmarks,R.drawable.resume};
    Context context;


    public AcademicimageAdpater(Context mcontext) {
        this.context=mcontext;
    }



    @Override
    public int getCount() {
        return imageid.length;
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
        ImageView imageView;
        if (convertView==null)
        {
            imageView=new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(180,180));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(8,8,8,8);
        }
        else {
            imageView = (ImageView) convertView;

        }
        imageView.setImageResource(imageid[position]);
        return imageView;
    }
}



