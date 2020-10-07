package demo.pattern.eventmode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:39 2020-10-07
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class EventSource {
    private List<EventListener> listenerList = new ArrayList<>();
    public void register(EventListener eventListener){
        listenerList.add(eventListener);
    }

    public void publishEvent(Event event){
        for (EventListener listener : listenerList){
            listener.processEvent(event);
        }
    }


}
