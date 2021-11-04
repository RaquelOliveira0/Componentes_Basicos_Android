package com.example.helloword;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link page2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class page2 extends Fragment {

    EditText eText;
    Button btn;
    Spinner spnr;

    String[] estados = {
            "Acre",
            "Alagoas",
            "Amapá",
            "Amazonas ",
            "Bahia",
            "Ceará",
            "Distrito Federal ",
            "Outros"
    };

    public page2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment page2.
     */
    // TODO: Rename and change types and number of parameters
    public static page2 newInstance(String param1, String param2) {
        page2 fragment = new page2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page2, container, false);
    }
    @SuppressLint("WrongConstant")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        eText = view.findViewById(R.id.edittext);
        btn = view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = eText.getText().toString();
                Toast msg = Toast.makeText(getContext(), str, Toast.LENGTH_LONG);
                msg.show();
            }
        });
        spnr = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adptr = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_spinner_item, estados);

        spnr.setAdapter(adptr);
        spnr.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {

                        int position = spnr.getSelectedItemPosition();
                        Toast.makeText(getContext(), "You have selected " + estados[+position], Toast.LENGTH_LONG).show();
                        // TODO Auto-generated method stub
                    }
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub

                    }
                }
        );

        TextView txtView = view.findViewById(R.id.txtView);
        txtView.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getContext(),
                        "You have pressed it long :)", 2000).show();
                return false;
            }

        });
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getContext(), "Conta criada com sucesso",
                        1000).show();
            }
        });


    }
}