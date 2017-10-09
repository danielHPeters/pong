package pong.audio;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * A music player which plays a list of wav files in the background.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class BackgroundMusicPlayer {
  private final DirectoryScanner dirScan;
  private final List<AudioClip> clips;

  /**
   * Default constructor.
   * Gets all wav files and loads them into the clips list and shuffles the list.
   */
  public BackgroundMusicPlayer() {
    this.dirScan = new DirectoryScanner("src/wav");
    this.clips = dirScan.getDirContents();
    Collections.shuffle(clips);
  }

  /**
   * Plays all clips from the list.
   */
  public void playAllClips() {
    URL url;
    Clip clip;
    AudioInputStream inputStream;
    LineListener listener;

    for (AudioClip clip1 : clips) {
      try {
        listener = (LineEvent event) -> {
          Type eventType = event.getType();
          if (eventType == Type.STOP || eventType == Type.CLOSE) {
            System.out.println("Audio stopped.");
          }
        };

        url = this.getClass().getClassLoader().getResource("wav/" + clip1.getLocation());
        System.out.println(url.toString());
        clip = AudioSystem.getClip();
        inputStream = AudioSystem.getAudioInputStream(url);

        clip.addLineListener(listener);
        clip.open(inputStream);
        clip.start();

        while (clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {
          System.out.println("Playing audio");
        }
      } catch (LineUnavailableException ex) {
        System.out.println("Audios error.");
      } catch (UnsupportedAudioFileException ex) {
        System.out.println("Wrong audio type.");
      } catch (IOException ex) {
        System.out.println("File not found.");
      }
    }
  }
}
