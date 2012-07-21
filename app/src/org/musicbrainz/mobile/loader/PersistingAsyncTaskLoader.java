/*
 * Copyright (C) 2012 Jamie McDonald
 * 
 * This file is part of MusicBrainz for Android.
 * 
 * MusicBrainz for Android is free software: you can redistribute 
 * it and/or modify it under the terms of the GNU General Public 
 * License as published by the Free Software Foundation, either 
 * version 3 of the License, or (at your option) any later version.
 * 
 * MusicBrainz for Android is distributed in the hope that it 
 * will be useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MusicBrainz for Android. If not, see 
 * <http://www.gnu.org/licenses/>.
 */

package org.musicbrainz.mobile.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public abstract class PersistingAsyncTaskLoader<D> extends AsyncTaskLoader<D> {

    protected D data;
    
    public PersistingAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if (data != null) {
            deliverResult(data);
        }
        if (takeContentChanged() || data == null) {
            forceLoad();
        }
    }
    
    @Override
    public void deliverResult(D data) {
        if (isReset()) {
            return;
        }
        this.data = data;
        super.deliverResult(data);
    }
    
    @Override
    protected void onStopLoading() {
        cancelLoad();
    }
    
    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        data = null;
    }

}
