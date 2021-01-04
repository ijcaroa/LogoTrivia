package com.example.logotrivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.logotrivia.databinding.FragmentTriviaBinding;


public class TriviaFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private FragmentTriviaBinding mBinding;
    private boolean choice;
    public TriviaFragment() {
        // Required empty public constructor
    }


    public static TriviaFragment newInstance(String param1) {
        TriviaFragment fragment = new TriviaFragment();
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
        mBinding = FragmentTriviaBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String saludo = getString(R.string.saludo, mParam1);
        mBinding.tvSaludo.setText(saludo);
        mBinding.radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = mBinding.radioGroup2
                        .indexOfChild(mBinding.radioGroup2.findViewById(checkedId));
                if (index == 2){
                    choice = true;
                } else {
                    choice = false;
                }
            }
        });
        mBinding.buttonEnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice){
                addWinnerFragment(mParam1);
                    //TODO anadir el método que inicia el fragmento ganador y pasa el nombre

                } else{
                    //TODO añadir el metodo que inicia el frgamento perdedor y pasa el nombre
                    addLooserFragment(mParam1);
                }
            }

            private void addWinnerFragment(String name) {
                WinnerFragment winnerFragment = WinnerFragment.newInstance(name);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction()
                        .replace(R.id.fragment,winnerFragment,WinnerFragment.class.getSimpleName())
                        .addToBackStack(null);
                transaction.commit();

            }
            private void addLooserFragment(String name) {
                LooserFragment looserFragment = LooserFragment.newInstance(name);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction()
                        .replace(R.id.fragment,looserFragment,LooserFragment.class.getSimpleName())
                        .addToBackStack(null);
                transaction.commit();

            }
        });
        //TODO crear el metodo para ir al fragmento ganador

        }
    }






    //TODO crear el metodo para ir al fragmento perdedor


