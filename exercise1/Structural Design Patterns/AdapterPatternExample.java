package exercise1;
//Use Case 5: Adapter Pattern (Structural)

//Target Interface
interface MediaPlayer {
 void play(String audioType, String fileName);
}

//Adaptee
interface AdvancedMediaPlayer {
 void playMp4(String fileName);
 void playVlc(String fileName);
}

//Concrete Adaptee 1
class VlcPlayer implements AdvancedMediaPlayer {
 @Override
 public void playMp4(String fileName) {
     // Do nothing
 }

 @Override
 public void playVlc(String fileName) {
     System.out.println("Playing VLC file: " + fileName);
 }
}

//Adapter Class
class MediaAdapter implements MediaPlayer {
 AdvancedMediaPlayer advancedMediaPlayer;

 public MediaAdapter(String audioType) {
     if (audioType.equalsIgnoreCase("vlc")) {
         advancedMediaPlayer = new VlcPlayer();
     }
     // Extend further for other types like mp4.
 }

 @Override
 public void play(String audioType, String fileName) {
     if (audioType.equalsIgnoreCase("vlc")) {
         advancedMediaPlayer.playVlc(fileName);
     }
 }
}

//Usage
public class AdapterPatternExample {
 public static void main(String[] args) {
     MediaPlayer player = new MediaAdapter("vlc");
     player.play("vlc", "movie.vlc");
 }
}
