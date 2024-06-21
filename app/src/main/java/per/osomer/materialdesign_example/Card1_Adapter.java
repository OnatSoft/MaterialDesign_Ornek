package per.osomer.materialdesign_example;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Card1_Adapter extends RecyclerView.Adapter<Card1_Adapter.CardviewNesneleri> {
    private Context context;
    private List<String> bloglarDisaridanList;

    //* Adapter sınıfında oluşturulan Constructor.
    public Card1_Adapter(Context context, List<String> bloglarDisaridanList) {
        this.context = context;
        this.bloglarDisaridanList = bloglarDisaridanList;
    }


    //* Cardview widget'larını adapter'da temsil eden inner class metodu.
    public class CardviewNesneleri extends RecyclerView.ViewHolder{
        public CardView blogCardview;
        public ImageView imgBlogResim;
        public TextView txtBlogYazar, txtBlogTarih, txtBlogBaslik, txtBlogAciklama;
        public Button btnBlogDetay;

        public CardviewNesneleri(View itemView) {
            super(itemView);
            blogCardview = itemView.findViewById(R.id.blogCardview);
            imgBlogResim = itemView.findViewById(R.id.imgBlogResim);
            btnBlogDetay = itemView.findViewById(R.id.btnBlogDetay);
            txtBlogTarih = itemView.findViewById(R.id.txtBlogTarih);
            txtBlogYazar = itemView.findViewById(R.id.txtBlogYazar);
            txtBlogBaslik = itemView.findViewById(R.id.txtBlogBaslik);
            txtBlogAciklama = itemView.findViewById(R.id.txtBlogAciklama);
        }
    }


    @NonNull
    @Override
    public CardviewNesneleri onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim, parent, false);
        return new CardviewNesneleri(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardviewNesneleri holder, int position) {

        String blog =bloglarDisaridanList.get(position);
        holder.txtBlogBaslik.setText(blog);
        holder.btnBlogDetay.setOnClickListener(view -> {

            //Toast.makeText(context, "Butona tıklandı.", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, Activity_Page2.class));
        });
    }

    @Override
    public int getItemCount() {
        return bloglarDisaridanList.size();
    }
}