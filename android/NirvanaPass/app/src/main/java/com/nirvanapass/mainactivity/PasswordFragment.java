package com.nirvanapass.mainactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nirvanapass.R;

public class PasswordFragment extends Fragment {


    public PasswordFragment() {
        // Required empty public constructor
    }

    public static PasswordFragment newInstance() {
        PasswordFragment passwordFragment = new PasswordFragment();

        Bundle args = new Bundle();
        passwordFragment.setArguments(args);

        return passwordFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.password_fragment_layout, container, false);
    }

}
