package org.kotlincode


import java.time.LocalDate

class Student(name: String, id: Int, address:String, DOB: LocalDate,
              val stdID:String, val  level: Int, val collage: String): Person(name,id,address,DOB){}