package com.example.common;

import static com.example.common.HexCodec.lowerHexToUnsignedLong;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import io.micrometer.tracing.TraceContext;
import io.micrometer.tracing.handler.TracingObservationHandler.TracingContext;

@SuppressWarnings("ConstantConditions")
public class AsyncProfilerObservationHandler implements ObservationHandler<Observation.Context> {
    private static final ThreadLocal<TraceContext> LOCAL_TRACE_CONTEXT = new ThreadLocal<>();

    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }

    @Override
    public void onStart(Observation.Context context) {
        TracingContext tracingContext = context.get(TracingContext.class);
        TraceContext traceContext = tracingContext.getSpan().context();
        TraceContext currentTraceContext = LOCAL_TRACE_CONTEXT.get();

        if (currentTraceContext == null || !currentTraceContext.traceId().equals(traceContext.traceId())) {
            LOCAL_TRACE_CONTEXT.set(traceContext);
            AsyncProfilerUtils.load().setContextId(lowerHexToUnsignedLong(traceContext.traceId()));
        }
    }

    @Override
    public void onError(Observation.Context context) {
    }

    @Override
    public void onEvent(Observation.Event event, Observation.Context context) {
    }

    @Override
    public void onStop(Observation.Context context) {
        TracingContext tracingContext = context.get(TracingContext.class);
        TraceContext traceContext = tracingContext.getSpan().context();
        TraceContext currentTraceContext = LOCAL_TRACE_CONTEXT.get();
        if (currentTraceContext != null && currentTraceContext.spanId().equals(traceContext.spanId())) {
            LOCAL_TRACE_CONTEXT.remove();
            AsyncProfilerUtils.load().clearContextId();
        }
    }
}
