package afandi.nat.myintentactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMoveActivity;
    Button btnMoveWithDataActivity;
    Button btnDialPhone;
    Button btnWebBrowser;
    Button btnMoveExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveWithDataActivity = findViewById(R.id.btn_move_activity_data);
        btnMoveWithDataActivity.setOnClickListener(this);

        btnDialPhone = findViewById(R.id.btn_dial_phone);
        btnDialPhone.setOnClickListener(this);

        btnWebBrowser = findViewById(R.id.btn_web_browser);
        btnWebBrowser.setOnClickListener(this);

        btnMoveExtra = findViewById(R.id.btn_move_extra);
        btnMoveExtra.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent moveActivity = new Intent(MainActivity.this, NewActivity.class);
                startActivity(moveActivity);
                break;
            case R.id.btn_move_activity_data:
                Intent moveWithData = new Intent(MainActivity.this, MoveActivityWithData.class);
                moveWithData.putExtra(MoveActivityWithData.EXTRA_NAME,"Afandi NAT");
                moveWithData.putExtra(MoveActivityWithData.EXTRA_AGE, 25);
                startActivity(moveWithData);
                break;
            case R.id.btn_dial_phone:
                String phoneNumber = "082325312882";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
            case R.id.btn_web_browser:
                Intent WebBrowserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://polines.ac.id/"));
                startActivity(WebBrowserIntent);
                break;
            case R.id.btn_move_extra:
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
                break;
        }
    }
}
