package com.example.firstapplication.examples.os.quest;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.atomic.AtomicInteger;

class QuectCpuInterfaceService {
    private static final int COUNT = 10000;

    public static void main(String[] args) {
        System.out.println(CharSeqFirstImpl.class.hashCode() & 127);
        System.out.println(CharSeqSecondImpl.class.hashCode() & 127);
        System.out.println(CharSeqThirdImpl.class.hashCode() & 127);
        System.out.println(CharSeqForthImpl.class.hashCode() & 127);
    }

    private final AtomicInteger counter = new AtomicInteger();

    private final CharSeqFirstImpl charSequence1 = new CharSeqFirstImpl(RandomStringUtils.random(100));
    private final CharSeqSecondImpl charSequence2 = new CharSeqSecondImpl(charSequence1.toString());
    private final CharSeqThirdImpl charSequence3 = new CharSeqThirdImpl(charSequence1.toString());
    private final CharSeqForthImpl charSequence4 = new CharSeqForthImpl(charSequence1.toString());

    int megamorphic() {
        int currentVal = counter.incrementAndGet();
        for (int i = 0; i < COUNT; i++) {
            currentVal += hashCodeMega(charSequence1);
            currentVal += hashCodeMega(charSequence2);
            currentVal += hashCodeMega(charSequence3);
            currentVal += hashCodeMega(charSequence4);
        }
        return currentVal;
    }

    int megamorphicHacked() {
        int currentVal = counter.incrementAndGet();
        for (int i = 0; i < COUNT; i++) {
            currentVal += hashCodeHacked(charSequence1);
            currentVal += hashCodeHacked(charSequence2);
            currentVal += hashCodeHacked(charSequence3);
            currentVal += hashCodeHacked(charSequence4);
        }
        return currentVal;
    }

    int megamorphicTypeCheck() {
        int currentVal = counter.incrementAndGet();
        for (int i = 0; i < COUNT; i++) {
            currentVal += hashCodeTypeCheck(charSequence1);
            currentVal += hashCodeTypeCheck(charSequence2);
            currentVal += hashCodeTypeCheck(charSequence3);
            currentVal += hashCodeTypeCheck(charSequence4);
        }
        return currentVal;
    }

    int megamorphicFixed() {
        int currentVal = counter.incrementAndGet();
        for (int i = 0; i < COUNT; i++) {
            currentVal += hashCodeMegaFixed(charSequence1);
            currentVal += hashCodeMegaFixed(charSequence2);
            currentVal += hashCodeMegaFixed(charSequence3);
            currentVal += hashCodeMegaFixed(charSequence4);
        }
        return currentVal;
    }

    private static int hashCodeMega(CharSequence value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }

    private static int hashCodeHacked(CharSequence value) {
        int valueClassHashCode = value.getClass().hashCode() & 127;
        int len = switch (valueClassHashCode) {
            case 2 -> value.length();
            case 9 -> value.length();
            case 65 -> value.length();
            case 73 -> value.length();
            default -> throw new IllegalStateException("Unexpected value: " + valueClassHashCode);
        };

        if (len == 0) {
            return 0;
        }

        int h = 0;
        for (int p = 0; p < len; p++) {
            h = switch (valueClassHashCode) {
                case 2 -> 31 * h + value.charAt(p);
                case 9 -> 31 * h + value.charAt(p);
                case 65 -> 31 * h + value.charAt(p);
                case 73 -> 31 * h + value.charAt(p);
                default -> throw new IllegalStateException("Unexpected value: " + valueClassHashCode);
            };
        }
        return h;
    }

    private static int hashCodeTypeCheck(CharSequence value) {
        Class<? extends CharSequence> valueClass = value.getClass();
        if (valueClass == QuectCpuInterfaceService.CharSeqFirstImpl.class) {
            return hashCodeMegaFixed((QuectCpuInterfaceService.CharSeqFirstImpl) value);
        }
        if (valueClass == QuectCpuInterfaceService.CharSeqSecondImpl.class) {
            return hashCodeMegaFixed((QuectCpuInterfaceService.CharSeqSecondImpl) value);
        }
        if (valueClass == QuectCpuInterfaceService.CharSeqThirdImpl.class) {
            return hashCodeMegaFixed((QuectCpuInterfaceService.CharSeqThirdImpl) value);
        }
        if (valueClass == QuectCpuInterfaceService.CharSeqForthImpl.class) {
            return hashCodeMegaFixed((QuectCpuInterfaceService.CharSeqForthImpl) value);
        }
        throw new IllegalArgumentException();
    }

    private static int hashCodeMegaFixed(QuectCpuInterfaceService.CharSeqFirstImpl value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }

    private static int hashCodeMegaFixed(QuectCpuInterfaceService.CharSeqSecondImpl value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }

    private static int hashCodeMegaFixed(QuectCpuInterfaceService.CharSeqThirdImpl value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }

    private static int hashCodeMegaFixed(QuectCpuInterfaceService.CharSeqForthImpl value) {
        int len = value.length();
        if (len == 0) {
            return 0;
        }
        int h = 0;
        for (int p = 0; p < len; p++) {
            h = 31 * h + value.charAt(p);
        }
        return h;
    }

    static class CharSeqFirstImpl implements CharSequence {
        private final String value;

        CharSeqFirstImpl(String value) {
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

    static class CharSeqForthImpl implements CharSequence {
        private final String value;

        CharSeqForthImpl(String value) {
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

    static class CharSeqSecondImpl implements CharSequence {
        private final String value;

        CharSeqSecondImpl(String value) {
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

    static class CharSeqThirdImpl implements CharSequence {
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
}
