package com.example.devapp.TopNavigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.devapp.TopNavigation.Tabs.Fragment1;
import com.example.devapp.TopNavigation.Tabs.Fragment2;
import com.example.devapp.TopNavigation.Tabs.Fragment3;

public class TopNavMainAdapter extends FragmentStateAdapter {

    public TopNavMainAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0 :
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            default:
                return new Fragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
