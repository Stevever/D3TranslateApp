package com.example.ryan.d3translationapp;

import java.util.ArrayList;

/**
 * Created by ryan on 4/6/16.
 */
public class ArticleList {
	private static ArrayList<Article> sArticleArrayList;
	private static ArticleList sArticleList;

	private ArticleList() {
		// empty private constructor
	}

	private static ArticleList getInstance() {
		if (sArticleList == null) {
			sArticleList = new ArticleList();
		}

		return sArticleList;
	}


}
