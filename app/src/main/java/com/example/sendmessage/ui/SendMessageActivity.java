package com.example.sendmessage.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.sendmessage.R;
import com.example.sendmessage.databinding.ActivitySendmessageBinding;
import com.example.sendmessage.data.model.Message;

public class SendMessageActivity extends AppCompatActivity {

    private ActivitySendmessageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendmessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_about){
            showAboutUs();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void getOnClick(View view) {
        switch (view.getId()){
            case R.id.btSend:
                showMessage();
                break;
        }
    }


    private void showMessage() {
        Bundle bundle = new Bundle();
        Message message = new Message();
        message.setUser(binding.edUser.getText().toString());
        message.setMessage(binding.edMessage.getText().toString());
        bundle.putSerializable("message",message);
        Intent intent = new Intent(this,ViewMessageActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void showAboutUs(){
        Intent intent = new Intent(this,AboutUsActivity.class);
        startActivity(intent);
    }
}