package com.example.onlineshopping.ui.fragment.cart

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat.Builder
import androidx.core.app.NotificationCompat.PRIORITY_DEFAULT
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshopping.R
import com.example.onlineshopping.data.model.Item
import com.example.onlineshopping.databinding.FragmentCartBinding
import kotlin.math.roundToInt


/**
 * A simple [Fragment] subclass.
 */
class CartFragment : Fragment() {


    lateinit var binding: FragmentCartBinding
    val viewModel : CardViewModel by viewModels<CardViewModel>()

    companion object{
        var listItem = ArrayList<Item>()
    }


    // notification

    lateinit var  notificationChannel: NotificationChannel
    lateinit var  notificationManager: NotificationManager
    lateinit var build: Notification.Builder
    private  val channelId= "com.example.onlineshopping"
    private var decription = " Test Notification"

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_cart, container, false)

        val adapter = CartAdapter(this, listItem)

        binding.rcv.adapter= adapter
        binding.rcv.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        var sumCost =0;

        listItem.forEach {
            sumCost = (sumCost +it.price).roundToInt()
        }

        binding.tvCost.text = "$sumCost Đ"

        binding.tvSumcost.text = "$sumCost Đ"
//        Log.d("Appliances", viewModel.appliances.size.toString())
//
//        return binding.root



        binding.backHome.setOnClickListener {
//            Toast.makeText(context, "Ok", Toast.LENGTH_LONG).show()
//            viewModelNotification.setAlarm(true)
            val intent = Intent(context, LauncherActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(context, 0,intent, PendingIntent.FLAG_CANCEL_CURRENT)
            if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
                notificationManager = requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationChannel = NotificationChannel(channelId,"ACD", NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor =Color.GREEN
                notificationChannel.enableVibration(false)
                build = Notification.Builder(context, channelId).setContentTitle("san pham moi")
                    .setContentText(" ten san pham")
                    .setSmallIcon(R.drawable.ic_account)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.bg_login))
                    .setContentIntent(pendingIntent)
            }
            else{
                build = Notification.Builder(context).setContentTitle("san pham moi")
                    .setContentText(" ten san pham")
                    .setSmallIcon(R.drawable.ic_account)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.bg_login))
                    .setContentIntent(pendingIntent)
            }

            notificationManager.notify(123, build.build())
        }
        return binding.root;
    }



}
