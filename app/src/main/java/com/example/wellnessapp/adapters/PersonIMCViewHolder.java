package com.example.wellnessapp.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wellnessapp.R;

public class PersonIMCViewHolder extends RecyclerView.ViewHolder {

    private final ImageView personImageView;
    private final TextView heightTextView;
    private final TextView weightTextView;
    private final TextView ageTextView;
    private final TextView dateTextView;
    private final RelativeLayout personItemLayout;
    private final TextView detailButton;

    public PersonIMCViewHolder(@NonNull View itemView) {
        super(itemView);

        heightTextView = (TextView) itemView.findViewById(R.id.heightTextView);
        weightTextView =  (TextView) itemView.findViewById(R.id.weightTextView);
        ageTextView = (TextView) itemView.findViewById(R.id.ageTextView);
        dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
        personImageView = (ImageView) itemView.findViewById(R.id.personImageView);
        personItemLayout = (RelativeLayout) itemView.findViewById(R.id.personItemLayoutRecycler);
        detailButton = (TextView) itemView.findViewById(R.id.detailButton);
    }

    public ImageView getPersonImageView() {
        return personImageView;
    }

    public TextView getHeightTextView() {
        return heightTextView;
    }

    public TextView getWeightTextView() {
        return weightTextView;
    }

    public TextView getAgeTextView() {
        return ageTextView;
    }

    public TextView getDateTextView() {
        return dateTextView;
    }

    public RelativeLayout getPersonItemLayout() {
        return personItemLayout;
    }

    public TextView getDetailButton() {
        return detailButton;
    }
}