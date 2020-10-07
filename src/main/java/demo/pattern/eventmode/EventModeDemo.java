package demo.pattern.eventmode;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:42 2020-10-07
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class EventModeDemo {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        SingleClickEventListener singleClickEventListener = new SingleClickEventListener();
        DoubleClickEventListener doubleClickEventListener = new DoubleClickEventListener();
        Event event = new Event();
        event.setType("doubleClick");
        eventSource.register(singleClickEventListener);
        eventSource.register(doubleClickEventListener);
        eventSource.publishEvent(event);
    }
}
