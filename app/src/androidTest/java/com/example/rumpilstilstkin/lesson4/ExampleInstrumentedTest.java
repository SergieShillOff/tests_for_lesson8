package com.example.rumpilstilstkin.lesson4;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;


import com.example.rumpilstilstkin.lesson4.data.models.RepsModel;
import com.example.rumpilstilstkin.lesson4.data.rest.NetApiClientInterface;
import com.example.rumpilstilstkin.lesson4.presenters.home.RepsPresenter;
import com.example.rumpilstilstkin.lesson4.presenters.home.RepsView;
import com.example.rumpilstilstkin.lesson4.ui.home.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    MainActivity activity;

    @Mock
    private NetApiClientInterface client;

    @Before
    public void init() {
        activity = rule.getActivity();
    }

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.rumpilstilstkin.lesson4", appContext.getPackageName());
    }

    @Test
    public void showStateTest() {

        RepsModel model = new RepsModel();
        List<RepsModel> list = new ArrayList<>();
        list.add(model);
        when(activity.providePresenter()).thenReturn(new RepsPresenter(client));
        when(client.getReps()).thenReturn(Flowable.just(list));

        verify(activity).showName(model.owner.getLogin());
        verify(activity).showImage(model.owner.getAvatar());
    }

    @Test
    public void showEmptyStateTest() {

        List<RepsModel> list = new ArrayList<>();
        when(activity.providePresenter()).thenReturn(new RepsPresenter(client));
        when(client.getReps()).thenReturn(Flowable.just(list));

        verifyNoMoreInteractions(activity);
    }

    @Test
    public void hideLoadingTest() {

        RepsModel model = new RepsModel();
        List<RepsModel> list = new ArrayList<>();
        list.add(model);
        when(activity.providePresenter()).thenReturn(new RepsPresenter(client));
        when(client.getReps()).thenReturn(Flowable.just(list));

        verify(activity).hideLoading();
        
    }
}
