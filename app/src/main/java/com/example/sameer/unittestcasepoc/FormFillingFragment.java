package com.example.sameer.unittestcasepoc;


import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by webonise on 1/3/18.
 */

public class FormFillingFragment extends Fragment implements View.OnClickListener {
    EditText firstName, middleName, lastName, dob;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_filling, container, false);
        firstName = (EditText) view.findViewById(R.id.etFirstName);
        middleName = (EditText) view.findViewById(R.id.etMiddleName);
        lastName = (EditText) view.findViewById(R.id.etLastName);
        dob = (EditText) view.findViewById(R.id.etDOB);
        ((Button) view.findViewById(R.id.button)).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button:
                validateData(firstName.getText().toString(), middleName.getText().toString(),
                        lastName.getText().toString(), dob.getText().toString());
                break;
        }
    }

    public void validateData(String one, String two, String three, String four) {
        if (TextUtils.isEmpty(one) || TextUtils.isEmpty(two) ||
                TextUtils.isEmpty(three) || TextUtils.isEmpty(four)) {
            getActivity().runOnUiThread(() -> Toast.makeText(getActivity(), "Please enter valid/complete data", Toast.LENGTH_SHORT).show());
        }
    }
}
