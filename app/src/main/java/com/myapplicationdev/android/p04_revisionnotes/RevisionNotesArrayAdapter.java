package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RevisionNotesArrayAdapter extends ArrayAdapter<Note> {
	Context context;
	ArrayList<Note> notes;
	int resource;
	ImageView iv1, iv2, iv3, iv4, iv5;
	TextView tvContent;

	public RevisionNotesArrayAdapter(Context context, int resource, ArrayList<Note> notes) {
		super(context, resource, notes);
		this.context = context;
		this.notes = notes;
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(resource, parent, false);

		tvContent = (TextView)rowView.findViewById(R.id.textViewNote);

		Note note = notes.get(position);
        int stars = note.getStars();

        tvContent.setText(note.getNoteContent());
		//Check if the property for starts >= 5, if so, "light" up the stars
		if (stars >= 1) {
			if(stars == 1){
				iv5.setImageResource(android.R.drawable.btn_star_big_off);
				iv4.setImageResource(android.R.drawable.btn_star_big_off);
				iv3.setImageResource(android.R.drawable.btn_star_big_off);
				iv2.setImageResource(android.R.drawable.btn_star_big_off);
				iv1.setImageResource(android.R.drawable.btn_star_big_on);
			}else if(stars == 2){
				iv5.setImageResource(android.R.drawable.btn_star_big_off);
				iv4.setImageResource(android.R.drawable.btn_star_big_off);
				iv3.setImageResource(android.R.drawable.btn_star_big_off);
				iv2.setImageResource(android.R.drawable.btn_star_big_on);
				iv1.setImageResource(android.R.drawable.btn_star_big_on);
			}else if(stars == 3){
				iv5.setImageResource(android.R.drawable.btn_star_big_off);
				iv4.setImageResource(android.R.drawable.btn_star_big_off);
				iv3.setImageResource(android.R.drawable.btn_star_big_on);
				iv2.setImageResource(android.R.drawable.btn_star_big_on);
				iv1.setImageResource(android.R.drawable.btn_star_big_on);
			}else if(stars == 4){
				iv5.setImageResource(android.R.drawable.btn_star_big_off);
				iv4.setImageResource(android.R.drawable.btn_star_big_on);
				iv3.setImageResource(android.R.drawable.btn_star_big_on);
				iv2.setImageResource(android.R.drawable.btn_star_big_on);
				iv1.setImageResource(android.R.drawable.btn_star_big_on);
			}else{
				iv5.setImageResource(android.R.drawable.btn_star_big_on);
				iv4.setImageResource(android.R.drawable.btn_star_big_on);
				iv3.setImageResource(android.R.drawable.btn_star_big_on);
				iv2.setImageResource(android.R.drawable.btn_star_big_on);
				iv1.setImageResource(android.R.drawable.btn_star_big_on);
			}
		}

		return rowView;
	}



}
