/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:19 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:19 AM
 *
 */

package com.arifrgilang.baut.base

class ResponseObject<Model>: BaseResponse() {
    var data: Model ?= null
}