package per.osomer.materialdesign_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.net.URL;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerItem>{
    private List<String> viewPagerList;
    private Context mContext;
    private ViewPager2 viewPager2;

    private int[] colorArray = new int[]{
            android.R.color.system_accent1_100, android.R.color.holo_green_light, android.R.color.holo_orange_light,
            android.R.color.holo_orange_dark, R.color.lightPrimaryColor, android.R.color.holo_green_dark
    };

    public ViewPagerAdapter(List<String> viewPagerList, Context mContext, ViewPager2 viewPager2) {
        this.viewPagerList = viewPagerList;
        this.mContext = mContext;
        this.viewPager2 = viewPager2;
    }

    public class ViewPagerItem extends RecyclerView.ViewHolder{
        TextView txtTitle;
        Button btnToggle;
        RelativeLayout relativeLayout;
        ImageView imageView;

        public ViewPagerItem(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            btnToggle = itemView.findViewById(R.id.btnToggle);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public ViewPagerItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewpager2, parent, false);
        return new ViewPagerItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerItem holder, int position) {

        String i = viewPagerList.get(position);
        holder.txtTitle.setText(i);
        holder.relativeLayout.setBackgroundResource(colorArray[position]);

        holder.imageView.setImageResource(R.drawable.vivo_resim);

        holder.btnToggle.setOnClickListener(view -> {

            if (viewPager2.getOrientation() == ViewPager2.ORIENTATION_VERTICAL){
                viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
            }
            else {
                viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
            }
        });
    }

    @Override
    public int getItemCount() {
        return viewPagerList.size();
    }
}
