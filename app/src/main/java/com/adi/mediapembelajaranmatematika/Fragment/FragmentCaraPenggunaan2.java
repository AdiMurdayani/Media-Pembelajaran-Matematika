package com.adi.mediapembelajaranmatematika.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.adi.mediapembelajaranmatematika.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

public class FragmentCaraPenggunaan2 extends Fragment {

    private View view;

    public FragmentCaraPenggunaan2() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cara_penggunaan_2, container, false);
        return view;
    }
}
