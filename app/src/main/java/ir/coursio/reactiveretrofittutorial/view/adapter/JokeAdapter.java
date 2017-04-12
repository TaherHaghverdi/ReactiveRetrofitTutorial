package ir.coursio.reactiveretrofittutorial.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.coursio.reactiveretrofittutorial.R;
import ir.coursio.reactiveretrofittutorial.model.api.Subs.JokeStruct;

/**
 * Created by Taher on 11/04/2017.
 * Project: ReactiveRetrofitTutorial
 */

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.ViewHolder> {

    private ArrayList<JokeStruct> mJokeList;

    public JokeAdapter(ArrayList<JokeStruct> mJokeList) {
        this.mJokeList = mJokeList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_joke, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtJoke.setText(mJokeList.get(position).getText());
    }


    @Override
    public int getItemCount() {
        return mJokeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtJoke)
        TextView txtJoke;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
