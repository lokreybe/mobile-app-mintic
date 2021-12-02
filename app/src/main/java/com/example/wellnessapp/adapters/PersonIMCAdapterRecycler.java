package com.example.wellnessapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wellnessapp.R;
import com.example.wellnessapp.interfaces.CustomClickListener;
import com.example.wellnessapp.model.Person;
import com.example.wellnessapp.model.PersonIMC;

import java.util.List;

public class PersonIMCAdapterRecycler extends RecyclerView.Adapter<PersonIMCViewHolder>  {

    Context context;
    LayoutInflater inflater;
    private final int layout;
    Person person;
    List<PersonIMC> personIMCS;
    CustomClickListener customClickListener;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param ArrayList Person containing the data to populate views to be used
     * by RecyclerView.
     */
    public PersonIMCAdapterRecycler(Context context, int layout, Person person, CustomClickListener customClickListener) {
        this.context = context;
        this.layout = layout;
        this.person = person;
        this.personIMCS = person.getImcs();
        this.customClickListener = customClickListener;
        inflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public PersonIMCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(layout, null);
        return new PersonIMCViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(PersonIMCViewHolder viewHolder, final int position) {

        // Get element from your List at this position and replace the
        // contents of the view with that element
        PersonIMC  imc = personIMCS.get(position);

        // Fecha, Edad, Estatura, Peso

        viewHolder.getDateTextView().setText(imc.getDate() );
        viewHolder.getAgeTextView().setText(Byte.toString(imc.getAge()));
        viewHolder.getHeightTextView().setText(imc.getHeight()+" mts");
        viewHolder.getWeightTextView().setText(imc.getWeight() + " kg");


        ImageView personImageView = viewHolder.getPersonImageView();
        RelativeLayout personItemLayout = viewHolder.getPersonItemLayout();
        if (position % 2 == 0) {
            personItemLayout.setBackgroundResource(R.color.white); //R.color.white)
            personImageView.setImageDrawable(context.getDrawable(R.drawable.ic_account_circle_grey600_48dp));
        } else {
            //personItemLayout.setBackgroundResource(R.color.teal_200);
            personItemLayout.setBackgroundColor(Color.LTGRAY);
            personImageView.setImageDrawable(context.getDrawable(R.drawable.ic_account_circle_white_48dp));
        }

        TextView detailButton = viewHolder.getDetailButton();
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View itemView) {
                Toast.makeText(itemView.getContext(), "Element " + viewHolder.getBindingAdapterPosition() + " clicked.", Toast.LENGTH_SHORT).show();
                customClickListener.onClick(person.getCellphone());
            }
        });
    }

    // Return the size of your List (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return personIMCS.size();
    }

}
