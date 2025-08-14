package io.clicedvly768.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {
    private List<App> apps;

    public AppAdapter(List<App> apps) {
        this.apps = apps;
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_app, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        App app = apps.get(position);
        holder.nameTextView.setText(app.getName());
        holder.categoryTextView.setText(app.getCategory());
        holder.descriptionTextView.setText(app.getDescription());
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    static class AppViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView categoryTextView;
        TextView descriptionTextView;

        AppViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.app_name);
            categoryTextView = itemView.findViewById(R.id.app_category);
            descriptionTextView = itemView.findViewById(R.id.app_description);
        }
    }
}
