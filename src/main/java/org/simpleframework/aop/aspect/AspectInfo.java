package org.simpleframework.aop.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.simpleframework.aop.PointcutLocator;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 13:31 2020-12-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Data
@AllArgsConstructor
public class AspectInfo {

    private int orderIndex;

    private DefaultAspect aspectObject;

    private PointcutLocator pointcutLocator;
}

