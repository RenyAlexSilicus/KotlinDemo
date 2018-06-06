package com.fhs.network.retrofit

import com.fhs.model.FHSServices
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * Created by Ganesh Tikone on 14/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Interface: Retrofit REST Service Interface
 *
 * This Interface is only used for declaration of REST methods
 * Declare all type of REST services required for application
 * such as login, signup etc.
 */
interface RequestInterface {

    @GET(FHSEndPoints.LOGINURL)
    fun getData(): Observable<List<FHSServices>>

}