package org.Framework;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.util.HashMap;

/**
 * Created by hsoh on 2017-04-03.
 */

public class SoundManager {
    private static SoundManager s_instance;
    private SoundPool           m_SoundPool;
    private HashMap             m_SoundPoolMap;
    private AudioManager        m_AudioManager;
    private Context             m_Activity;
    private MediaPlayer         m_MediaPlayer;
    public static SoundManager getInstance(){
        if( s_instance == null ){
            s_instance = new SoundManager();
        }
        return s_instance;
    }


    public void Init(Context _context) {
        SoundPool.Builder   m_SoundPoolBuilder;
        m_SoundPoolBuilder = new SoundPool.Builder();
        //m_SoundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0));
        m_SoundPool = m_SoundPoolBuilder.build();
        m_SoundPoolMap = new HashMap();
        m_AudioManager = (AudioManager) _context.getSystemService(Context.AUDIO_SERVICE);
        m_Activity = _context;
    }
    public void MakeMedia(int _index){
        m_MediaPlayer = MediaPlayer.create(m_Activity , _index);

    }

    public void addSound(int _index, int _soundID){
        int id = m_SoundPool.load(m_Activity, _soundID, 1);
        m_SoundPoolMap.put(_index, id);

    }
    public void play_Media(){
        m_MediaPlayer.start();

    }
    public void Pause_Media(){
        m_MediaPlayer.pause();
    }
    public void play(int _index) {
        float streamVolume = m_AudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        streamVolume = streamVolume /
                m_AudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        m_SoundPool.play((Integer) m_SoundPoolMap.get(_index),
                streamVolume, streamVolume,
                1, 0, 1f);
    }

    public void playLooped(int _index) {
        float streamVolume = m_AudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        streamVolume = streamVolume /
                m_AudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        m_SoundPool.play((Integer) m_SoundPoolMap.get(_index),
                streamVolume, streamVolume,
                1, -1, 1f);
    }


}
