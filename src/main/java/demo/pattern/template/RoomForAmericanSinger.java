package demo.pattern.template;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 14:35 2020-09-30
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class RoomForAmericanSinger extends KTVRoom {
    @Override
    protected void orderSong() {
        System.out.println("Chinese song in English");
    }
}
