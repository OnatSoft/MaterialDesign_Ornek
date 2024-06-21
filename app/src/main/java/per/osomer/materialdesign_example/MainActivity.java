package per.osomer.materialdesign_example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView rv;
    private Button btnGecis2;
    ArrayList<String> blogList;
    Card1_Adapter adapter;
    TextView textView2;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        btnGecis2 = findViewById(R.id.btnGecis2);
        textView2 = findViewById(R.id.textView2);
        toolbar = findViewById(R.id.toolbar);



        //* ÖNEMLİ! Arama özelliğini toolbar üzerinde göstermek için yazılıyor.
        setSupportActionBar(toolbar);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);

        blogList = new ArrayList<>();
        blogList.add("iPhone 16 Tüm Sızıntıları");
        blogList.add("Apple WWDC24 Etkinliğinde Neler Yaşandı?");
        blogList.add("Geleceğin Meslekleri (2024)");
        blogList.add("Mobil Uygulama Güvenliği");
        blogList.add("Reeder, elektrikli otomobil üretimine başlıyor.");
        blogList.add("Galaxy Watch Ultra ortaya çıktı.");

        adapter = new Card1_Adapter(this, blogList);
        rv.setAdapter(adapter);



        btnGecis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity_Page2.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //* Buraya toolbar arama menü tasarımı yükleniyor ve Toolbar'da nereye tıklanıp arama kutusu çalışacaksa o widget ID'si tanımlanıyor.

        getMenuInflater().inflate(R.menu.toolbar_arama, menu);

        MenuItem menuItem = menu.findItem(R.id.action_Arama);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //* Buraya Toolbar menüsü ögelerine tıklanılma durumları ve tıklanıldığında yapılacak işlemler yazılıyor.

        if (item.getItemId() == R.id.action_Cikis){
            Toast.makeText(getApplicationContext(), "Çıkış tıklandı.", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        //NOT: Bu 2 metod, Activity sınıfına "SearchView.OnQueryTextListener" implements edilerek oto. ekleniyor.
        //* Girilen kelimeyi klavyeden arama butonuna tıklayınca aratan metod.
        textView2.setText(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //* Klavyeden girilen kelimeyi harf değişirken aynı anda aratan metod.
        Log.e("Text Change Araması", newText);
        return true;
    }
}