package afandi.nat.myrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHmj;
    private ArrayList<Hmj> list = new ArrayList<>();
    private String title = "HM ITTP Mode List";
    private final String STATE_TITLE = "state_string";
    private final String STATE_LIST = "state_list";
    private final String STATE_MODE = "state_mode";
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHmj = findViewById(R.id.rv_hmj);
        rvHmj.setHasFixedSize(true);

        if(savedInstanceState == null){
            setActionBarTitle(title);
            list.addAll(getListHmj());
            showRecycleList();
            mode = R.id.action_list;
        } else {
            title = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Hmj> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);

            setActionBarTitle(title);
            if(stateList != null){
                list.addAll(stateList);
            }
            setMode(stateMode);
        }
    }

    private void showSelectedHmj(Hmj hmj){
        Toast.makeText(this, "Kamu memilih "+hmj.getName(), Toast.LENGTH_SHORT).show();
    }

    private void setActionBarTitle(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int selectedMode) {
        switch (selectedMode){
            case R.id.action_list:
                showRecycleList();
                title = "HM ITTP Mode List";
                break;
            case R.id.action_cardview:
                showRecyclerCardView();
                title = "HM ITTP Mode Card View";
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    public ArrayList<Hmj> getListHmj() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        String[] dataPhoto = getResources().getStringArray(R.array.photo);

        ArrayList<Hmj> listHmj = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++){
            Hmj hmj = new Hmj();
            hmj.setName(dataName[i]);
            hmj.setDescription(dataDescription[i]);
            hmj.setPhoto(dataPhoto[i]);

            listHmj.add(hmj);
        }
        return listHmj;
    }

    private void showRecycleList(){
        rvHmj.setLayoutManager(new LinearLayoutManager(this));
        ListHmjAdapter listHmjAdapter = new ListHmjAdapter(list);
        rvHmj.setAdapter(listHmjAdapter);

        listHmjAdapter.setOnItemClickCallback(new ListHmjAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hmj data) {
                showSelectedHmj(data);
            }
        });
    }

    private void showRecyclerCardView(){
        rvHmj.setLayoutManager(new LinearLayoutManager(this));
        CardViewHmjAdapter cardViewHmjAdapter = new CardViewHmjAdapter(list);
        rvHmj.setAdapter(cardViewHmjAdapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, title);
        outState.putParcelableArrayList(STATE_LIST,list);
        outState.putInt(STATE_MODE, mode);
    }
}
