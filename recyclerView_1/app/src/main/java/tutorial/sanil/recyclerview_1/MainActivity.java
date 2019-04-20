package tutorial.sanil.recyclerview_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.LinkedList;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private final LinkedList<Data> mPersonList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private String jsonString;
    private Integer total_pages;
    private Integer current_page;
    public ProgressBar pb;
    public static String tag = "RECYCLER VIEW TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //data for recycler view

        current_page = 1;
        pb = (ProgressBar) findViewById(R.id.pbLoading);
        //pb.setVisibility(ProgressBar.VISIBLE);

        downloadData("https://reqres.in/api/users");
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        //mAdapter = new WordListAdapter(this, mWordList);
        mAdapter = new WordListAdapter(this,mPersonList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    void downloadData(String website) {
        OkHttpClient client = new OkHttpClient();
        String url = website;

        pb.setVisibility(ProgressBar.VISIBLE);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                if(response.isSuccessful()) {
                    String myresponse = response.body().string();
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            jsonString = myresponse;
                            Log.d(tag,myresponse);
                            Gson gson = new Gson();
                            People p = gson.fromJson(jsonString,People.class);
                            Log.d(tag,  " " + p.getTotal_pages());
                            total_pages = p.getTotal_pages();

                            for(int i=0;i<p.getData().size();i++){
                                mWordList.add(p.getData().get(i).getFirst_name());
                            }
                            for(int i=0;i<p.getData().size();i++){
                                mPersonList.add(p.getData().get(i));
                            }

                            //IMPORTANT
                            mAdapter.notifyDataSetChanged();
                            pb.setVisibility(ProgressBar.INVISIBLE);

                            if(current_page<total_pages){
                                current_page++;

                                String web = website.substring(0,27);
                                Log.d(tag,"current page: "+current_page+ " Sending request: "+web+"?page="+current_page);
                                downloadData(web+"?page="+current_page);
                            }

                        }
                    });
                }
            }
        });
    }

}
