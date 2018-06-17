package com.kamo.restdemo.color;

import com.kamo.restdemo.dao.IRepository;
import com.kamo.restdemo.Rx.SchedulerProviderTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Maybe;


/**
 * Created by Jeffrey.Mphahlele on 5/11/2018.
 */
public class ColorPresenterImpTest {

    @Mock
    private IColor.View view;
    @Mock
    private IRepository repository;

    private SchedulerProviderTest scheduler;
    private ColorPresenterImp colorPresenterImp;

    @Before
    public void setUp() throws Exception {
        scheduler=SchedulerProviderTest.getInstance();
        MockitoAnnotations.initMocks(this);
        colorPresenterImp=new ColorPresenterImp(view,repository,scheduler);
    }

    @Test
    public void loadListOfColors_Results_Ok() {
        List<Color> list=getListOfColors();
        //Given
        Mockito.when(repository.getColorList()).thenReturn(Maybe.just(list));
        //when
        colorPresenterImp.loadListOfColors();
        //then
        Mockito.verify(view).initLoadProgressDialog();
        Mockito.verify(view, Mockito.never()).errorLoadingColor();
        Mockito.verify(view).loadAdaptor(list);
        Mockito.verify(view, Mockito.never()).colorListEmpty();
    }

    private List<Color> getListOfColors() {
        Color c1=new Color();
        Color c2=new Color();
        List<Color> list =new ArrayList<>();
        list.add(c1);
        list.add(c2);
        return list;
    }

    @Test
    public void loadListOfColors_Results_Error()
    {
        Exception exception = new Exception();

        Mockito.when(repository.getColorList())
                .thenReturn(Maybe.error(exception));
        colorPresenterImp.loadListOfColors();
        Mockito.verify(view).initLoadProgressDialog();
        Mockito.verify(view).errorLoadingColor();
        Mockito.verify(view, Mockito.never()).loadAdaptor(getListOfColors());
        Mockito.verify(view, Mockito.never()).colorListEmpty();
    }

    @Test
    public void loadListOfColors_Results_Empty()
    {
        //Given
        Mockito.when(repository.getColorList()).thenReturn(Maybe.empty());
        //when
        colorPresenterImp.loadListOfColors();
        //then
        Mockito.verify(view, Mockito.never()).errorLoadingColor();
        Mockito.verify(view, Mockito.never()).loadAdaptor(getListOfColors());

        Mockito.verify(view, Mockito.times(1)).colorListEmpty();
        Mockito.verify(view).colorListEmpty();
    }

}