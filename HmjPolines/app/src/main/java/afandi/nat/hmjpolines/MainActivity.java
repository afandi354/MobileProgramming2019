package afandi.nat.hmjpolines;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHmj;
    private ArrayList<Hmj> list = new ArrayList<>();
    private Toolbar toolbar;

    //CarouselView carouselView;
    //int[] polines = {R.drawable.telkom, R.drawable.telkom1, R.drawable.telkom2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_menu);
        setSupportActionBar(toolbar);

        //carouselView = findViewById(R.id.carouselPoli);
        //carouselView.setPageCount(polines.length);
        //carouselView.setImageListener(imageListener);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("");
        }

        rvHmj = findViewById(R.id.rv_hmj);
        rvHmj.setHasFixedSize(true);

        list.addAll(HmjData.getListData());
        showRecycleList();
    }

    /*ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(polines[position]);
        }
    };*/

    private void showRecycleList(){
        rvHmj.setLayoutManager(new LinearLayoutManager(this));
        CardHmjAdapter cardHmjAdapter = new CardHmjAdapter(this, list);
        rvHmj.setAdapter(cardHmjAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_about:
                startActivity(new Intent(MainActivity.this, About.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
