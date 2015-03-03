package first.test1.com.myapplication;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import java.util.ArrayList;


/**
 *
 *
 * Created by Andy on 03/03/2015.
 */
public class AudioHandlerTester extends ActivityInstrumentationTestCase2<MainActivity> {

    public Activity activity;
    public AudioHandlerTester() {
        super(MainActivity.class);
    }

    protected void setUp() throws Exception{
        super.setUp();

        setActivityInitialTouchMode(false);

        activity = getActivity();
    }

    @SmallTest
    public void testURL(){
        ArrayList<String> songs = new ArrayList<>();
        songs.add("a");

        AudioHandler audioHandler = new AudioHandler(activity,songs);

        assertEquals("a", audioHandler.URLs.get(0));
    }

    public void testURLs(){
        ArrayList<String> songs = new ArrayList<>();
        songs.add("a");
        songs.add("b");

        AudioHandler audioHandler = new AudioHandler(activity,songs);

        assertEquals("b", audioHandler.URLs.get(1));
    }

    public void testCurrentSong(){
        ArrayList<String> songs = new ArrayList<>();
        songs.add("a");
        songs.add("b");

        AudioHandler audioHandler = new AudioHandler(activity,songs);

        audioHandler.CurrentSong = 1;

        assertEquals("b", audioHandler.URLs.get(audioHandler.CurrentSong));
    }

    public void testChangePlaylist(){
        ArrayList<String> songs = new ArrayList<>();
        songs.add("a");
        songs.add("b");

        AudioHandler audioHandler = new AudioHandler(activity,songs);

        songs.add(2,"c");
        songs.add(3,"b");

        audioHandler.setPlaylist(songs);

        assertEquals(4, audioHandler.URLs.size());
    }

    public void testPause(){

        ArrayList<String> songs = new ArrayList<>();
        songs.add("a");

        AudioHandler audioHandler = new AudioHandler(activity, songs);

        audioHandler.mediaPlayer.start();

        audioHandler.playMusic();

        assertEquals(false,audioHandler.mediaPlayer.isPlaying());

    }

    public void testPauseToPlay(){

        ArrayList<String> songs = new ArrayList<>();
        songs.add("a");

        AudioHandler audioHandler = new AudioHandler(activity, songs);

        audioHandler.mediaPlayer.start();

        audioHandler.playMusic();

        audioHandler.playMusic();

        assertEquals(true,audioHandler.mediaPlayer.isPlaying());

    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }
}
