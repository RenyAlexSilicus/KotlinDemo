package com.sysanenet.filmystan.network

/**
 * Created by ganeshtikone on 20/3/18.
 * File: API Endpoints Singletone class
 */

object APIEndPoints{

    private val URL_ROOT = "http://www.sysandnet.com/filmystanapi/public/api/v1/"

    val RANDOM_DIALOG_URL = URL_ROOT + "randomDialog"
    val RECENT_DIALOG_URL = URL_ROOT + "recent"
    val DIALOUGE_DETAIL_DIALOG_URL = URL_ROOT + "dialog/"
    val POPULAR_DETAIL_DIALOG_URL = URL_ROOT + "popular"
    val MOVIES_DIALOG_URL = URL_ROOT + "movie/"
    val SEARCH_MOVIES_URL = URL_ROOT + "searchMovie/"
}