package com.anas.singleton;

public enum EnumSingleton {
    INSTANCE;

    private int counter;

    public int next() { return ++counter; }
}