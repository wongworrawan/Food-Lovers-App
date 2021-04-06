package th.ac.su.ict.foodlovers.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.list_item_food_lovers.view.*
import kotlinx.android.synthetic.main.list_item_food_lovers.view.imgRate
import kotlinx.android.synthetic.main.list_item_food_lovers.view.tvLocation
import kotlinx.android.synthetic.main.list_item_food_lovers.view.tvTitle
import th.ac.su.ict.foodlovers.R
import java.util.zip.Inflater
import javax.sql.CommonDataSource

class FoodloversAdapter(private val context: Context,
                        private val dataSource: ArrayList<Foodlovers>) : BaseAdapter() {
    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_food_lovers, null)
         rowView.tvTitle.text = dataSource[position].menuName
         rowView.tvLocation.text = dataSource[position].location
         rowView.tvPrice.text = dataSource[position].price.toString()

        lazy { rowView.tvdescription.text = dataSource[position].description }


         val res = context.resources
         val drawableId:Int =
             res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)

        val resStar = context.resources
        val drawableIdStar:Int =
            resStar.getIdentifier(dataSource[position].rate,"drawable",context.packageName)

        val resIcon = context.resources
        val drawableIdIcon:Int =
                resIcon.getIdentifier(dataSource[position].icon,"drawable",context.packageName)




        rowView.imgThumbnail.setImageResource(drawableId)
        rowView.imgRate.setImageResource(drawableIdStar)
        rowView.imgLocation.setImageResource(drawableIdIcon)









        return  rowView
    }



    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}