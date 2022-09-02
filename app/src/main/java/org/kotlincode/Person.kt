package org.kotlincode

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period

open class Person(val name: String, val id: Int, val address: String, val DOB: LocalDate? = null) {
    @RequiresApi(Build.VERSION_CODES.O)
    final fun getAge(): Pair<Int, Int> {
        if (DOB != null) {
            var age: Period = Period.between(DOB, LocalDate.now())
            return Pair(age.getYears(), age.getMonths())
        } else {
            return Pair(0, 0)
        }
    }
}