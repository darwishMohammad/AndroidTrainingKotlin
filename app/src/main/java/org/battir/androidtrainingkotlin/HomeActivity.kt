package org.battir.androidtrainingkotlin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import org.battir.androidtrainingkotlin.databinding.ActivityHomeBinding
const val EXTRA_MESSAGE:String =    "org.battir.androidtrainingkotlin.extra.MESSAGE"

class HomeActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarHome.toolbar)

        binding.appBarHome.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



        //region Adding OnClickListener
        findViewById<Button>(R.id.btn_activitylifecycle).setOnClickListener(this)
        findViewById<Button>(R.id.btn_scrollActivity).setOnClickListener(this)
        findViewById<Button>(R.id.btn_dialphone).setOnClickListener(this)
        findViewById<Button>(R.id.btn_opengoogle).setOnClickListener(this)
        findViewById<Button>(R.id.btn_passdata).setOnClickListener(this)
        findViewById<Button>(R.id.btn_getresult).setOnClickListener(this)
        //endregion

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



    // Receiver
    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                //val value = it.data?.getStringExtra("input")
                val bund: Bundle? =it.data?.extras
                if (bund != null) {
                    Log.i("Name",""+bund.getCharSequence("Name"))
                    Toast.makeText(this,"Your name is :${bund.getCharSequence("Name")}",Toast.LENGTH_LONG).show()
                }
            }
        }
    override fun onClick(vu: View?) {
        when(vu!!.id){
            R.id.btn_activitylifecycle -> {
                startActivity(Intent(this@HomeActivity, ActivityLifeCycle::class.java))
            }
            R.id.btn_scrollActivity -> {
                startActivity(Intent(this@HomeActivity, ScrollTextActivity::class.java))
            }
            R.id.btn_opengoogle -> {
                var uri: Uri = Uri.parse("http://www.google.com")
                var it:Intent = Intent(Intent.ACTION_VIEW,uri)
                startActivity(it)
            }
            R.id.btn_dialphone -> {
                var uri: Uri = Uri.parse("tel:+972568474940")
                var it:Intent = Intent(Intent.ACTION_DIAL,uri)
                startActivity(it)
            }
            R.id.btn_passdata -> {
                var message: String = "Hello Activity Two!"
                val intent:Intent = Intent(this, MainActivity2::class.java)
                intent.putExtra(EXTRA_MESSAGE, message)
                startActivity(intent)
            }
            R.id.btn_getresult -> {
                // Caller
                val intent = Intent(this, UserInputActivity::class.java)
                getResult.launch(intent)
            }

        }
    }
}