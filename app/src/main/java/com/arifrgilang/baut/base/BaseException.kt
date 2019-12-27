/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:16 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:16 AM
 *
 */

package com.arifrgilang.baut.base

class BaseException : Exception {

    val responseCode: Int
    val response: BaseResponse

    constructor(mBaseResponse: BaseResponse) {
        this.response = mBaseResponse
        this.responseCode = 200
    }

    constructor(baseResponse: BaseResponse, responseCode: Int) {
        this.response = baseResponse
        this.responseCode = responseCode
    }
}
