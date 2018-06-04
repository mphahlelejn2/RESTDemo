package com.kamo.restdemo.color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.kamo.restdemo.R;
import com.kamo.restdemo.base.BaseFragment;
import com.kamo.restdemo.utils.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import dmax.dialog.SpotsDialog;

/**
 * Created by Jeffrey.Mphahlele on 1/16/2018.
 */

public class ListOfColorsFragment extends BaseFragment implements IColor.View{

    @Inject
    public IColor.Presenter presenter;
    private static final String TAG = "ListOfColorsFragment";
    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;
    public SpotsDialog loadImageProgressDialog;
    public ArrayList<Color> colorArrayList;
    public ColorListAdapter adapter;


    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        presenter.loadListOfColors();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.list_of_authors_fragment;
    }

    @Override
    public void filter(String newText) {
        adapter.getFilter().filter(newText);
    }

    @Override
    public void loadAdaptor(List<Color> colors) {
        colorArrayList = new ArrayList<>(colors);
        adapter = new ColorListAdapter(getContext(), colorArrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void dismissLoadDialog() {
        loadImageProgressDialog.dismiss();
    }

    @Override
    public void initLoadProgressDialog() {
        loadImageProgressDialog=new SpotsDialog(getActivity(), "Loading Colors....");
        loadImageProgressDialog.show();
    }

    @Override
    public void errorLoadingColor() {
        ToastUtils.showShortMessage(getActivity(),"Error Loading the Color list");
    }
    @Override
     public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }
    @Override
    public void colorListEmpty() {
        ToastUtils.showShortMessage(getActivity(),"Empty Color List ");
    }

}
