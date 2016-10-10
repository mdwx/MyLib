package com.example.src.fonsview;

import java.util.Arrays;

/**
 * Created by Arales on 2016/7/28.
 * E_mail :  xhys01@163.com
 * Description :
 */
public class PackFormat {
    private int startId;
    private int dataTpye;
    private int dataSequence;
    private int dataLength;
    private String sendToAddr;
    private int sendToPort;
    private byte data[];

    public PackFormat(byte[] data, int dataLength, int dataSequence, int dataTpye, String sendToAddr, int sendToPort, int startId) {
        this.data = data;
        this.dataLength = dataLength;
        this.dataSequence = dataSequence;
        this.dataTpye = dataTpye;
        this.sendToAddr = sendToAddr;
        this.sendToPort = sendToPort;
        this.startId = startId;
    }


    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    public int getDataSequence() {
        return dataSequence;
    }

    public void setDataSequence(int dataSequence) {
        this.dataSequence = dataSequence;
    }

    public int getDataTpye() {
        return dataTpye;
    }

    public void setDataTpye(int dataTpye) {
        this.dataTpye = dataTpye;
    }

    public String getSendToAddr() {
        return sendToAddr;
    }

    public void setSendToAddr(String sendToAddr) {
        this.sendToAddr = sendToAddr;
    }

    public int getSendToPort() {
        return sendToPort;
    }

    public void setSendToPort(int sendToPort) {
        this.sendToPort = sendToPort;
    }

    public int getStartId() {
        return startId;
    }

    public void setStartId(int startId) {
        this.startId = startId;
    }

    @Override
    public String toString() {
        return "PackFormat{" +
                "data=" + Arrays.toString(data) +
                ", startId=" + startId +
                ", dataTpye=" + dataTpye +
                ", dataSequence=" + dataSequence +
                ", dataLength=" + dataLength +
                ", sendToAddr='" + sendToAddr + '\'' +
                ", sendToPort=" + sendToPort +
                '}';
    }
}
