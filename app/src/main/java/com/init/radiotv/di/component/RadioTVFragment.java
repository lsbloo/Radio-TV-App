package com.init.radiotv.di.component;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.init.radiotv.R;
import com.init.radiotv.utils.Constants;
import com.devbrackets.android.exomedia.ui.widget.VideoView;
import butterknife.ButterKnife;


public class RadioTVFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public RadioTVFragment() {
        // Required empty public constructor
    }



    public static RadioTVFragment newInstance(String param1, String param2) {
        RadioTVFragment fragment = new RadioTVFragment();
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radio_t_v, container, false);

        VideoView videoView = view.findViewById(R.id.videoView);
        Uri uri = Uri.parse(Constants.M3U8_TESTE);
        videoView.setVideoURI(uri);
        videoView.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared() {
                videoView.start();
            }
        });


        return view;
    }
}