package afandi.nat.myviewandviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DonasiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Form Donasi");
        }
    }
}
