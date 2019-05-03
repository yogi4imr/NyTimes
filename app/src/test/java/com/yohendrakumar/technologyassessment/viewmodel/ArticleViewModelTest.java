package com.yohendrakumar.technologyassessment.viewmodel;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;

import com.yohendrakumar.technologyassessment.model.ApiResponse;
import com.yohendrakumar.technologyassessment.model.ResultsItem;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)

public class ArticleViewModelTest {
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();
    @Mock
    ArticleViewModel mArticleViewModel;
    @BeforeClass
    public static void onlyOnce() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
        mArticleViewModel = new ArticleViewModel();
    }

    @Test
    public void getApiResponseLiveData() {

        LiveData<ApiResponse> apiResponseLiveData = mArticleViewModel.getApiResponseLiveData();
        ApiResponse apiResponse  = apiResponseLiveData.getValue();
        ResultsItem resultsItem = apiResponse.getResults().get(0);
        String type = resultsItem.getType();
        String title = resultsItem.getTitle();
        String byLine = resultsItem.getByline();
        Assert.assertEquals(type, "Article");
        Assert.assertEquals(title, "\u2018Game of Thrones\u2019 Season 8, Episode 3 Recap: An Epic Battle Presented at a Human Scale");
        Assert.assertEquals(byLine, "By JEREMY EGNER");
    }


}