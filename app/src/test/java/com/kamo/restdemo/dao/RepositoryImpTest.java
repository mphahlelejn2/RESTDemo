package com.kamo.restdemo.dao;

import com.kamo.restdemo.color.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

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
public class RepositoryImpTest {

    @Mock
    private APIClient client;

    private IRepository  repository;

    @Before
    public void setUp() throws Exception {
        repository=new RepositoryImp(client);
    }


   /* public void loadListOfColors_Results_Ok() {
        List<Color> list=getListOfColors();
        TestObserver<List<Color>> observer = new TestObserver<>();
        //TestSubscriber<List<Color>> wordListTestSubscriber=new TestSubscriber<>();
        //Given
        // Maybe<List<Color>> maybe=repository.getColorList();
        //maybe.subscribe(observer);
        when(repository.getColorList()).thenReturn(Maybe.just(list));

        // when:
        repository.getColorList().subscribe(observer);

        presenter.loadListOfColors();

        //then
        observer.assertNoErrors();
        observer.assertSubscribed();
        observer.assertComplete();

        verify(view).initLoadProgressDialog();
        verify(view,never()).errorLoadingColor();
        verify(view).loadAdaptor(list);
        verify(view,never()).colorListEmpty();
    }*/

    @Test
    public void getColorList() throws Exception {
        List<Color> list= getListOfColors();
        when(client.getColorList()).thenReturn(Maybe.just(list));

        //When
        TestObserver<List<Color>> observer = new TestObserver<>();
        repository.getColorList().subscribe(observer);

        observer.assertNoErrors();
        observer.assertSubscribed();
        observer.assertComplete();
        observer.awaitTerminalEvent();


       // List<List<Color>> onNextEvents = observer.getOnNextEvents();
       // List<Color> users = onNextEvents.get(0);
       // Assert.assertEquals(USER_LOGIN_RIGGAROO, users.get(0).getLogin());
       // Assert.assertEquals(USER_LOGIN_2_REBECCA, users.get(1).getLogin());
       // verify(githubUserRestService).searchGithubUsers(USER_LOGIN_RIGGAROO);
        //verify(githubUserRestService).getUser(USER_LOGIN_RIGGAROO);
        //verify(githubUserRestService).getUser(USER_LOGIN_2_REBECCA);
    }

    @Test
    public void getUserList() throws Exception {
    }

    @Test
    public void getColor() throws Exception {
    }

    private List<Color> getListOfColors() {
        Color c1=new Color();
        Color c2=new Color();
        List<Color> list =new ArrayList<>();
        list.add(c1);
        list.add(c2);
        return list;
    }
}