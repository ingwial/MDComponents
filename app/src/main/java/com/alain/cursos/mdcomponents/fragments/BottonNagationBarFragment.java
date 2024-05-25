package com.alain.cursos.mdcomponents.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BottonNagationBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottonNagationBarFragment extends Fragment {

    public static final String TAG = "Button Navigation";

    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.bottonNavigation)
    BottomNavigationView bottonNavigation;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_bottomnav_mobile_portrait);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public BottonNagationBarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_botton_nagation_bar, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        bottonNavigation.getOrCreateBadge(R.id.action_start);
        //bottonNavigation.removeBadge(R.id.action_start);

        BadgeDrawable favoriteBadge = bottonNavigation.getOrCreateBadge(R.id.action_favorites);
        favoriteBadge.setNumber(21);

        BadgeDrawable profileBadge = bottonNavigation.getOrCreateBadge(R.id.action_profile);
        profileBadge.setNumber(1000);
        profileBadge.setMaxCharacterCount(3);
        profileBadge.setBackgroundColor(Color.CYAN);
        profileBadge.setBadgeTextColor(Color.MAGENTA);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}