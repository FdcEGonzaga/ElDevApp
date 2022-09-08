package com.example.devapp.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.devapp.R;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {

    public ListAdapter (Context context, ArrayList<User> userArrayList) {
        super(context, R.layout.list_view_item, userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user  = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item, parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.profile_image);
        TextView senderName = convertView.findViewById(R.id.msg_sender);
        TextView senderMsg = convertView.findViewById(R.id.msg_sender_msg);
        TextView sentTime = convertView.findViewById(R.id.msg_time);

        imageView.setImageResource(user.imageId);
        senderName.setText(user.name);
        senderMsg.setText(user.msg);
        sentTime.setText(user.msgTime);

        return convertView;
    }
}
