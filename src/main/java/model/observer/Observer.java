package model.observer;

import java.awt.*;
import java.util.List;

/**
 * Created by yanice on 21/12/16.
 */
public interface Observer {
    void update();

    void update(String target,Color color);
}
