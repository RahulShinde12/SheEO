package com.capcun.womenentrepreneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatePost extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imageView;
    private Bitmap selectedImageBitmap;
    //    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri selectedImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        ImageView chooseImageButton = findViewById(R.id.img1);
        chooseImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        TextView uploadButton = findViewById(R.id.btn_post);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedImageUri != null) {
                    try {
                        String base64String = ImageUtils.uriToBase64(CreatePost.this, selectedImageUri);


                        EditText desc = findViewById(R.id.edit_text);
                        EditText hashtag = findViewById(R.id.hash_text);
                        EditText title = findViewById(R.id.title);

                        String description = desc.getText().toString();
                        String hashtags = hashtag.getText().toString();
                        String titles = title.getText().toString();

                        Toast.makeText(CreatePost.this, "Success", Toast.LENGTH_SHORT).show();




                        Call<String> call = ApiControlllerEmployee
                                .getInstance()
                                .fetchAdIDApi()
                                .fetchSubBusinessId(1,titles,description,hashtags,base64String);
                        //Toast.makeText(this, "vasudev data update sceessfuly", Toast.LENGTH_SHORT).show();
                        call.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {

                                String data = response.body();

                                Toast.makeText(CreatePost.this, ""+data, Toast.LENGTH_SHORT).show();
                                if(data!=null)
                                {
//                                    finish();

                                }

                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
//                                finish();
//                progressDialog.dismiss();
//                                Log.e("NetworkError", "Something went wrong: " + t.getMessage());

                                // Show a toast message indicating the failure
//                                Toast.makeText(CreatePost.this, "Something went wrong: " + t.getMessage(), Toast.LENGTH_LONG).show();
//                Toast.makeText(CreatePost.this,"Something went wrong please refresh the page !",Toast.LENGTH_LONG).show();
                            }
                        });




                        Call<String> call1 = ApiControlllerEmployee
                                .getInstance()
                                .fetchAdIDApi()
                                .addpost(1,titles,description,hashtags);
                        //Toast.makeText(this, "vasudev data update sceessfuly", Toast.LENGTH_SHORT).show();
                        call1.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {

                                String data = response.body();

                                Toast.makeText(CreatePost.this, ""+data, Toast.LENGTH_SHORT).show();
                                if(data!=null)
                                {
                                    finish();

                                }

                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
//                                finish();
//                progressDialog.dismiss();
//                                Log.e("NetworkError", "Something went wrong: " + t.getMessage());

                                // Show a toast message indicating the failure
//                                Toast.makeText(CreatePost.this, "Something went wrong: " + t.getMessage(), Toast.LENGTH_LONG).show();
//                Toast.makeText(CreatePost.this,"Something went wrong please refresh the page !",Toast.LENGTH_LONG).show();
                            }
                        });






























                        // Now you can use the base64String as needed, e.g., upload it to the server
                        // Example: new ImageUploaderTask().execute(base64String);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });







































    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedImageUri = data.getData();

            try {
                imageView = findViewById(R.id.post_img);
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}