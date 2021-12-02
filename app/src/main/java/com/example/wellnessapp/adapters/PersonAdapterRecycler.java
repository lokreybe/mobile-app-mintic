package com.example.wellnessapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wellnessapp.R;
import com.example.wellnessapp.interfaces.CustomClickListener;
import com.example.wellnessapp.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapterRecycler extends RecyclerView.Adapter<PersonViewHolder>  {

    Context context;
    LayoutInflater inflater;
    private int layout;
    Person person;
    List<Person> personsList;
    CustomClickListener customClickListener;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param ArrayList Person containing the data to populate views to be used
     * by RecyclerView.
     */
    public PersonAdapterRecycler(Context context, int layout, ArrayList<Person> persons, CustomClickListener customClickListener) {
        this.context = context;
        this.layout = layout;
        this.personsList = persons;
        this.customClickListener = customClickListener;
        inflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(layout, null);
        return new PersonViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PersonViewHolder viewHolder, final int position) {

        // Get element from your List at this position and replace the
        // contents of the view with that element
        Person person = personsList.get(position);
        viewHolder.getFirstNameTextView().setText(person.getFirstName());
        viewHolder.getLastNameTextView().setText(person.getLastName());
        viewHolder.getCellphoneTextView().setText(person.getCellphone() + "");

        /**ImageView personImageView = viewHolder.getPersonImageView();
        RelativeLayout personItemLayout = viewHolder.getPersonItemLayout();
        if (position % 2 == 0) {
            personItemLayout.setBackgroundResource(R.color.white); //R.color.white)
            personImageView.setImageDrawable(context.getDrawable(R.drawable.ic_account_circle_grey600_48dp));
        } else {
            //personItemLayout.setBackgroundResource(R.color.teal_200);
            personItemLayout.setBackgroundColor(Color.LTGRAY);
            personImageView.setImageDrawable(context.getDrawable(R.drawable.ic_account_circle_white_48dp));
        } **/

        TextView detailButton = viewHolder.getDetailButton();
        //detailButton.setOnClickListener(View.OnClickListener);
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
        return personsList.size();
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

}

