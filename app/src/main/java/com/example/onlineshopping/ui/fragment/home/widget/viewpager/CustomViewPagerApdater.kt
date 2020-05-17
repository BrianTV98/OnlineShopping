import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.onlineshopping.R
import kotlinx.android.synthetic.main.swipe_layout.view.*
import java.util.ArrayList

@Suppress("UNREACHABLE_CODE")
class CustomViewPagerApdater(val context: Context) :
    PagerAdapter() {
    var count_postion = 0;


    val listImage = arrayListOf(
        R.drawable.oil,
        R.drawable.snack_food,
        R.drawable.flashflight,
        R.drawable.hand_wash,
        R.drawable.air_conditional
    )

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return (view == `object`)
    }

    override fun getCount(): Int {
        return listImage.size
    }

    @SuppressLint("SetTextI18n")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        if (count_postion > 4) {
            count_postion = 0
        }
        count_postion++
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.swipe_layout, container, false)
        view.tv_title.text = "Image+$position"
        view.imv.setImageResource(listImage[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

}