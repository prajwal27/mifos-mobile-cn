package org.mifos.mobile.cn.data.datamanager

import io.reactivex.Observable
import org.mifos.mobile.cn.data.local.PreferencesHelper
import org.mifos.mobile.cn.data.models.Authentication
import org.mifos.mobile.cn.data.remote.BaseApiManager
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Rajan Maurya
 * On 22/01/18.
 */
@Singleton
class DataManagerAuth @Inject constructor(private val baseApiManager: BaseApiManager,
                                          private val preferencesHelper: PreferencesHelper) {


    /**
     * Login with iCommit Account
     * Logging the Username and password with Basic Authentication
     * @loginRequest LoginRequest
     *//*
    fun login(loginRequest: LoginRequest): Observable<LoginResponse> {
        return baseApiManager.getAuthApi().login(loginRequest)
                .retry(2)
                .concatMap({ loginResponse ->
                    preferencesHelper.putAccessToken(loginResponse.authToken)
                    preferencesHelper.putLoginStatus(true)
                    return@concatMap Observable.just(loginResponse)
                })
    }


    *//**
     * Fake Login with iCommit Account
     *//*
    fun fakeLogin(loginRequest: LoginRequest): Observable<LoginResponse> {
        return Observable.just(FakeRemoteDataSource.getLoginResponse())
                .concatMap({ loginResponse ->
                    preferencesHelper.putAccessToken(loginResponse.authToken)
                    preferencesHelper.putLoginStatus(true)
                    return@concatMap Observable.just(loginResponse)
                })
    }*/
    fun refreshToken(): Observable<Authentication> {
        return baseApiManager.getAuthApi().refreshToken()
    }
}