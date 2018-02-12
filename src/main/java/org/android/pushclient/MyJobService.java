/**
 * JobService to restore SCREEN_OFF_TIMEOUT.
 */

package org.android.pushclient;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.provider.Settings;

public class MyJobService extends JobService {

    private static final String TAG = "JobService";

    @Override
    public boolean onStartJob(JobParameters params) {
        int screenTimeout = params.getExtras().getInt("TIMEOUT");
        if (screenTimeout > 0) {
            Settings.System.putInt(getContentResolver(),
                    Settings.System.SCREEN_OFF_TIMEOUT, screenTimeout);
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        jobFinished(params, false);
        return false;
    }
}
