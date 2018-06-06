package com.fhs.network;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import io.reactivex.annotations.Nullable;
import java.io.File;

/**
 * @author Ganesh Tikone on 21/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: GTImageView
 *
 * GTImageView load image asynchronously. It uses AppCompatImageView from support library and Glide
 * Image Loading library Added new methods to load image from network/filepath/file object.
 * Following methods are available for each type of stream
 *
 * 1. loadImageFromUrl(@NullableString url)
 * 2. loadImageFromUrl(@NullableString url, @Nullable int placeHolder)
 * 3. loadImageFromUrl(@NullableString url, @Nullable RequestOptions requestOptions)
 * 4. loadImageFromPath(@Nullable String path)
 * 5. loadImageFromFile(@Nullable File file)
 * 6. loadImageFromFile(@Nullable File file, @Nullable int placeHolder)
 * 7. loadImageFromFile(@Nullable File file, @Nullable RequestOptions requestOptions)
 */


public class GTImageView extends AppCompatImageView {

  private Context context;


  public GTImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.context = context;
  }

  /**
   * Load image with url
   *
   * @param url : Image url
   */
  public void loadImageFromUrl(@Nullable String url) {

    Glide.with(context)
        .load(url)
        .into(this);
  }

  /**
   * Load image from url with setting up place holder
   *
   * @param url image url
   * @param placeHolder placeholder image id
   */
  public void loadImageFromUrl(@Nullable String url, @Nullable int placeHolder) {

    RequestOptions requestOptions = new RequestOptions().placeholder(placeHolder);

    if (placeHolder != 0) {
      Glide.with(context)
          .load(url)
          .apply(requestOptions)
          .into(this);

    } else {
      loadImageFromUrl(url);
    }
  }


  /**
   * Load image from url with setting up place holder
   *
   * @param url image url
   * @param requestOptions Glide request options
   */
  public void loadImageFromUrl(@Nullable String url, @Nullable RequestOptions requestOptions) {

    if (null != requestOptions) {
      Glide.with(context)
          .load(url)
          .apply(requestOptions)
          .into(this);

    } else {
      loadImageFromUrl(url);
    }

  }

  /**
   * Load image from absolute path of image
   * @param path absolute path
   */
  public void loadImageFromPath(@Nullable String path) {

    if (!TextUtils.isEmpty(path)) {
      File imageFile = new File(path);
      loadImageFromFile(imageFile);
    }
  }

  /**
   * Load Image with file object
   *
   * @param file image file object
   */
  public void loadImageFromFile(@Nullable File file) {
    Glide.with(context)
        .load(file)
        .into(this);
  }

  /**
   * Load Image with file object and placeholder
   *
   * @param file image file object
   * @param placeHolder resource drawable icon
   */
  public void loadImageFromFile(@Nullable File file, @Nullable int placeHolder) {
    RequestOptions requestOptions = new RequestOptions().placeholder(placeHolder);

    if (placeHolder != 0) {
      Glide.with(context)
          .load(file)
          .apply(requestOptions)
          .into(this);

    } else {
      loadImageFromFile(file);
    }
  }


  /**
   * Load image from file using request options
   *
   * @param file file uri
   * @param requestOptions Glide request options
   */
  public void loadImageFromFile(@Nullable File file, @Nullable RequestOptions requestOptions) {

    if (null != requestOptions) {
      Glide.with(context)
          .load(file)
          .apply(requestOptions)
          .into(this);

    } else {
      loadImageFromFile(file);
    }

  }

}
