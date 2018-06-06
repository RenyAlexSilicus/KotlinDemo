package com.fhs.camera

import android.os.Bundle
import com.fhs.R
import com.fhs.core.BaseActivity
import com.fhs.io.ApplicationFile
import io.fotoapparat.Fotoapparat
import io.fotoapparat.configuration.CameraConfiguration
import io.fotoapparat.parameter.ScaleType
import io.fotoapparat.selector.*
import kotlinx.android.synthetic.main.activity_camera.*

/**
 * Created by Ganesh Tikone on 21/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: CameraActivity
 * Open camera in application.
 * This class uses Fotoappart library to handle camera functions
 * This library uses camera api 1 and 2 level
 */

class CameraActivity : BaseActivity() {

    /**
     * fotoappart camera instance
     */
    private var fotoapparat: Fotoapparat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        configureFotoApparat()

        setListener()
    }


    /**
     * set listener on button
     */
    private fun setListener() {

        buttonCapture.setOnClickListener {
            fotoapparat?.takePicture()?.saveToFile(ApplicationFile.getRandomPhotoFile())
        }
    }


    /**
     * Configure fotiAppart with available configuration
     */
    private fun configureFotoApparat() {

        val cameraConfiguration = CameraConfiguration(
                pictureResolution = highestResolution(), // (optional) we want to have the highest possible photo resolution
                previewResolution = highestResolution(), // (optional) we want to have the highest possible preview resolution
                previewFpsRange = highestFps(),          // (optional) we want to have the best frame rate
                focusMode = firstAvailable(              // (optional) use the first focus mode which is supported by device
                        continuousFocusPicture(),
                        autoFocus(),                       // if continuous focus is not available on device, auto focus will be used
                        fixed()                            // if even auto focus is not available - fixed focus mode will be used
                ),
                flashMode = firstAvailable(              // (optional) similar to how it is done for focus mode, this time for flash
                        autoRedEye(),
                        autoFlash(),
                        torch(),
                        off()
                ),
                antiBandingMode = firstAvailable(       // (optional) similar to how it is done for focus mode & flash, now for anti banding
                        auto(),
                        hz50(),
                        hz60(),
                        none()
                ),
                jpegQuality = manualJpegQuality(50),     // (optional) select a jpeg quality of 90 (out of 0-100) values
                sensorSensitivity = lowestSensorSensitivity() // (optional) we want to have the lowest sensor sensitivity (ISO)
        )

        fotoapparat = Fotoapparat(
                context = this,
                view = camera_view,                   // view which will draw the camera preview
                scaleType = ScaleType.CenterCrop,    // (optional) we want the preview to fill the view
                lensPosition = back(),               // (optional) we want back camera
                cameraConfiguration = cameraConfiguration,
                cameraErrorCallback = { error -> logger.error("###", error.localizedMessage) }   // (optional) log fatal errors
        )
    }

    override fun onStart() {
        super.onStart()
        fotoapparat?.start()
    }

    override fun onStop() {
        super.onStop()
        fotoapparat?.stop()
    }
}
