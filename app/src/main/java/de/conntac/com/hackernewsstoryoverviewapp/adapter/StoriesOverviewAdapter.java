package de.conntac.com.hackernewsstoryoverviewapp.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.conntac.com.hackernewsstoryoverviewapp.R;
import de.conntac.com.hackernewsstoryoverviewapp.listener.StoryClickListener;
import de.conntac.com.hackernewsstoryoverviewapp.network.StoryDetailModel;
import de.conntac.com.hackernewsstoryoverviewapp.network.StoryModel;

public class StoriesOverviewAdapter extends RecyclerView.Adapter<StoriesOverviewAdapter.StoryViewHolder> {

    private ArrayList<StoryModel> storyModels;
    private StoryClickListener listener;

    public StoriesOverviewAdapter() {
        storyModels = new ArrayList<>();
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_stories_overview_item, parent, false);
        return new StoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StoryViewHolder holder, int position) {
        StoryModel model = storyModels.get(position);
        holder.bindViews(model);
    }

    @Override
    public int getItemCount() {
        return storyModels.size();
    }

    public void setStoryModels(ArrayList<StoryModel> storyModels) {
        this.storyModels = storyModels;
    }

    public void setListener(StoryClickListener listener) {
        this.listener = listener;
    }

    class StoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_story_overview_item_title)
        AppCompatTextView titleTextView;
        @BindView(R.id.text_view_story_overview_item_author)
        AppCompatTextView authorTextView;

        private StoryModel storyModel;

        private StoryViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        private void bindViews(StoryModel model) {
            this.storyModel = model;
            StoryDetailModel detailModel = storyModel.getStoryDetailModel();

            if (detailModel != null) {
                titleTextView.setText(detailModel.getTitle());
                authorTextView.setText(detailModel.getAuthor());
            }
        }

        @OnClick(R.id.linear_layout_stories_overview_item_container)
        void onStoryClick() {
            if (storyModel != null && storyModel.getStoryDetailModel() != null && listener != null) {
                listener.onStoryClicked(storyModel.getStoryDetailModel());
            }
        }
    }

}
