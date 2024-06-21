package per.osomer.materialdesign_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Activity_Page2 extends AppCompatActivity {
    Button btnGecis3, btnGecis4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        btnGecis3 = findViewById(R.id.btnGecis3);
        btnGecis4 = findViewById(R.id.btnGecis4);


        btnGecis3.setOnClickListener(view -> {
            startActivity(new Intent(Activity_Page2.this, TabLayout_Activity.class));
        });

        btnGecis4.setOnClickListener(view -> {
            startActivity(new Intent(Activity_Page2.this, SecondActivity2.class));
        });
    }
}