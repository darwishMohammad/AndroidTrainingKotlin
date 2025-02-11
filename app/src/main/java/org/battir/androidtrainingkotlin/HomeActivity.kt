package org.battir.androidtrainingkotlin

import android.app.Activity
import android.app.DownloadManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE: String = "org.battir.androidtrainingkotlin.extra.MESSAGE"

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //region Adding OnClickListener
        findViewById<Button>(R.id.btn_activitylifecycle).setOnClickListener(this)
        findViewById<Button>(R.id.btn_scrollActivity).setOnClickListener(this)
        findViewById<Button>(R.id.btn_dialphone).setOnClickListener(this)
        findViewById<Button>(R.id.btn_opengoogle).setOnClickListener(this)
        findViewById<Button>(R.id.btn_passdata).setOnClickListener(this)
        findViewById<Button>(R.id.btn_getresult).setOnClickListener(this)
        findViewById<Button>(R.id.btn_savedInstanceActivity).setOnClickListener(this)
        findViewById<Button>(R.id.btn_views_activity).setOnClickListener(this)
        findViewById<Button>(R.id.btn_fragmentActivity).setOnClickListener(this)
        findViewById<Button>(R.id.btn_dialogsActivity).setOnClickListener(this)
        findViewById<Button>(R.id.btn_MenusActivity).setOnClickListener(this)
        findViewById<Button>(R.id.btn_TabsActivity).setOnClickListener(this)
        findViewById<Button>(R.id.btn_LiveDataRecyclerView).setOnClickListener(this)
        //endregion

    }

    // Receiver
    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                //val value = it.data?.getStringExtra("input")
                val bund: Bundle? = it.data?.extras
                if (bund != null) {
                    Log.i("Name", "" + bund.getCharSequence("Name"))
                    Toast.makeText(this,
                        "Your name is :${bund.getCharSequence("Name")}",
                        Toast.LENGTH_LONG).show()
                }
            }
        }

    override fun onClick(vu: View?) {
        when (vu!!.id) {
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
//                val request =
//                    DownloadManager.Request(Uri.parse("https://i.pinimg.com/564x/9d/25/8c/9d258cb09c821961e092b9b459399d9e.jpg"))
//                request.setAllowedOverMetered(true)
//                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
//                var manager: DownloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
////                manager.enqueue(request)
//                val reference: Long = manager.enqueue(request)
//                val downloadIntent = Intent(this, DOWNLOAD_SERVICE::class.java).apply {
//                    data =
//                        Uri.parse("https://i.pinimg.com/564x/9d/25/8c/9d258cb09c821961e092b9b459399d9e.jpg")
//                }
//                startService(downloadIntent)
            }
            R.id.btn_dialphone -> {
                var uri: Uri = Uri.parse("tel:+972568474940")
                var it: Intent = Intent(Intent.ACTION_DIAL, uri)
                startActivity(it)
            }
            R.id.btn_passdata -> {
                var message: String = "Hello Activity Two!"
                val intent: Intent = Intent(this, ReceiveIntentActivity::class.java)
                intent.putExtra(EXTRA_MESSAGE, message)
                startActivity(intent)
            }
            R.id.btn_getresult -> {
                // Caller
                val intent = Intent(this, UserInputActivity::class.java)
                getResult.launch(intent)
            }
            R.id.btn_savedInstanceActivity -> {
                startActivity(Intent(this@HomeActivity, ActivitySavedInstance::class.java))
            }
            R.id.btn_views_activity -> {
                startActivity(Intent(this@HomeActivity, ViewsActivity::class.java))
            }
            R.id.btn_fragmentActivity -> {
                startActivity(Intent(this@HomeActivity, FragmentHostActivity::class.java))
            }
            R.id.btn_dialogsActivity -> {
                startActivity(Intent(this@HomeActivity, DialogsActivity::class.java))
            }
            R.id.btn_MenusActivity -> {
                startActivity(Intent(this@HomeActivity, MenusActivity::class.java))
            }
            R.id.btn_TabsActivity -> {
                startActivity(Intent(this@HomeActivity, TabsActivity::class.java))
            }
            R.id.btn_LiveDataRecyclerView -> {
                startActivity(Intent(this@HomeActivity, LiveDataActivity::class.java))
            }

        }
    }
}