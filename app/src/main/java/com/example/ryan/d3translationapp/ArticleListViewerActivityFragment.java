package com.example.ryan.d3translationapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ArticleListViewerActivityFragment extends Fragment implements View.OnClickListener {

	private ListView mListView;
	private Button button;

	public ArticleListViewerActivityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_article_list_viewer, container, false);
		mListView = (ListView) view.findViewById(R.id.article_list_view);
		button = (Button) view.findViewById(R.id.button2);
		button.setOnClickListener(this);
		return view;
	}


	@Override
	public void onClick(View v) {
		Intent intent = new Intent(getActivity(), ArticleActivity.class);
		startActivity(intent);
	}
}
