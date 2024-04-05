package com.capcun.womenentrepreneur;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.capcun.womenentrepreneur.Chat.messagesAdpter;
import com.capcun.womenentrepreneur.Chat.msgModelclass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatWindow extends AppCompatActivity {

    TextView person_name;

    ImageView send_msg;
    EditText msg;
    final String sharedPreferencesFileTitle = "wool_linker";

    List<chats_datalead>data_list = new ArrayList<>();
    RecyclerView recycler;
    LinearLayoutManager layoutManager;
    messagesAdpter adpter;

    private final Handler messageHandler = new Handler(Looper.getMainLooper());
    private static final long MESSAGE_FETCH_INTERVAL = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTheme(R.style.StatusBarTheme);
        }
        setContentView(R.layout.activity_chat_window);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));
        }


        person_name = findViewById(R.id.person_name);


        person_name.setText(getIntent().getStringExtra("name"));


        recycler = findViewById(R.id.msgadpter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler.setLayoutManager(layoutManager);

        String user_id="6";

        String rec_user_id=getIntent().getStringExtra("rev");
        startFetchingMessages(user_id,rec_user_id);

        send_msg = findViewById(R.id.send);
        msg = findViewById(R.id.textmsg);

        send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(msg.getText().toString().isEmpty())
                    msg.setError("Enter msg first");
                String m = msg.getText().toString();

                Call<String> call = ApiControlllerEmployee
                        .getInstance()
                        .fetchingPost()
                        .sendMsg(user_id,rec_user_id,m);

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String s = response.body();

                        if(s.equals("success"))
                        {
                            msg.setText("");
                            Toast.makeText(ChatWindow.this, "Send..!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(ChatWindow.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(ChatWindow.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void startFetchingMessages(String send,String rev ) {
        // Define a Runnable task to fetch messages
        Runnable fetchMessagesTask = new Runnable() {
            @Override
            public void run() {
                // Fetch messages
                fetchMessages(send,rev);

                // Schedule the task to run again after MESSAGE_FETCH_INTERVAL
                messageHandler.postDelayed(this, MESSAGE_FETCH_INTERVAL);
            }
        };

        // Start the initial fetch
        messageHandler.post(fetchMessagesTask);
    }

    private void fetchMessages(String send,String rev) {

        Call<List<msgModelclass>> call2 = ApiControlllerEmployee
                .getInstance()
                .fetchingPost()
                .fetchChat(send,rev);

        call2.enqueue(new Callback<List<msgModelclass>>() {
            @Override
            public void onResponse(Call<List<msgModelclass>> call, Response<List<msgModelclass>> response) {
                List<msgModelclass> modelclass = response.body();
                data_list.clear();

                if (modelclass!=null)
                {
                    for(msgModelclass data : modelclass)
                    {
                        data_list.add(new chats_datalead(data.getSender_id(),data.getMsg(),data.getReceiver_id(),data.getTime()));
                    }
                    adpter = new messagesAdpter(data_list,ChatWindow.this);
                    recycler.setAdapter(adpter);
                }
            }

            @Override
            public void onFailure(Call<List<msgModelclass>> call, Throwable t) {

                Toast.makeText(ChatWindow.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }
}