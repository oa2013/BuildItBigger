import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.util.Pair;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.concurrent.CountDownLatch;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Olga Agafonova on 9/10/18.
 *
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTaskAndroidTest{

    Context context;

    /*
    * Method based on https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework
    * */
    @Test
    public void testAsyncTask() throws Throwable{
        assertTrue(true);
        final CountDownLatch latch = new CountDownLatch(1);
        context = InstrumentationRegistry.getContext();

        try{
            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask() {
                @Override
                protected void onPostExecute(String joke) {
                    assertNotNull(joke);
                    if (joke != null){
                        assertTrue(joke.length() > 0);
                        latch.countDown();
                    }
                }
            };
            endpointsAsyncTask.execute(new Pair<Context, String>(context, "dummyInput"));
        }
        catch(Exception e) {
            Log.d("testAsyncTask exception: ", e.toString());
        }

        latch.await();
    }
}
