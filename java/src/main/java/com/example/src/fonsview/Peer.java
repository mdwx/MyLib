package com.example.src.fonsview;

/**
 * Created by Arales on 2016/8/4.
 * E_mail :  xhys01@163.com
 * Description :
 */
public class Peer {
    private int runFlag;
    private String id="00:11:6d:16:bb:1f";
    private String ip;
    private String contentPath= "/mnt/sdcard/p2p_cdn_movies";
    private String prsip = "172.16.0.132";

    public Peer() {
    }

    public Peer(String contentPath, String id, String ip, String prsip, int runFlag) {

        this.contentPath = contentPath;
        this.id = id;
        this.ip = ip;
        this.prsip = prsip;
        this.runFlag = runFlag;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPrsip() {
        return prsip;
    }

    public void setPrsip(String prsip) {
        this.prsip = prsip;
    }

    public int getRunFlag() {
        return runFlag;
    }

    public void setRunFlag(int runFlag) {
        this.runFlag = runFlag;
    }

    @Override
    public String toString() {
        return "Peer{" +
                "contentPath='" + contentPath + '\'' +
                ", runFlag=" + runFlag +
                ", id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", prsip='" + prsip + '\'' +
                '}';
    }
}
