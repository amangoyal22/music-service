package com.example.trial.enums;

public enum UserType {

    COMMON((byte)0),
    OWNER((byte)1);

    byte type;

    UserType(byte type) {
        this.type = type;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
}