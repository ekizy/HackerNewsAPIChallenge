package de.conntac.com.hackernewsstoryoverviewapp.scenes.storiesoverview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.conntac.com.hackernewsstoryoverviewapp.R;
import de.conntac.com.hackernewsstoryoverviewapp.adapter.StoriesOverviewAdapter;
import de.conntac.com.hackernewsstoryoverviewapp.application.HackerNewsApplication;
import de.conntac.com.hackernewsstoryoverviewapp.itemdecoration.StoriesOverviewItemDecoration;
import de.conntac.com.hackernewsstoryoverviewapp.listener.StoryClickListener;
import de.conntac.com.hackernewsstoryoverviewapp.network.StoryDetailModel;
import de.conntac.com.hackernewsstoryoverviewapp.network.StoryModel;
import de.conntac.com.hackernewsstoryoverviewapp.scenes.main.MainActivity;

public class StoriesOverviewFragment extends Fragment
        implements StoriesOverviewContract.View, StoryClickListener {

    @Inject
    StoriesOverviewContract.Presenter presenter;

    public final static String TAG = "STORIES_OVERVIEW_FRAGMENT";

    @BindView(R.id.recycler_view_stories_overview_story_list)
    RecyclerView storyListRecyclerView;
    @BindView(R.id.progress_bar_stories_overview_loading)
    ProgressBar loadingProgressBar;
    @BindDimen(R.dimen.margin_8)
    int listTopBottomPadding;
    @BindDimen(R.dimen.margin_16)
    int listItemLeftRightMargin;

    private StoriesOverviewAdapter adapter;
    private StoriesOverviewItemDecoration itemDecoration;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stories_overview, container, false);
        ButterKnife.bind(this, view);
        setComponents();
        presenter.getStories();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        if (getActivity() != null && getActivity().getApplication() instanceof HackerNewsApplication) {
            DaggerStoriesOverviewComponent
                    .builder()
                    .appComponent(((HackerNewsApplication) getActivity()
                            .getApplication()).getApplicationComponent())
                    .storiesOverviewModule(new StoriesOverviewModule())
                    .build()
                    .inject(this);
            presenter.attachView(this);
        }

        super.onAttach(context);
    }

    @Override
    public void onDestroyView() {
        presenter.detachComponents();

        super.onDestroyView();
    }

    @Override
    public void initializeStoryList(ArrayList<StoryModel> storyModels) {
        adapter.setStoryModels(storyModels);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateRow(int arrayIndex) {
        adapter.notifyItemChanged(arrayIndex);
    }

    @Override
    public void showProgress() {
        loadingProgressBar.setVisibility(View.VISIBLE);
        storyListRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        loadingProgressBar.setVisibility(View.GONE);
        storyListRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStoryClicked(StoryDetailModel detailModel) {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).openStoryDetail(detailModel);
        }
    }

    private void setComponents() {
        adapter = new StoriesOverviewAdapter();
        adapter.setListener(this);
        itemDecoration = new StoriesOverviewItemDecoration(listTopBottomPadding, listTopBottomPadding,
                listItemLeftRightMargin, listItemLeftRightMargin);
        storyListRecyclerView.addItemDecoration(itemDecoration);
        storyListRecyclerView.setAdapter(adapter);
        storyListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
