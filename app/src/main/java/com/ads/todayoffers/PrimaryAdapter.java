package com.ads.todayoffers;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by thrmyr on 8/9/15.
 */
public class PrimaryAdapter extends BaseAdapter implements View.OnClickListener {
    String[] result;
    Context context;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public PrimaryAdapter(Context mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result = prgmNameList;
        context = mainActivity;
        imageId = prgmImages;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    public class Holder {
        TextView tv, shareFacbook, shareWhatsApp, likePost, likeCount;
        TextView shortDiscount;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/fontawesome-webfont.ttf");

        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.item_listview, null);
        holder.tv = (TextView) rowView.findViewById(R.id.textViewOffer);
        holder.shareFacbook = (TextView) rowView.findViewById(R.id.textViewFacebook);
        holder.shareWhatsApp = (TextView) rowView.findViewById(R.id.textViewWhatsApp);
      /*  holder.likePost = (TextView) rowView.findViewById(R.id.textViewLike);
        holder.likeCount = (TextView) rowView.findViewById(R.id.textViewLikeCount);*/

        holder.shareFacbook.setTypeface(font);
        holder.shareWhatsApp.setTypeface(font);


        holder.shareFacbook.setOnClickListener(this);
        holder.shareWhatsApp.setOnClickListener(this);
        /*holder.shareFacbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.shareFacbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

*/
        //  holder.likePost.setTypeface(font);



        /*if (position % 5 == 0) {
            rowView.setBackgroundColor(Color.parseColor("#42A5F5"));
        } else if (position % 5 == 1) {
            rowView.setBackgroundColor(Color.parseColor("#FFEB3B"));
        } else if (position % 5 == 2) {
            rowView.setBackgroundColor(Color.parseColor("#F44336"));
        } else if (position % 5 == 3) {
            rowView.setBackgroundColor(Color.parseColor("#009688"));
        } else if (position % 5 == 4) {
            rowView.setBackgroundColor(Color.parseColor("#FFC107"));
        }*/
/*

        if (position % 2 == 0) {
            rowView.setBackgroundResource(R.drawable.corner_layout);
        } else if (position % 2 == 1) {
            rowView.setBackgroundColor(Color.BLACK);
        }
*/

        rowView.setBackgroundResource(R.drawable.corner_layout);
        //holder.shortDiscount = (TextView) rowView.findViewById(R.id.textView_short);
        holder.img = (ImageView) rowView.findViewById(R.id.imageViewOffer);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
     /*   rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();
            }
        });
*/
        rowView.setPadding(10, 0, 10, 10);


        /*Animation anim = new MainActivity.Rotate3dAnimation(20.0f, 0.0f, 20.0f, false, convertView);
        anim.setDuration(500l);
        rowView.startAnimation(anim);*/

        return rowView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.textViewFacebook:

                Log.e("Facebook", "Facebook 2222   ShivA ");

                break;

            case R.id.textViewWhatsApp:

                Log.e("Whats", "WhatsApp 1111   Ranjeeth");

                break;
        }

    }


}