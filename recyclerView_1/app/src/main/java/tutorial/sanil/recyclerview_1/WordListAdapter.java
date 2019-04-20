package tutorial.sanil.recyclerview_1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {

    private final LinkedList<Data> mData;

    private LayoutInflater mInflater;

    public WordListAdapter(Context context,
                           LinkedList<Data> data) {
        mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                viewGroup, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder wordViewHolder, int i) {
        String first_name = mData.get(i).getFirst_name();
        String last_name = mData.get(i).getLast_name();

        int id = mData.get(i).getId();
        wordViewHolder.wordItemView.setText(first_name + " " + last_name+"\n"+ String.valueOf(id));
        //wordViewHolder.wordIdentityView.setText(String.valueOf(id));

        Picasso.get().load(mData.get(i).getAvatar()).into(wordViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        //public final TextView wordIdentityView;
        public final ImageView imageView;

        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
           // wordIdentityView = itemView.findViewById(R.id.identity);
            imageView = itemView.findViewById(R.id.image_view);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = mData.get(mPosition).getFirst_name() + " "+ mData.get(mPosition).getLast_name();
            // Change the word in the mWordList.
            Toast.makeText(view.getContext(), "Clicked "+element, Toast.LENGTH_LONG).show();
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }

}