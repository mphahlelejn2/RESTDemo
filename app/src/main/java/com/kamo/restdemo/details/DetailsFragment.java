package com.kamo.restdemo.details;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kamo.restdemo.base.BaseFragment;
import com.kamo.restdemo.color.Color;
import com.kamo.restdemo.R;
import javax.inject.Inject;
import butterknife.BindView;
import dmax.dialog.SpotsDialog;

/**
 * Created by Jeffrey.Mphahlele on 1/18/2018.
 */

public class DetailsFragment extends BaseFragment implements IDetails.View {

    @Inject
    public IDetails.Presenter presenter;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.summary)
    TextView summary;
    public SpotsDialog loadImageProgressDialog;

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadInfo();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.details_fragment;
    }

    @Override
    public void filter(String newText) {

    }

    private void loadInfo() {
        Color color = (Color) getActivity().getIntent().getSerializableExtra("data");
        presenter.loadInfo(color,imageView);
        summary.setText(color.getTitle());
    }

    @Override
    public void dismissLoadDialog() {
        loadImageProgressDialog.dismiss();
    }
    @Override
    public void initLoadProgressDialog() {
        loadImageProgressDialog=new SpotsDialog(getActivity(), "Loading ");
        loadImageProgressDialog.show();
    }

    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }
}
