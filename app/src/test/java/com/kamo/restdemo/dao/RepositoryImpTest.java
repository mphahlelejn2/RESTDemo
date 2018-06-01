package com.kamo.restdemo.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kamo.restdemo.color.Color;
import com.kamo.restdemo.user.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Jeffrey.Mphahlele on 2018/05/29.
 */
public class RepositoryImpTest{

    @Mock
    private APIClient client;
    private IRepository  repository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        repository=new RepositoryImp(client);
    }

   @Test
    public void getColorList_Results_Ok() {
       
        List<Color> list= getListOfColors();
        when(client.getColorList()).thenReturn(Maybe.just(list));

        //When
        TestObserver<List<Color>> observer = new TestObserver<>();
        repository.getColorList().subscribe(observer);
        //then

        observer.assertNoErrors();
        observer.assertSubscribed();
        observer.assertComplete();
        observer.awaitTerminalEvent();

       List<Color> colorList=  observer.values().get(0);
       // Color c= (Color) observer.getEvents().get(1);
         Assert.assertEquals(colorList.get(0), list.get(0));
         Assert.assertEquals(colorList.get(1).getThumbnailUrl(), list.get(1).getThumbnailUrl());

    }

    @Test
    public void getUserList() {

    }

    @Test
    public void getColor() {

    }

    private List<Color> getListOfColors() {
        return  new Gson().fromJson(TestData.jsonListOfColors, new TypeToken<List<Color>>(){}.getType());
    }
}