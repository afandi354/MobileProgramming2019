package afandi.nat.myintentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        final EditText name = (EditText) findViewById(R.id.edit_textdata);
        Button button = (Button) findViewById(R.id.button_submitintent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MoveExtraActivity.class);
                i.putExtra("name", name.getText().toString());
                startActivity(i);
            }
        });
    }
}
