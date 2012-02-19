/*
Copyright (C) 2012 Haowen Ning

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.

*/
package org.liberty.android.fantastischmemo.ui;

import java.io.File;

import org.liberty.android.fantastischmemo.utils.RecentListUtil;

import android.app.Activity;

import android.content.Intent;

public class OpenTabFragment extends AbstractFileBrowserFragment {
    Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    protected void fileClickAction(File file) {
        String fullpath = file.getAbsolutePath();
        System.out.println("Path: " + fullpath);
        RecentListUtil.addToRecentList(mActivity, fullpath);
        Intent myIntent = new Intent(mActivity, MemoScreen.class);
        myIntent.putExtra(MemoScreen.EXTRA_DBPATH, fullpath);
        startActivity(myIntent);
    }
}