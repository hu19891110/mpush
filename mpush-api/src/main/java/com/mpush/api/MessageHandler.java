package com.mpush.api;

import com.mpush.api.protocol.Packet;
import com.mpush.api.connection.Connection;

/**
 * Created by ohun on 2015/12/22.
 *
 * @author ohun@live.cn
 */
public interface MessageHandler {
    void handle(Packet packet, Connection connection);
}
