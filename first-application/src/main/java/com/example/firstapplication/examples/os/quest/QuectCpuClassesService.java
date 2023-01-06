package com.example.firstapplication.examples.os.quest;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.RandomStringUtils;

class QuectCpuClassesService {
    private static final int COUNT = 10000;

    private final AtomicInteger counter = new AtomicInteger();

    private final QuectCpuClassesService.CharSeqFirstImpl charSequence1 = new QuectCpuClassesService.CharSeqFirstImpl(RandomStringUtils.random(100));
    private final QuectCpuClassesService.CharSeqSecondImpl charSequence2 = new QuectCpuClassesService.CharSeqSecondImpl(charSequence1.toString());
    private final QuectCpuClassesService.CharSeqThirdImpl charSequence3 = new QuectCpuClassesService.CharSeqThirdImpl(charSequence1.toString());
    private final QuectCpuClassesService.CharSeqForthImpl charSequence4 = new QuectCpuClassesService.CharSeqForthImpl(charSequence1.toString());

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

    private static int hashCodeMega(AbstractCharSequence value) {
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

    private static int hashCodeTypeCheck(AbstractCharSequence value) {
        Class<? extends AbstractCharSequence> valueClass = value.getClass();
        if (valueClass == QuectCpuClassesService.CharSeqFirstImpl.class) {
            return hashCodeMegaFixed((QuectCpuClassesService.CharSeqFirstImpl) value);
        }
        if (valueClass == QuectCpuClassesService.CharSeqSecondImpl.class) {
            return hashCodeMegaFixed((QuectCpuClassesService.CharSeqSecondImpl) value);
        }
        if (valueClass == QuectCpuClassesService.CharSeqThirdImpl.class) {
            return hashCodeMegaFixed((QuectCpuClassesService.CharSeqThirdImpl) value);
        }
        if (valueClass == QuectCpuClassesService.CharSeqForthImpl.class) {
            return hashCodeMegaFixed((QuectCpuClassesService.CharSeqForthImpl) value);
        }
        throw new IllegalArgumentException();
    }

    private static int hashCodeMegaFixed(QuectCpuClassesService.CharSeqFirstImpl value) {
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

    private static int hashCodeMegaFixed(QuectCpuClassesService.CharSeqSecondImpl value) {
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

    private static int hashCodeMegaFixed(QuectCpuClassesService.CharSeqThirdImpl value) {
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

    private static int hashCodeMegaFixed(QuectCpuClassesService.CharSeqForthImpl value) {
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

    static abstract class AbstractCharSequence {
        abstract int length();

        abstract char charAt(int index);
    }

    static class CharSeqFirstImpl extends AbstractCharSequence {
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
    }

    static class CharSeqForthImpl extends AbstractCharSequence {
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
    }

    static class CharSeqSecondImpl extends AbstractCharSequence {
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
    }

    static class CharSeqThirdImpl extends AbstractCharSequence {
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
    }
}
