package com.example.firstapplication.examples.os.quest;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.RandomStringUtils;

class QuectCpuInterfaceService {
    private static final int COUNT = 10000;

    private final AtomicInteger counter = new AtomicInteger();

    private final QuectCpuInterfaceService.CharSeqFirstImpl charSequence1 = new QuectCpuInterfaceService.CharSeqFirstImpl(RandomStringUtils.random(100));
    private final QuectCpuInterfaceService.CharSeqSecondImpl charSequence2 = new QuectCpuInterfaceService.CharSeqSecondImpl(charSequence1.toString());
    private final QuectCpuInterfaceService.CharSeqThirdImpl charSequence3 = new QuectCpuInterfaceService.CharSeqThirdImpl(charSequence1.toString());
    private final QuectCpuInterfaceService.CharSeqForthImpl charSequence4 = new QuectCpuInterfaceService.CharSeqForthImpl(charSequence1.toString());

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
