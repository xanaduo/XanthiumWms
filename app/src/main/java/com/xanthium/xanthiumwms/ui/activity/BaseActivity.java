package com.xanthium.xanthiumwms.ui.activity;

import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mrwang.stacklibrary.KeyCallBack;
import com.mrwang.stacklibrary.RootFragment;
import com.mrwang.stacklibrary.StackManager;

/**
 * Created by Xanthium on 2016/11/7 18:12.
 */

public abstract class BaseActivity extends AppCompatActivity
{
    public StackManager manager;
    public KeyCallBack callBack;


    /**
     * Set the bottom of the fragment
     *
     * @return fragment
     */
    @NonNull
    protected abstract RootFragment getRootFragment();

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
        frameLayout.setId(com.mrwang.stacklibrary.R.id.framLayoutId);
        setContentView(frameLayout);
        RootFragment fragment = getRootFragment();
        manager = new StackManager(this);
        manager.setFragment(fragment);
        onCreateNow(savedInstanceState);
    }

    /**
     * Set page switch animation
     *
     * @param nextIn  The next page to enter the animation
     * @param nextOut The next page out of the animation
     * @param quitIn  The current page into the animation
     * @param quitOut Exit animation for the current page
     */
    public void setAnim(@AnimRes int nextIn, @AnimRes int nextOut, @AnimRes int quitIn,
                        @AnimRes int quitOut)
    {
        manager.setAnim(nextIn, nextOut, quitIn, quitOut);
    }

    /**
     * Rewriting onCreate method
     *
     * @param savedInstanceState savedInstanceState
     */
    public void onCreateNow(Bundle savedInstanceState)
    {

    }


    @Override
    public final boolean onKeyDown(int keyCode, KeyEvent event)
    {
        switch (keyCode)
        {
            case KeyEvent.KEYCODE_BACK:
                manager.onBackPressed();
                return true;
            default:
                if (callBack != null)
                {
                    return callBack.onKeyDown(keyCode, event);
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * Set button to click callback
     *
     * @param callBack callback
     */
    public void setKeyCallBack(KeyCallBack callBack)
    {
        this.callBack = callBack;
    }

}
