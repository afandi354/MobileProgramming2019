package afandi.nat.myintentactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveActivityWithData extends AppCompatActivity {
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_NAME = "extra_name";

    TextView TvDataReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        TvDataReceived = findViewById(R.id.tv_data_received);

        String nama = getIntent().getStringExtra(EXTRA_NAME);
        int umur = getIntent().getIntExtra(EXTRA_AGE, 0);

        String text = "Nama : " +nama + ",\nUmur : "+umur;
        TvDataReceived.setText(text);
    }
}
