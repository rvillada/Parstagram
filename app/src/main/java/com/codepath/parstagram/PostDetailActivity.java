package com.codepath.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;

public class PostDetailActivity extends AppCompatActivity {

    TextView tvUsernameDetail;
    TextView tvDescriptionDetail;
    TextView tvTimestamp;
    ImageView ivImageDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        tvUsernameDetail = findViewById(R.id.tvUsernameDetail);
        tvDescriptionDetail = findViewById(R.id.tvDescriptionDetail);
        tvTimestamp = findViewById(R.id.tvTimestamp);
        ivImageDetail = findViewById(R.id.ivImageDetail);

        Post post = (Post) Parcels.unwrap(getIntent().getParcelableExtra("post"));

        tvDescriptionDetail.setText(post.getDescription());
        tvUsernameDetail.setText(post.getUser().getUsername());
        ParseFile image = post.getImage();
        if (image != null) {
            Glide.with(this).load(image.getUrl()).into(ivImageDetail);
        }

        String time = Post.calculateTimeAgo(post.getCreatedAt());
        tvTimestamp.setText(time);



    }
}