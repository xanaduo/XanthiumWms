package com.xanthium.xanthiumwms.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrwang.stacklibrary.RootFragment;
import com.xanthium.xanthiumwms.R;

/**
 * Created by Xanthium on 2016/11/7 18:09.
 */

public class MainFragment extends RootFragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        return LayoutInflater.from(container.getContext()).inflate(R.layout.content_main, null);
    }
}
