package afandi.nat.myviewandviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDonasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Donasi Pesawat R80");

            btnDonasi = findViewById(R.id.btn_donasi);
            btnDonasi.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_donasi:
                Intent donasiR80 = new Intent(this, DonasiActivity.class);
                startActivity(donasiR80);
                break;
        }
    }
}
