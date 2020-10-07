package demo.pattern.eventmode;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:39 2020-10-07
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class DoubleClickEventListener implements EventListener {
    @Override
    public void processEvent(Event event) {
        if ("doubleClick".equals(event.getType())){
            System.out.println("双击被触发");
        }
    }
}
