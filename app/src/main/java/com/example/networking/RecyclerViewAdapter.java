package com.example.networking;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<Mountain> mountains;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;

    RecyclerViewAdapter(Context context, List<Mountain> mountains, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.mountains = mountains;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.title.setText(mountains.get(position).getName());
        holder.location.setText(mountains.get(position).getLocation());
        holder.height.setText(String.valueOf(mountains.get(position).getSize()));

    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView location;
        TextView height;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
            location = itemView.findViewById(R.id.location);
            height = itemView.findViewById(R.id.height);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(mountains.get(getAdapterPosition()));
        }
    }

    public interface OnClickListener {
        void onClick(Mountain item);
    }
}
