package com.smh.sequential.Adapter;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.smh.sequential.Contracts;
import com.smh.sequential.Fragment.ListsFragment;
import com.smh.sequential.Fragment.ListsType;

public class ListsPageAdapter extends FragmentStatePagerAdapter {

    private static final int PAGE_COUNT=2;

    private ListsFragment allListFragment,downloadedListFragment;

    public ListsPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
        Log.i(getClass().getName(), "ListsPageAdapter: pager adapter created");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if(position==0){
            Bundle bundle=new Bundle();
            bundle.putInt(Contracts.BUNDLE_LISTS_TYPE_ID,0);
            allListFragment=new ListsFragment();
            allListFragment.setArguments(bundle);
            return allListFragment;
        }else if(position==1){
            Bundle bundle=new Bundle();
            downloadedListFragment=new ListsFragment();
            bundle.putInt(Contracts.BUNDLE_LISTS_TYPE_ID,1);
            downloadedListFragment.setArguments(bundle);
            return downloadedListFragment;
        }

        throw new IllegalArgumentException();

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    public void reloadList(ListsType listsType){
        if(listsType==ListsType.allLists){
            allListFragment.reloadListView();
        }else if(listsType==ListsType.downloadLists){
            downloadedListFragment.reloadListView();
        }
    }

}
