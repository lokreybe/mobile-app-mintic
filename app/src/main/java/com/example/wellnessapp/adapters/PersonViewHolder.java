package com.example.wellnessapp.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wellnessapp.R;
import com.example.wellnessapp.model.Person;

public class PersonViewHolder extends RecyclerView.ViewHolder {

    private final ImageView personImageView;
    private final TextView firstNameTextView;
    private final TextView lastNameTextView;
    private final TextView cellphoneTextView;
    private final RelativeLayout personItemLayout;
    private final TextView detailButton;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);

        firstNameTextView = (TextView) itemView.findViewById(R.id.firstNameTextView);
        lastNameTextView =  (TextView) itemView.findViewById(R.id.lastNameTextView);
        cellphoneTextView = (TextView) itemView.findViewById(R.id.cellphoneTextView);
        personImageView = (ImageView) itemView.findViewById(R.id.personImageView);
        personItemLayout = (RelativeLayout) itemView.findViewById(R.id.personItemLayoutRecycler);
        detailButton = (TextView) itemView.findViewById(R.id.detailButton);
    }

    public ImageView getPersonImageView() {
        return personImageView;
    }

    public TextView getFirstNameTextView() {
        return firstNameTextView;
    }

    public TextView getLastNameTextView() {
        return lastNameTextView;
    }

    public TextView getCellphoneTextView() {
        return cellphoneTextView;
    }

    public RelativeLayout getPersonItemLayout() {
        return personItemLayout;
    }

    public TextView getDetailButton() {
        return detailButton;
    }
}

