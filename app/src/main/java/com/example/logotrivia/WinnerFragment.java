package com.example.logotrivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.logotrivia.databinding.FragmentWinnerBinding;


public class WinnerFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    private FragmentWinnerBinding mBinding;
    public WinnerFragment() {

    }


    public static WinnerFragment newInstance(String param1) {
        WinnerFragment fragment = new WinnerFragment();
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
        mBinding = FragmentWinnerBinding.inflate(inflater,container,false);
        return mBinding.getRoot();

    }
// text wiew del ganador
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String ganador = getString(R.string.ganador,mParam1);
        mBinding.tvGanador.setText(ganador);

    }

    //TODO método para volver al title al apretar el boton
}