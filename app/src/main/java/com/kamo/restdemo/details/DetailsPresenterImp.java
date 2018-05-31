package com.kamo.restdemo.details;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.kamo.restdemo.base.BasePresenter;
import com.kamo.restdemo.color.Color;
import javax.inject.Inject;


/**
 * Created by Jeffrey.Mphahlele on 2/9/2018.
 */

public class DetailsPresenterImp extends BasePresenter implements IDetails.Presenter {

    private IDetails.View view;

    @Inject
    public DetailsPresenterImp(IDetails.View view) {
        this.view = view;
    }

    @Override
    public void loadInfo(Color color, ImageView imageView) {
        Glide.with(view.getContext())
                .load(color.getUrl()+"png")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .fitCenter()
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .into(imageView);
    }
}
