package com.example.logotrivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.logotrivia.databinding.FragmentLooserBinding;


public class LooserFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
   private FragmentLooserBinding mBinding;
    public LooserFragment() {

    }


    public static LooserFragment newInstance(String param1) {
        LooserFragment fragment = new LooserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentLooserBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String perdedor = getString(R.string.perdedor,mParam1);
        mBinding.tvPerdedor.setText(perdedor);
    }
}