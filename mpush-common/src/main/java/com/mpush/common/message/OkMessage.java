package com.mpush.common.message;

import com.mpush.api.connection.Connection;
import com.mpush.api.protocol.Packet;
import io.netty.buffer.ByteBuf;

import static com.mpush.api.protocol.Command.OK;

/**
 * Created by ohun on 2015/12/28.
 *
 * @author ohun@live.cn
 */
public final class OkMessage extends ByteBufMessage {
    public byte cmd;
    public byte code;
    public String data;

    public OkMessage(byte cmd, Packet message, Connection connection) {
        super(message, connection);
        this.cmd = cmd;
    }

    public OkMessage(Packet message, Connection connection) {
        super(message, connection);
    }

    @Override
    public void decode(ByteBuf body) {
        cmd = decodeByte(body);
        code = decodeByte(body);
        data = decodeString(body);
    }

    @Override
    public void encode(ByteBuf body) {
        encodeByte(body, cmd);
        encodeByte(body, code);
        encodeString(body, data);
    }

    public static OkMessage from(BaseMessage src) {
        return new OkMessage(src.packet.cmd, new Packet(OK
                , src.packet.sessionId), src.connection);
    }

    public OkMessage setCode(byte code) {
        this.code = code;
        return this;
    }

    public OkMessage setData(String data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "OkMessage{" +
                "data='" + data + '\'' +
                "packet='" + packet + '\'' +
                '}';
    }
}
