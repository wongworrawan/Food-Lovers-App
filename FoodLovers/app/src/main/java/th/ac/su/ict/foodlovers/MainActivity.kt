package th.ac.su.ict.foodlovers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_food_lovers.*
import kotlinx.android.synthetic.main.list_item_food_lovers.view.*
import th.ac.su.ict.foodlovers.Utils.getJsonDataFromAsset
import th.ac.su.ict.foodlovers.data.Foodlovers
import th.ac.su.ict.foodlovers.data.FoodloversAdapter

class MainActivity : AppCompatActivity() {
    var itemList:ArrayList<Foodlovers> = ArrayList<Foodlovers>()
    lateinit var arrayAdapter: ArrayAdapter<Foodlovers>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext, "foodlovers_data.json")
       // Log.i("data", jsonFileString!!)
        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Foodlovers>>(){}.type

        var foodList : ArrayList<Foodlovers> = gson.fromJson(jsonFileString,listItemType)

       // Log.i("data", foodList[0].menuName)
        itemList = foodList
        val adapter = FoodloversAdapter(this@MainActivity,itemList)
        listView.adapter = adapter






        
        listView.setOnItemClickListener { parent, view, position, id ->
            var intent = Intent(this@MainActivity,DetailActivity::class.java)
            intent.putExtra("menuName",itemList[position].menuName)
            intent.putExtra("location",itemList[position].location)
            intent.putExtra("rate",itemList[position].rate)
            intent.putExtra("imageFile",itemList[position].imageFile)
            intent.putExtra("description",itemList[position].description)
            intent.putExtra("icon",itemList[position].icon)




            startActivity(intent)


        }





    }
}