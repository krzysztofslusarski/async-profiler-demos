package com.example.firstapplication.examples.os.quest;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/os/quest/cpu")
@RequiredArgsConstructor
class QuestCpuController {
    public static final int COUNT = 60000;

    private final AtomicInteger counter = new AtomicInteger();

    private final String charSequence1 = "a";
    private final StringBuilder charSequence2 = new StringBuilder("a");
    private final StringBuffer charSequence3 = new StringBuffer("a");

    private final CharSequence[] charSequences = new CharSequence[]{charSequence1, charSequence2, charSequence3};

    @GetMapping("/bimorphic")
    String bimorphic() {
        int currentVal = counter.incrementAndGet();
        for (int i = 0; i < COUNT; i++) {
            currentVal += hashCodeBi(charSequences[i % 2]);
        }
        return "" + currentVal;
    }

    @GetMapping("/megamorphic")
    String megamorphic() {
        int currentVal = counter.incrementAndGet();
        for (int i = 0; i < COUNT; i++) {
            currentVal += hashCodeMega(charSequences[i % 3]);
        }
        return "" + currentVal;
    }

    @GetMapping("/megamorphic-hacked")
    String megamorphicHacked() {
        int currentVal = counter.incrementAndGet();
        for (int i = 0; i < COUNT; i++) {
            CharSequence charSequence = charSequences[i % 3];
            switch (charSequence.getClass().hashCode() & 3) {
                case 0 -> currentVal += hashCodeMega1(charSequence);
                case 1 -> currentVal += hashCodeMega2(charSequence);
                case 2 -> currentVal += hashCodeMega3(charSequence);
                case 3 -> currentVal += hashCodeMega4(charSequence);
            }
        }
        return "" + currentVal;
    }

    @GetMapping("/megamorphic-fixed")
    String megamorphicFixed() {
        int currentVal = counter.incrementAndGet();
        for (int i = 0; i < COUNT; i += 3) {
            currentVal += hashCodeMegaFixed(charSequence1);
            currentVal += hashCodeMegaFixed(charSequence2);
            currentVal += hashCodeMegaFixed(charSequence3);
        }
        return "" + currentVal;
    }

    public static int hashCodeBi(CharSequence value) {
        if (value instanceof String) {
            return value.hashCode();
        }
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

    public static int hashCodeMega(CharSequence value) {
        if (value instanceof String) {
            return value.hashCode();
        }
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

    public static int hashCodeMega1(CharSequence value) {
        if (value instanceof String) {
            return value.hashCode();
        }
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

    public static int hashCodeMega2(CharSequence value) {
        if (value instanceof String) {
            return value.hashCode();
        }
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

    public static int hashCodeMega3(CharSequence value) {
        if (value instanceof String) {
            return value.hashCode();
        }
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

    public static int hashCodeMega4(CharSequence value) {
        if (value instanceof String) {
            return value.hashCode();
        }
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

    public static int hashCodeMegaFixed(CharSequence value) {
        if (value instanceof String) {
            return value.hashCode();
        }
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

    public static int hashCodeMegaFixed(String value) {
        return value.hashCode();
    }

    public static int hashCodeMegaFixed(StringBuilder value) {
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

    public static int hashCodeMegaFixed(StringBuffer value) {
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
}
