package org.battir.androidtrainingkotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import org.unrwa.classes.Student
import java.time.LocalDate

class StudentActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        var student:Student= Student(name = "Mohammad",55555,"Yatta", LocalDate.of(1987,5,16),"myStdID",1,"Data science")
        Log.i("Mohammad Age","${student.getAge()}")
    }
}