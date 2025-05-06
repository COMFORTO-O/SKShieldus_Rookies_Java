package mylab.music.control;

import mylab.music.entity.*;

public class MusicPlayerTest {
    public static void main(String[] args) {
        System.out.println("===== 음악 재생 시스템 테스트 =====");

        // MP3 테스트
        System.out.println("\n--- MP3 테스트 ---");
        MP3 song1 = new MP3("Dynamite", "BTS", 5);
        song1.displayInfo();
        song1.play();
        song1.setVolume(8);
        song1.play();
        song1.stop();

        // Vinyl 테스트
        System.out.println("\n--- Vinyl 테스트 ---");
        Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
        vinyl.play();
        vinyl.clean();

        // 다형성 테스트
        System.out.println("\n--- 다형성 테스트 ---");
        MusicMedia song2 = new MP3("Butter", "BTS", 4);
        song2.displayInfo();
        song2.play();

        // 캐스팅 테스트
        System.out.println("\n--- 캐스팅 테스트 ---");
        if (song2 instanceof MP3) {
            MP3 mp3Song = (MP3) song2;
            mp3Song.setVolume(3);
            mp3Song.play();
            mp3Song.setVolume(7);
            mp3Song.stop();
        }
    }
}
