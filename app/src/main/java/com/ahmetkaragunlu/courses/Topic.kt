package com.ahmetkaragunlu.courses

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val stringResource : Int,
                 val modelVersion: Int,
                 @DrawableRes val imageResource: Int)
