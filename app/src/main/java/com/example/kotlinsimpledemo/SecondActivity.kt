package com.example.kotlinsimpledemo

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsimpledemo.Adapter.SecondAdapter
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset


class SecondActivity : AppCompatActivity() {
    var name = arrayListOf<String>()
    var type = arrayListOf<String>()

    private var personNames = ArrayList<String>()
    private var emailIds = ArrayList<String>()
    private var mobileNumbers = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "New Activity"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val mIntent = intent
        val intValue = mIntent.getIntExtra("image", 0)
        val stringvalue = mIntent.getStringExtra("name")
        val stringdescvalue = mIntent.getStringExtra("desc")

        var imageview = findViewById(R.id.maincatimageview) as ImageView
        imageview.setImageResource(intValue)

        actionbar.setTitle(stringvalue)

//        read_json()

        val recyclerView = findViewById(R.id.secondrecycclerview) as RecyclerView
        // set a LinearLayoutManager with default vertical orientation
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager

        try {
            // since we have JSON object, so we are getting the object
            //here we are calling a function and that function is returning the JSON object
            val obj = JSONObject(loadJSONFromAsset())
            // fetch JSONArray named users by using getJSONArray
            val userArray = obj.getJSONArray("users")
            // implement for loop for getting users data i.e. name, email and contact
            for (i in 0 until userArray.length()) {
                // create a JSONObject for fetching single user data
                val userDetail = userArray.getJSONObject(i)
                // fetch email and name and store it in arraylist
                personNames.add(userDetail.getString("name"))
                emailIds.add(userDetail.getString("email"))
                // create a object for getting contact data from JSONObject
                val contact = userDetail.getJSONObject("contact")
                // fetch mobile number 1 and store it in arraylist of mobileNumber
                mobileNumbers.add(contact.getString("mobile1"))
            }
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }

        val customAdapter = SecondAdapter(this@SecondActivity, personNames, emailIds, mobileNumbers)
        recyclerView.adapter = customAdapter // set th
    }

    /*private fun read_json() {
        var json : String? = null
        try {
            val inputStream:InputStream  =  assets.open("First.json")
            json = inputStream.bufferedReader().use { it.readText() }

            var jsonArray = JSONArray(json)

            for (i in 0..jsonArray.length()-1 ){
                var jsonobj = jsonArray.getJSONObject(i)
                name.add(jsonobj.getString("name"))
                type.add(jsonobj.getString("Type"))
            }
            var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,name)
            json_list.adapter = adapter
            json_list.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
                Toast.makeText(applicationContext,"Type Selected is:" + type[i], Toast.LENGTH_LONG).show()
            }
        }catch (e:IOException){

        }

    }*/

    private fun loadJSONFromAsset(): String? {
        //function to load the JSON from the Asset and return the object
        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val `is` = assets.open("First.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
