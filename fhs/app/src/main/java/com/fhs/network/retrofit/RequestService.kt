package com.fhs.network.retrofit

import com.fhs.model.FHSServices
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Ganesh Tikone on 14/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: Network Service Class
 *
 * Write body for REST method declared in RequestInterface
 */

class RequestService(tag:String) {


    /**
     *  request interface object - initialized in constructor
     */
    private val requestInterface: RequestInterface = Retrofit.Builder()
            .baseUrl(FHSEndPoints.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RequestInterface::class.java)


    /**
     * GET API Call
     * GET FHS Service ID / Device ID
     *
     */
    fun getData(): Observable<List<FHSServices>>{

        return requestInterface.getData()
                .retry(FHSEndPoints.API_CALL_RETRY_POLICY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

    }

}