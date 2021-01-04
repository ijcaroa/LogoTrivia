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
import android.widget.Toast;

import com.example.logotrivia.databinding.FragmentTitleBinding;


public class TitleFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private FragmentTitleBinding mBinding;
    public TitleFragment() {
        // Required empty public constructor
    }

    public static TitleFragment newInstance(String param1, String param2) {
        TitleFragment fragment = new TitleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentTitleBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
    //Aca se manejan las vistas del fragmento
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.buttonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBinding.editTextName.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Hola,debes indicar tu nombre"
                            , Toast.LENGTH_SHORT).show();
                } else {
                    addTriviaFragment(mBinding.editTextName.getText().toString());

                }
            }
        });
    }
                 //Si el edit text esta vacio y se aprieta el boton debería mandar mensaje indicando
                 //que debe ingresar un nombre





     //Este método pasara al segundo fragmento y tambien el nombre que se
     //ingrese al segundo fragmento trivia.



    //1.Instanciar fragmento que se añadira.
    //2.Instanciar el fragment manager
    //3.Instanciar la transacción
    //Activar la transacción
    private void addTriviaFragment(String name){
        TriviaFragment triviaFragment = TriviaFragment.newInstance(name);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.fragment,triviaFragment, TriviaFragment.class.getSimpleName())
                .addToBackStack(null);
        transaction.commit();
    }
}