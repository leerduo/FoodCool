package com.bohe.foodcool.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bohe.foodcool.R;

import java.util.List;

/**
 * Created by wangteng.
 * Time:2015/11/2
 * Email:843203996@qq.com
 */
public class MyRecyclerViewAdapter extends
                                            RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Integer> datas;

    public MyRecyclerViewAdapter(Context context, List<Integer> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder ret = null;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.main_image_recycler_item, parent, false);

        ret = new ViewHolder(view);

        return ret;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if (datas != null) {
            ret = datas.size();
        }
        return ret;
    }


public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.main_recycler_item_icon);
    }


    public ImageView imageView;


    @Override
    public void onClick(View v) {

    }
}


}
