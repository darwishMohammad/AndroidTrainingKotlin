package org.unrwa.classes

import androidx.annotation.StringRes

data class Question(@StringRes val textResId: Int, val answer: Boolean)