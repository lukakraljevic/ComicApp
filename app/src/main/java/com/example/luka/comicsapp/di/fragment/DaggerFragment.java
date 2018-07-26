package com.example.luka.comicsapp.di.fragment;

import android.app.Fragment;
import android.os.Bundle;

import com.example.luka.comicsapp.di.activity.DaggerActivity;
import com.example.luka.comicsapp.di.ComponentFactory;

public abstract class DaggerFragment extends Fragment {

    private FragmentComponent fragmentComponent;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getFragmentComponent());
    }

    protected abstract void inject(FragmentComponent fragmentComponent);

    public FragmentComponent getFragmentComponent() {
        if (fragmentComponent == null) {
            fragmentComponent = ComponentFactory.createFragmentComponent(this, getDaggerActivity().getActivityComponent());
        }

        return fragmentComponent;
    }

    public DaggerActivity getDaggerActivity() {
        return ((DaggerActivity) getActivity());
    }
}
