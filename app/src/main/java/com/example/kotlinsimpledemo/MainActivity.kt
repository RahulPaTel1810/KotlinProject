package com.example.kotlinsimpledemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsimpledemo.Adapter.MainCatAdapter
import com.example.kotlinsimpledemo.Model.MainCatList
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var navView: NavigationView

    @SuppressLint("WrongConstant")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  recyclerView = findViewById(R.id.maincatrecyclerview) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val mainCatList = ArrayList<MainCatList>()
        mainCatList.add(MainCatList(R.drawable.relievecramps,"Relieve Menstrual Cramps","Loosen Muscles and reduce pains"))
        mainCatList.add(MainCatList(R.drawable.lowerbackpainrelief,"Lower back pain relief ","Loosen Muscles and reduce pains"))
        mainCatList.add(MainCatList(R.drawable.kneepainrelief,"Knee pain relied","Relieve pain and strengthen weal knees"))
        mainCatList.add(MainCatList(R.drawable.shoulder_stretch,"Shoulder tension relief","Fast relieve shoulder tension and prevent"))
        mainCatList.add(MainCatList(R.drawable.neckshoulderstretching,"Neck & shoulder tension relief","Loosen Muscles and reduce pains"))
        mainCatList.add(MainCatList(R.drawable.backstretchingseven,"Back stretching 7 min","Loosen Muscles and reduce pains"))
        mainCatList.add(MainCatList(R.drawable.lowerbodystretching,"Lower body stretching 15 min","Loosen Muscles and reduce pains"))
        mainCatList.add(MainCatList(R.drawable.fullbodystretching,"Full body stretching","Relieve pain and strengthen weal knees"))
        mainCatList.add(MainCatList(R.drawable.lowerbodystretchingseven,"Lower body stretching 7 min","Fact relieve shoulder tension and prevent"))
        mainCatList.add(MainCatList(R.drawable.upperbodystretching,"Upper body stretching","Loosen Muscles and reduce pains"))

        val adapter = MainCatAdapter(mainCatList)
        recyclerView.adapter = adapter


        //DrawerMenu Code
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        drawerLayout = findViewById(R.id.drawerlayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> {
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_messages -> {
                Toast.makeText(this, "Messages clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_friends -> {
//                Toast.makeText(this, "Friends clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,FriendsActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_update -> {
                Toast.makeText(this, "Update clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Sign out clicked", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menulist, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.item1 -> {
                Toast.makeText(this,"Click On Item1",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item2 -> {
                Toast.makeText(this,"Click On Item2",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item3 -> {
                Toast.makeText(this,"Click On Item3",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item4 -> {
                Toast.makeText(this,"Click On Item4",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.subitem1 -> {
                Toast.makeText(this,"Click On SubItem1",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.subitem2 -> {
                Toast.makeText(this,"Click On SubItem2",Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
