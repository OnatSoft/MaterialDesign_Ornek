package per.osomer.materialdesign_example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class TabLayout_Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ArrayList<Fragment> fragmentList = new ArrayList<>();
    ArrayList<String> tabLayoutListTitle = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);


        //- Fragmentlar listeye ekleniyor.
        fragmentList.add(new FragmentFirst());
        fragmentList.add(new FragmentSecond());
        fragmentList.add(new FragmentThird());
        fragmentList.add(new FragmentFour());

        //- Oluşturulan View Pager Adapterından nesne oluşturup daha sonra View Pager'a aktarılıyor.
        viewPagerAdapter adapter = new viewPagerAdapter(this);
        viewPager2.setAdapter(adapter);

        //- Tab Layout fragment başlıkları listeye ekleniyor.
        tabLayoutListTitle.add("Anasayfa");
        tabLayoutListTitle.add("Keşfet");
        tabLayoutListTitle.add("Profil");
        tabLayoutListTitle.add("Ayarlar");

        //- View Pager'da fragmentları açmak için tab layout ile birbirlerine bağlıyoruz.
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, vpIndex) -> tab.setText(tabLayoutListTitle.get(vpIndex))).attach();

        tabLayout.getTabAt(0).setIcon(R.drawable.resimbir);
        tabLayout.getTabAt(1).setIcon(R.drawable.resimiki);
        tabLayout.getTabAt(2).setIcon(R.drawable.resimuc);
        tabLayout.getTabAt(3).setIcon(R.drawable.resimdort);
    }



    public class viewPagerAdapter extends FragmentStateAdapter{

        public viewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            //- View Pager da fragment'ları görüntülemek için Constructor metod.
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getItemCount() {
            //- FragmentList, listesinin boyutunu dinamik olarak almayı sağlıyor.
            return fragmentList.size();
        }
    }
}