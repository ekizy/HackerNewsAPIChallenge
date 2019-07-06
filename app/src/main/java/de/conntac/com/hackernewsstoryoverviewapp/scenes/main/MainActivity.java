package de.conntac.com.hackernewsstoryoverviewapp.scenes.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import butterknife.ButterKnife;
import de.conntac.com.hackernewsstoryoverviewapp.R;
import de.conntac.com.hackernewsstoryoverviewapp.network.StoryDetailModel;
import de.conntac.com.hackernewsstoryoverviewapp.scenes.storiesoverview.StoriesOverviewFragment;
import de.conntac.com.hackernewsstoryoverviewapp.scenes.storydetail.StoryDetailFragment;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportFragmentManager().addOnBackStackChangedListener(this);

        if (savedInstanceState == null) {
            openStoryOverview();
        }
    }

    public void openStoryDetail(StoryDetailModel detailModel) {
        StoryDetailFragment storyDetailFragment = StoryDetailFragment.newInstance(detailModel);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_layout_main_container, storyDetailFragment);
        fragmentTransaction.addToBackStack(StoryDetailFragment.TAG);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void openStoryOverview() {
        StoriesOverviewFragment storiesOverviewFragment = new StoriesOverviewFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_layout_main_container, storiesOverviewFragment);
        fragmentTransaction.addToBackStack(StoriesOverviewFragment.TAG);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onBackStackChanged() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_layout_main_container);
        int titleID;

        if (fragment instanceof StoryDetailFragment) {
            titleID = R.string.story_detail_screen_title;
        } else if (fragment instanceof StoriesOverviewFragment) {
            titleID = R.string.stories_overview_screen_title;
        } else {
            titleID = R.string.app_name;
        }

        setTitle(titleID);
    }
}
