package com.kamo.restdemo.user;

import com.kamo.restdemo.Rx.SchedulerProviderTest;
import com.kamo.restdemo.dao.IRepository;
import com.kamo.restdemo.rxjava.BaseSchedulerProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Maybe;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Jeffrey.Mphahlele on 24/05/2018.
 */
public class UserPresenterImpTest {


    private IUser.Presenter presenter;
    private BaseSchedulerProvider schedulerProvider;
    @Mock
    private IUser.View view;
    @Mock
    private IRepository repository;


    @Before
    public void setUp() throws Exception {
        schedulerProvider= SchedulerProviderTest.getInstance();
        MockitoAnnotations.initMocks(this);
        presenter=new UserPresenterImp(view,repository,schedulerProvider);
    }

    @Test
    public void loadFullAuthorList_Results_Ok() throws Exception {
        List<User> userlist=getUserList();
        when(repository.getUserList()).thenReturn(Maybe.just(userlist));
        presenter.loadFullAuthorList();
        verify(view).initLoadProgressDialog();
        verify(view,never()).ErrorloadingFullAuthorList();
        verify(view).loadAdaptor(userlist);
        verify(view,never()).emptyAuthorList();
    }

    private List<User> getUserList() {
        User u1=new User();
        User u2=new User();
        List<User> userList=new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        return userList;
    }

    @Test
    public void loadFullAuthorList_Results_Error() throws Exception {
        Exception e=new Exception();
        List<User> userlist=getUserList();
        when(repository.getUserList()).thenReturn(Maybe.error(e));
        presenter.loadFullAuthorList();
        verify(view).initLoadProgressDialog();
        verify(view).ErrorloadingFullAuthorList();
        verify(view,never()).loadAdaptor(userlist);
        verify(view,never()).emptyAuthorList();

    }

    @Test
    public void loadFullAuthorList_Results_Empty() throws Exception {

        List<User> userlist=getUserList();
        when(repository.getUserList()).thenReturn(Maybe.empty());
        presenter.loadFullAuthorList();
        verify(view).initLoadProgressDialog();
        verify(view,never()).ErrorloadingFullAuthorList();
        verify(view,never()).loadAdaptor(userlist);
        verify(view).emptyAuthorList();

    }

}