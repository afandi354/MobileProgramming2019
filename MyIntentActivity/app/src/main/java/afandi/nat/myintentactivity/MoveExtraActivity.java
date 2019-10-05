package afandi.nat.myintentactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveExtraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_extra);

        TextView t = (TextView) findViewById(R.id.text_viewdata);
        Bundle bundle = getIntent().getExtras();
        String s  = bundle.getString("name");
        t.setText(s);
    }
}
