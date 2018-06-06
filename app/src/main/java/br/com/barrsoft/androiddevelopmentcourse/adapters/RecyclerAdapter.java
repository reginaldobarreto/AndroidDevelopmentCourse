package br.com.barrsoft.androiddevelopmentcourse.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import br.com.barrsoft.androiddevelopmentcourse.R;
import br.com.barrsoft.androiddevelopmentcourse.models.Payload;
import br.com.barrsoft.androiddevelopmentcourse.models.RocketModel;
import br.com.barrsoft.androiddevelopmentcourse.utils.ViewHolder;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<RocketModel> rocketModels;

    public RecyclerAdapter(List<RocketModel> rocketModel) {
        this.rocketModels = rocketModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RocketModel rocketModel = rocketModels.get(position);


        holder.rocketName.setText("Rocket: " + rocketModel.getRocket().getRocketName() );
        holder.lauchdate.setText("Date: " + rocketModel.getLaunchdate());
        if (rocketModel.getLaunchsuccess()){
            holder.lauchsuccess.setText("Launched Success");
        }else{
            holder.lauchsuccess.setText("Launched Fail");
        }
        String payloadtype = "";
        for (Payload payload: rocketModel.getRocket().getSecondStage().getPayloads()) {
            payloadtype += "," + payload.getPayloadType() ;

        }
        if(payloadtype.startsWith(",")){
            payloadtype = payloadtype.replaceFirst(",","");
        }

        holder.payLoad.setText("Payload: " + payloadtype);
    }

    @Override
    public int getItemCount() {
        return rocketModels.size();
    }
}