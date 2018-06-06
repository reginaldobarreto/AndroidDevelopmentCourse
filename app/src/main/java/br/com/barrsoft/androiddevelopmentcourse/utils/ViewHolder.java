package br.com.barrsoft.androiddevelopmentcourse.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.barrsoft.androiddevelopmentcourse.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewHolder extends RecyclerView.ViewHolder {

    public @BindView(R.id.textViewRocketName)
    TextView rocketName;
    public @BindView(R.id.textViewLaunchDate)
    TextView lauchdate;
    public @BindView(R.id.textViewLaunchSuccess)
    TextView lauchsuccess;
    public @BindView(R.id.textViewPayLoad)
    TextView payLoad;


    public ViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);
    }
}
