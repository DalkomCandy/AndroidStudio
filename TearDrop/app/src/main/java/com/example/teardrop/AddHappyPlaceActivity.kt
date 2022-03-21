package com.example.teardrop

import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.teardrop.R.layout.activity_add_happy_place
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import kotlinx.android.synthetic.main.activity_add_happy_place.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.jar.Manifest
import com.karumi.dexter.PermissionToken

import com.karumi.dexter.listener.PermissionDeniedResponse

import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

import com.karumi.dexter.listener.single.PermissionListener
import java.io.IOException


class AddHappyPlaceActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val GALLERY = 1
        private const val CAMERA = 2
        private const val IMAGE_DIRECTORY = "TearDropImages"
        private const val PLACE_AUTOCOMPLETE_REQUEST_CODE = 3
    }

    private var cal = Calendar.getInstance()
    private lateinit var dateSetListener: DatePickerDialog.OnDateSetListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_add_happy_place)
        setSupportActionBar(toolbar_add_place)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 뒤로가기 버튼 생성
        toolbar_add_place.setNavigationOnClickListener {
            onBackPressed()
        }

        dateSetListener = DatePickerDialog.OnDateSetListener {
                view, year, month, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, month)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }

        et_date.setOnClickListener(this) // this를 쓰는 이유는 AddHappyPlaceActivity 자체가 OnClicklister
        tv_add_image.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.et_date -> {
                DatePickerDialog(
                    this@AddHappyPlaceActivity,
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
            R.id.tv_add_image -> {
                val pictureDialog = AlertDialog.Builder(this)
                pictureDialog.setTitle("Select Action")
                val pictureDialogItems = arrayOf(
                    "Select photo from Gallery",
                    "Capture photo from camera"
                )

                pictureDialog.setItems(pictureDialogItems) {
                        _, which ->
                    when (which){
                        0 -> choosePhotoFromGallery()
                        1 -> Toast.makeText(
                        this@AddHappyPlaceActivity,
                        "Camera selection comming soon...",
                        Toast.LENGTH_SHORT).show()
                    }
                }
                pictureDialog.show()
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GALLERY) {
                if (data != null) {
                    val contentUri = data.data
                    try {
                        val selectedImageBitmap =
                            MediaStore.Images.Media.getBitmap(this.contentResolver, contentUri)

                        iv_place_image.setImageBitmap(selectedImageBitmap)
                    } catch (e: IOException) {
                        e.printStackTrace()
                        Toast.makeText(
                            this@AddHappyPlaceActivity,
                            "Failed to Load the image from",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else if (requestCode == CAMERA) {
                val thumbnail: Bitmap = data!!.extras!!.get("data") as Bitmap
                iv_place_image.setImageBitmap(thumbnail)
            }
        }
    }


    private fun choosePhotoFromGallery() {
        Dexter.withContext(this).withPermissions(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        ).withListener(object : MultiplePermissionsListener {
            override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                if (p0!!.areAllPermissionsGranted()) {
                    val galleryIntent =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivityForResult(galleryIntent, GALLERY)
                }
            }

            override fun onPermissionRationaleShouldBeShown(
                permission: MutableList<PermissionRequest>,
                token: PermissionToken) {
                showRationalDialogForPermissions()
            }
        }).onSameThread().check()

    }

    private fun showRationalDialogForPermissions() {
        AlertDialog.Builder(this).setMessage("권한 사용이 거부되었습니다.")
            .setPositiveButton("설정으로 이동")
            {_ , _ ->
                try {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", packageName, null)
                    intent.data = uri
                    startActivity(intent)
                } catch(e: ActivityNotFoundException) {
                    e.printStackTrace()

                }
            }.setNegativeButton("Cancel"){dialog, _ ->
                dialog.dismiss()
            }.show()
    }

    private fun updateDateInView(){
        val myFormat = "yyyy년 MM월 dd일"
        val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
        et_date.setText(sdf.format(cal.time).toString())
    }
}

