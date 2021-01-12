package edu.monash.legoar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.unity3d.player.UnityPlayer;

public class UnityFragment extends Fragment {

    protected UnityPlayer mUnityPlayer;
    FrameLayout frameLayoutForUnity;
    private static final int CAMERA_REQUEST_CODE = 100;

    public UnityFragment() {
        // Required empty public constructor1
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mUnityPlayer = new UnityPlayer(getActivity());
        View view = inflater.inflate(R.layout.fragment_unity, container, false);
        this.frameLayoutForUnity = (FrameLayout) view.findViewById(R.id.frameLayouForUnity);
        this.frameLayoutForUnity.addView(mUnityPlayer.getView(), FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        mUnityPlayer.requestFocus();
        mUnityPlayer.windowFocusChanged(true);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mUnityPlayer.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mUnityPlayer.resume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        this.mUnityPlayer.lowMemory();
    }

    @Override
    public void onStart() {
        super.onStart();
        this.mUnityPlayer.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        this.mUnityPlayer.stop();
    }


}