/*
Claritas: ‘Clarity through innovation’

Unit Test Script

Project: SocBox
Module: Audio Handler
Test Script Name: AudioHandlerTester.java
Associated Code File Name: AudioHandler.java

Description: This class tests the functionality of the Audio Handler Module to match the
requirements found in the User Stories and Design Specification. 

Initial Authors: Andrew Perry
                 Carlos Archila

Change History:
Version: 0.1
Author: Andrew Perry
Change: Created original version
Date: 03/03/15

Version: 0.2
Author: Carlos Archila
Change: Added header and comments to existing tests
Date: 12/03/15

User Story Traceabilty:
Tag(s):
U/SM/03/01

Requirements not covered in this script: 

U/SM/01/01
Justification: Cannot be unit tested, to undergo HMI testing. Issue Log number

U/SM/02/01
Justification: Cannot be unit tested, to undergo HMI testing. Issue Log number

U/SM/04/01
Justification: Cannot be unit tested, to undergo HMI testing. Issue Log number

U/SM/05/01
Justification: Cannot be unit tested, to undergo HMI testing. Issue Log number
*/

//Package
package first.test1.com.myapplication;

//Import Packages
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import java.util.ArrayList;

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
    /*Testing adding a single string to the songs Array*/
    public void testURL(){
        ArrayList<String> songs = new ArrayList<>();
        songs.add("a");

        AudioHandler audioHandler = new AudioHandler(activity,songs);

        assertEquals("a", audioHandler.URLs.get(0));
    }
    
    /*Testing adding a single string to the songs Array*/
    public void testURLs(){
        ArrayList<String> songs = new ArrayList<>();
        songs.add("a");
        songs.add("b");

        AudioHandler audioHandler = new AudioHandler(activity,songs);

        assertEquals("b", audioHandler.URLs.get(1));
    }
    
    /*Testing selecting a song from the songs Array*/
    public void testCurrentSong(){
        ArrayList<String> songs = new ArrayList<>();
        songs.add("a");
        songs.add("b");

        AudioHandler audioHandler = new AudioHandler(activity,songs);

        audioHandler.CurrentSong = 1;

        assertEquals("b", audioHandler.URLs.get(audioHandler.CurrentSong));
    }
    
    /*Testing playlist creation*/
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
    
    /* Testing the pause function of the audio player from playing:
       Requirements: U/SM/03/01
       Notes: N/A
    */
    public void testPause(){

        ArrayList<String> songs = new ArrayList<>();
        songs.add("a");

        AudioHandler audioHandler = new AudioHandler(activity, songs);

        audioHandler.mediaPlayer.start();

        audioHandler.playMusic();

        assertEquals(false,audioHandler.mediaPlayer.isPlaying());

    }
    
    /* Testing the play function of the audio player from paused:
       Requirements: D/SMF/05/01
       Notes: Test not passed. Reason unknown.
    */
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
