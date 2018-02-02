package com.example.user.codechef.activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.user.codechef.R;
import com.example.user.codechef.utils.util.Logger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity {


    @BindView(R.id.profile_restro_camera_iv)
    ImageView mProfileRestroImageView;
    @BindView(R.id.profile_restro_back_iv)
    ImageView mBackIv;
    @BindView(R.id.profile_restro_edit_iv)
    ImageView mRestroEditIv;
    @BindView(R.id.profile_restro_address_edit_iv)
    ImageView mRestroAddressEditIv;
    private static final int CAMERA_INTENT_CODE=101;
    private String mCurrentPhotoPath="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.Lime));
        }
        init();
    }

    private void init() {
        initVariables();
    }

    private void initVariables() {
        mProfileRestroImageView.setColorFilter(getResources().getColor(R.color.LightGray));
        mRestroEditIv.setColorFilter(getResources().getColor(R.color.Gray_shade2));
        mRestroAddressEditIv.setColorFilter(getResources().getColor(R.color.Gray_shade2));
    }

    @OnClick({R.id.profile_restro_camera_iv})
    public void onClickCameraIv()  {
        Intent galleryIntent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(createImageFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent chooserIntent=Intent.createChooser(galleryIntent,"Select Restaurant Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS,new Intent[]{cameraIntent});
        startActivityForResult(chooserIntent,CAMERA_INTENT_CODE);
    }

    @OnClick({R.id.profile_restro_back_iv})
    public void onClickBackIv() {
        onBackPressed();
    }

    private File createImageFile() throws IOException{
        String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName="JPEG_"+timeStamp+"_";
        File storageDir= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image=File.createTempFile(imageFileName,".jpg",storageDir);
        String currentPhotoPath="file:"+image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK&&requestCode==CAMERA_INTENT_CODE) {
            if(data.getData()!=null) {
                Uri uri=data.getData();
                mCurrentPhotoPath=getRealPathFromURI(uri);
                Logger.LogDebug("Hello gallery",mCurrentPhotoPath);
                if(!mCurrentPhotoPath.isEmpty()) {
                    Bitmap bitmap= BitmapFactory.decodeFile(mCurrentPhotoPath);
                    mProfileRestroImageView.setImageBitmap(bitmap);
                    mProfileRestroImageView.setColorFilter(0);
                    mProfileRestroImageView.setPadding(0,0,0,0);
                }
            } else {
                Bitmap bitmap=(Bitmap)data.getExtras().get("data");
                Uri uri=getImageUri(this,bitmap);
                File finalFile=new File(getRealPathFromURI(uri));
                mCurrentPhotoPath=finalFile.getPath();
                Logger.LogDebug("Hello Camera",mCurrentPhotoPath);
                if(!mCurrentPhotoPath.isEmpty()) {
                    Bitmap bitmap2= BitmapFactory.decodeFile(mCurrentPhotoPath);
                    mProfileRestroImageView.setImageBitmap(bitmap2);
                    mProfileRestroImageView.setColorFilter(0);
                    mProfileRestroImageView.setPadding(0,0,0,0);
                }
            }
        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }


}
