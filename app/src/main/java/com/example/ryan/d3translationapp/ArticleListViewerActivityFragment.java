package com.example.ryan.d3translationapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ArticleListViewerActivityFragment extends Fragment {

	private ListView mListView;

	public ArticleListViewerActivityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_article_list_viewer, container, false);
		mListView = (ListView) view.findViewById(R.id.article_list_view);
		return view;
	}
}
