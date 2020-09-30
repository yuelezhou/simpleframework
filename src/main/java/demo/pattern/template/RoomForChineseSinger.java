package demo.pattern.template;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 14:34 2020-09-30
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class RoomForChineseSinger extends KTVRoom {
    @Override
    protected void orderSong() {
        System.out.println("来首劲爆的中文歌");
    }

    @Override
    protected void orderExtra() {
        System.out.println("东西真便宜，一样来一份");
    }
}
