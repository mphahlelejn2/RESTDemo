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
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.never;
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
         Assert.assertEquals(colorList.get(0), list.get(0));
         Assert.assertEquals(colorList.get(1).getThumbnailUrl(), list.get(1).getThumbnailUrl());

    }

    @Test
    public void getColorList_Results_Empty() {

      //  List<Color> list= getListOfColors();
        when(client.getColorList()).thenReturn(Maybe.empty());
        //When
        TestObserver<List<Color>> observer = new TestObserver<>();
        repository.getColorList().subscribe(observer);
        //then

        observer.assertNoErrors();
        observer.assertSubscribed();
        observer.assertComplete();
        observer.awaitTerminalEvent();

        Assert.assertTrue(observer.values().isEmpty());

    }
    @Test
    public void getColorList_Results_Error() {

        Exception exception = new HttpException(
                Response.error(403, ResponseBody.create(MediaType.parse("application/json"), "Cannot execute request")));

        when(client.getColorList())
                .thenReturn(Maybe.error(exception));

        //When
        TestObserver<List<Color>> observer = new TestObserver<>();
        repository.getColorList().subscribe(observer);
        //then

        //Then
        observer.awaitTerminalEvent();
        observer.assertError(HttpException.class);
        verify(client).getColorList();
    }


    @Test
    public void getUserList() {
        List<User> list= getListOfUsers();
        when(client.getUserList()).thenReturn(Maybe.just(list));

        //When
        TestObserver<List<User>> observer = new TestObserver<>();
        repository.getUserList().subscribe(observer);
        //then

        observer.assertNoErrors();
        observer.assertSubscribed();
        observer.assertComplete();
        observer.awaitTerminalEvent();

        List<User> userList=  observer.values().get(0);
        Assert.assertEquals(userList.get(0), list.get(0));
        Assert.assertEquals(userList.get(1).getName(), list.get(1).getName());
    }

    @Test
    public void getColor() {
        List<Color> list= getListOfColors();

        when(client.getColor(anyInt())).thenReturn(Maybe.just(list.get(0)));

        //When
        TestObserver<Color> observer = new TestObserver<>();
        repository.getColor(list.get(0).getId()).subscribe(observer);
        //then

        observer.assertNoErrors();
        observer.assertSubscribed();
        observer.assertComplete();
        observer.awaitTerminalEvent();

        Color color=  observer.values().get(0);
        Assert.assertEquals(color, list.get(0));
        Assert.assertEquals(color.getTitle(), list.get(0).getTitle());

    }

    private List<Color> getListOfColors() {
        return  new Gson().fromJson(TestData.jsonListOfColors, new TypeToken<List<Color>>(){}.getType());
    }

    private List<User> getListOfUsers() {
        return  new Gson().fromJson(TestData.jsonListOfUsers, new TypeToken<List<User>>(){}.getType());
    }

}