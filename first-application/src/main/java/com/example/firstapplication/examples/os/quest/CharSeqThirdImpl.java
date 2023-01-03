package com.example.firstapplication.examples.os.quest;

class CharSeqThirdImpl implements CharSequence {
    private final String value;

    CharSeqThirdImpl(String value) {
        this.value = value;
    }

    @Override
    public int length() {
        return value.length();
    }

    @Override
    public char charAt(int index) {
        return value.charAt(index);
    }

    @Override
    public boolean isEmpty() {
        return value.isEmpty();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return value.subSequence(start, end);
    }
}
