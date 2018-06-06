package com.fhs.signature

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import com.fhs.R
import com.fhs.core.BaseActivity
import com.fhs.io.ApplicationFile
import com.github.gcacace.signaturepad.views.SignaturePad
import kotlinx.android.synthetic.main.activity_signature.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class SignatureActivity : BaseActivity() {

    val TAG = SignatureActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signature)
        setListeners()
    }

    /**
     *
     */
    private fun setListeners() {

        buttonClear.setOnClickListener {
            signature_pad.clear()
        }

        buttonSaveSignature.setOnClickListener {
            signature_pad.saveFile(ApplicationFile.getRandomPhotoFile(), this@SignatureActivity)
        }
    }
}

/**
 * Signature extension function: save sign bitmap to file asynchronously
 * @param file: File object
 */
fun SignaturePad.saveFile(file: File, activity: SignatureActivity) {

    doAsync {

        try {
            val out = FileOutputStream(file)
            signatureBitmap.compress(Bitmap.CompressFormat.PNG, 70, out)
            out.close()

        } catch (ioexception: IOException) {
            Log.e("####", "Error to write file to device")
        }

        uiThread {

            val resultIntent = Intent()
            resultIntent.putExtra("signature", file.absolutePath)
            activity.setResult(RESULT_OK, resultIntent)
            activity.finish()
        }
    }
}

