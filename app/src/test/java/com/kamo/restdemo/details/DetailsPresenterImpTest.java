package com.kamo.restdemo.details;
import com.kamo.restdemo.Rx.SchedulerProviderTest;
import com.kamo.restdemo.rxjava.BaseSchedulerProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


/**
 * Created by Jeffrey.Mphahlele on 24/05/2018.
 */
public class DetailsPresenterImpTest {

    private BaseSchedulerProvider schedulerProvider;
    private DetailsPresenterImp presenter;

    @Mock
    private IDetails.View view;


    @Before
    public void setUp() throws Exception {
        schedulerProvider= SchedulerProviderTest.getInstance();
        presenter=new DetailsPresenterImp(view);

    }

    @Test
    public void loadInfo_Results_Ok() throws Exception {

    }

    @Test
    public void loadInfo_Results_Error() throws Exception {
    }
}