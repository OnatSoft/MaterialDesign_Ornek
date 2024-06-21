package per.osomer.materialdesign_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity2 extends AppCompatActivity {
    ViewPager2 view_Pager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        view_Pager2 = findViewById(R.id.view_Pager2);


        List<String> pagerList = new ArrayList<>();
        pagerList.add("Birinci Sayfa");
        pagerList.add("İkinci Sayfa");
        pagerList.add("Üçüncü Sayfa");
        pagerList.add("Dördüncü Sayfa");
        pagerList.add("Beşinci Sayfa");
        pagerList.add("Altıncı Sayfa");
        view_Pager2.setAdapter(new ViewPagerAdapter(pagerList, this, view_Pager2));
        //adapter = new ViewPagerAdapter(pagerList, this, view_Pager2);
    }
}