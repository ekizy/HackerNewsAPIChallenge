package de.conntac.com.hackernewsstoryoverviewapp.network;

public class StoryModel {

    private int storyIndex;
    private StoryDetailModel storyDetailModel;

    public StoryModel(int storyIndex) {
        this.storyIndex = storyIndex;
    }

    public int getStoryIndex() {
        return storyIndex;
    }

    public StoryDetailModel getStoryDetailModel() {
        return storyDetailModel;
    }

    public void setStoryDetailModel(StoryDetailModel storyDetailModel) {
        this.storyDetailModel = storyDetailModel;
    }

    public void setStoryIndex(int storyIndex) {
        this.storyIndex = storyIndex;
    }

}
