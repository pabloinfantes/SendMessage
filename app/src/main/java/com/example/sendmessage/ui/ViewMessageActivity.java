package com.example.sendmessage.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sendmessage.databinding.ActivityViewMessageBinding;
import com.example.sendmessage.data.model.Message;

public class ViewMessageActivity extends AppCompatActivity {

    private ActivityViewMessageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Message message = (Message) bundle.getSerializable("message");
        binding.tvUserContent.setText(message.getUser());
        binding.tvMessageContent.setText(message.getMessage());
    }
}