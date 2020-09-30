package demo.pattern.template;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 14:38 2020-09-30
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class TemplateDemo {
    public static void main(String[] args) {
        KTVRoom room1 = new RoomForAmericanSinger();
        KTVRoom romm2 = new RoomForChineseSinger();
        room1.procedure();
        System.out.println("+++++++++++++++++++++++++++++");
        romm2.procedure();
    }
}
