package afandi.nat.myrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailHmjActivity extends AppCompatActivity {

    public static String EXTRA_NAME ="extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hmj);


        //tvName.setText(getIntent().getStringExtra(EXTRA_NAME));
        //tvDesc.setText(getIntent().getStringExtra(EXTRA_DESC));

        Hmj hmj = getIntent().getParcelableExtra(EXTRA_NAME);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.Bind(hmj);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Detail "+getResources().getString(R.string.hmj_name));
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return super.onSupportNavigateUp();
    }

    private class ViewHolder{
        ImageView imgPhoto = findViewById(R.id.img_photo);
        TextView tvName = findViewById(R.id.txt_name);
        TextView tvDesc = findViewById(R.id.txt_desc);

        public void Bind(Hmj hmj) {
            int photoId = hmj.getPhoto();
            if(photoId>0) imgPhoto.setImageResource(hmj.getPhoto());
            tvName.setText(hmj.getName());
            tvDesc.setText(hmj.getDescription());
        }
    }



}
