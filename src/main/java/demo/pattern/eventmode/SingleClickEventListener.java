package demo.pattern.eventmode;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:38 2020-10-07
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class SingleClickEventListener implements EventListener {
    @Override
    public void processEvent(Event event) {
        if ("singleClick".equals(event.getType())){
            System.out.println("单击被触发");
        }
    }
}
