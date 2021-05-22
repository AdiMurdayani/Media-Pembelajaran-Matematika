package com.adi.mediapembelajaranmatematika.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.adi.mediapembelajaranmatematika.R;
import com.google.android.material.textfield.TextInputEditText;

public class FragmentInputNama1 extends Fragment {

    private View view;

    public FragmentInputNama1() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_input_nama1, container, false);
        return view;
    }
}
