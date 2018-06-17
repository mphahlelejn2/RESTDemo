package com.kamo.restdemo.user;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.kamo.restdemo.R;
import com.kamo.restdemo.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import butterknife.BindView;
import dmax.dialog.SpotsDialog;

/**
 * Created by Jeffrey.Mphahlele on 1/16/2018.
 */

public class ListOfUsersFragment extends BaseFragment implements IUser.View {

    @Inject
    public IUser.Presenter presenter;
    private static final String TAG = "ListOfColorsFragment";
    private ArrayList<User> userArrayList;
    private UserListAdapter adapter;

    @BindView(R.id.user_recycler_view)
    public RecyclerView recyclerView;
    public SpotsDialog loadImageProgressDialog;

      @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
          RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
          recyclerView.setLayoutManager(mLayoutManager);
          presenter.loadFullAuthorList();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.list_of_users_fragment;
    }

    @Override
    public void filter(String newText) {
        adapter.getFilter().filter(newText);
    }


    @Override
    public void loadAdaptor(List<User> colors) {
        userArrayList =new ArrayList<>(colors);
        adapter=new UserListAdapter( userArrayList,getContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void dismissLoadDialog() {
        loadImageProgressDialog.dismiss();
    }

    @Override
    public void initLoadProgressDialog() {
        loadImageProgressDialog=new SpotsDialog(getActivity(), "Loading User....");
        loadImageProgressDialog.show();
    }

    @Override
    public void ErrorloadingFullAuthorList() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.destroy();
    }

    @Override
    public void emptyAuthorList() {

    }
}

