package com.example.onlineshopping

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.PointF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.dlazaro66.qrcodereaderview.QRCodeReaderView
import com.example.onlineshopping.databinding.FragmentQrCodeBinding
import com.example.onlineshopping.utils.PointsOverlayView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_qr_code.*


/**
 * A simple [Fragment] subclass.
 */
class QrCodeFragment : Fragment(),QRCodeReaderView.OnQRCodeReadListener{

    lateinit var binding : FragmentQrCodeBinding
    private val MY_PERMISSION_REQUEST_CAMERA = 0
    lateinit var qrCodeReaderView : QRCodeReaderView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_qr_code, container, false)


        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED) {
            initQRCodeReaderView();
        } else {
            requestCameraPermission();
        }
        return binding.root
    }

    private fun requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(),
                Manifest.permission.CAMERA
            )
        ) {
            Snackbar.make(
                main_layout, "Camera access is required to display the camera preview.",
                Snackbar.LENGTH_INDEFINITE
            ).setAction("OK") {
                ActivityCompat.requestPermissions(
                    requireActivity(), arrayOf(
                        Manifest.permission.CAMERA
                    ), MY_PERMISSION_REQUEST_CAMERA
                )
            }.show()
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(
                    Manifest.permission.CAMERA
                ), MY_PERMISSION_REQUEST_CAMERA
            )
        }
    }

    private fun initQRCodeReaderView() {
        val content: View = LayoutInflater.from(context).inflate(R.layout.content_decoder, main_layout, true);

        qrCodeReaderView  =  content.findViewById(R.id.qrdecoderview);
        val resultTextView : TextView=  content.findViewById(R.id.result_text_view);
        val flashlightCheckBox : CheckBox= content.findViewById(R.id.flashlight_checkbox);
        val enableDecodingCheckBox : CheckBox=  content.findViewById(R.id.enable_decoding_checkbox);
        val pointsOverlayView :PointsOverlayView = content.findViewById(R.id.points_overlay_view);

        qrCodeReaderView.setAutofocusInterval(2000L);
        qrCodeReaderView.setOnQRCodeReadListener(this);
        qrCodeReaderView.setBackCamera();
        flashlightCheckBox.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                qrCodeReaderView.setTorchEnabled(isChecked);
            }

        })

        enableDecodingCheckBox.setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                qrCodeReaderView.setQRDecodingEnabled(isChecked)
            }

        })
//        enableDecodingCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                qrCodeReaderView.setQRDecodingEnabled(isChecked);
//            }
//        });
        qrCodeReaderView.startCamera();
//    }
    }


    private fun allPermisstionGranted() =  Manifest.permission.CAMERA.all {
        ContextCompat.checkSelfPermission(requireContext(), it.toString()) == PackageManager.PERMISSION_GRANTED
    }

    override fun onQRCodeRead(text: String?, points: Array<out PointF>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
     override fun onResume() {
        super.onResume()
        if (qrCodeReaderView != null) {
            qrCodeReaderView.startCamera()
        }
    }

    override fun onPause() {
        super.onPause()
        if (qrCodeReaderView != null) {
            qrCodeReaderView.stopCamera()
        }
    }

}
