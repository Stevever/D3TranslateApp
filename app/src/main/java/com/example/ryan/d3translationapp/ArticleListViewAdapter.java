package com.example.ryan.d3translationapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by ryan on 4/6/16.
 */
public class ArticleListViewAdapter extends ArrayAdapter {
	public ArticleListViewAdapter(Context context, int resource, int textViewResourceId, List objects) {
		super(context, resource, textViewResourceId, objects);
	}
}
