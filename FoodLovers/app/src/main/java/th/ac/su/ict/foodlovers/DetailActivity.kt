package th.ac.su.ict.foodlovers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.imgRate
import kotlinx.android.synthetic.main.activity_detail.tvLocation
import kotlinx.android.synthetic.main.activity_detail.tvTitle
import kotlinx.android.synthetic.main.list_item_food_lovers.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val menuName = intent.getStringExtra("menuName")
        val location = intent.getStringExtra("location")
        val rate = intent.getStringExtra("rate")
        val imageFile = intent.getStringExtra("imageFile")
        val description = intent.getStringExtra("description")
        val icon = intent.getStringExtra("icon")



        tvTitle.setText(menuName)
        tvLocation.setText(location)
        tvdescription.setText(description)






        val res = resources
        val drawableId:Int =
                res.getIdentifier(imageFile,"drawable",packageName)

        val resStar = resources
        val drawableIdStar:Int =
                resStar.getIdentifier(rate,"drawable",packageName)

        val resIcon = resources
        val drawableIdIcon:Int =
                resIcon.getIdentifier(icon,"drawable",packageName)



        imgBg.setImageResource(drawableId)
        imgRate.setImageResource(drawableIdStar)
        imgLocation01.setImageResource( drawableIdIcon)







    }
}