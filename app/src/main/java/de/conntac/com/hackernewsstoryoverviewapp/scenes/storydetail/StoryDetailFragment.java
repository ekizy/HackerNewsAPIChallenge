package de.conntac.com.hackernewsstoryoverviewapp.scenes.storydetail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.conntac.com.hackernewsstoryoverviewapp.R;
import de.conntac.com.hackernewsstoryoverviewapp.application.HackerNewsApplication;
import de.conntac.com.hackernewsstoryoverviewapp.network.StoryDetailModel;
import de.conntac.com.hackernewsstoryoverviewapp.utils.DateUtils;

public class StoryDetailFragment extends Fragment implements StoryDetailContract.View {

    @Inject
    StoryDetailContract.Presenter presenter;

    public final static String TAG = "STORY_DETAIL_FRAGMENT";

    @BindView(R.id.text_view_story_detail_author_value)
    AppCompatTextView authorValueTextView;
    @BindView(R.id.text_view_story_detail_title_value)
    AppCompatTextView titleValueTextView;
    @BindView(R.id.text_view_story_detail_creation_date_value)
    AppCompatTextView creationDateValueTextView;
    @BindView(R.id.text_view_story_detail_id_value)
    AppCompatTextView storyIDTextView;
    @BindView(R.id.text_view_story_detail_score_value)
    AppCompatTextView scoreValueTextView;
    @BindView(R.id.text_view_story_detail_url_value)
    AppCompatTextView storyURLValueTextView;

    private static final String STORY_DETAIL_ARG_KEY = "STORY_DETAIL_ARG_KEY";

    public static StoryDetailFragment newInstance(StoryDetailModel storyDetailModel) {
        Bundle args = new Bundle();
        StoryDetailFragment fragment = new StoryDetailFragment();
        args.putParcelable(STORY_DETAIL_ARG_KEY, storyDetailModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_detail, container, false);
        ButterKnife.bind(this, view);
        getBundleArguments();
        setFields();
        return view;
    }

    public void onAttach(Context context) {
        if (getActivity() != null && getActivity().getApplication() instanceof HackerNewsApplication) {
            DaggerStoryDetailComponent
                    .builder()
                    .appComponent(((HackerNewsApplication) getActivity().getApplication()).getApplicationComponent())
                    .storyDetailModule(new StoryDetailModule())
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

    private void getBundleArguments() {
        Bundle args = getArguments();

        if (args != null && args.getParcelable(STORY_DETAIL_ARG_KEY) != null) {
            StoryDetailModel storyDetailModel = args.getParcelable(STORY_DETAIL_ARG_KEY);
            presenter.setStoryDetailModel(storyDetailModel);
        }
    }

    private void setFields() {
        StoryDetailModel storyDetailModel = presenter.getStoryDetailModel();

        if (storyDetailModel != null) {
            titleValueTextView.setText(storyDetailModel.getTitle());
            authorValueTextView.setText(storyDetailModel.getAuthor());
            creationDateValueTextView.setText(DateUtils.getDateString(storyDetailModel.getTime()));
            scoreValueTextView.setText(String.format(Locale.ENGLISH,"%d", storyDetailModel.getScore()));
            storyIDTextView.setText(String.format(Locale.ENGLISH,"%d", storyDetailModel.getId()));
            storyURLValueTextView.setText(storyDetailModel.getUrl());
        }
    }

}
