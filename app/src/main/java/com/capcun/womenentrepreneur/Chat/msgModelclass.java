//package com.av.avmessenger;
//
//public class msgModelclass {
//    String message;
//    String senderid;
//    long timeStamp;
//
//    public msgModelclass() {
//    }
//
//    public msgModelclass(String message, String senderid, long timeStamp) {
//        this.message = message;
//        this.senderid = senderid;
//        this.timeStamp = timeStamp;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getSenderid() {
//        return senderid;
//    }
//
//    public void setSenderid(String senderid) {
//        this.senderid = senderid;
//    }
//
//    public long getTimeStamp() {
//        return timeStamp;
//    }
//
//    public void setTimeStamp(long timeStamp) {
//        this.timeStamp = timeStamp;
//    }
//}


package com.capcun.womenentrepreneur.Chat;

public class msgModelclass {

    String sender_id, msg, receiver_id, time;

    public msgModelclass(String sender_id, String msg, String receiver_id, String time) {
        this.sender_id = sender_id;
        this.msg = msg;
        this.receiver_id = receiver_id;
        this.time = time;
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
