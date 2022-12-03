package com.example.firstapplication.examples.context;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import io.micrometer.tracing.handler.TracingObservationHandler.TracingContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class AsyncProfilerObservationHandler implements ObservationHandler<Observation.Context> {
    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }

    @Override
    public void onStart(Observation.Context context) {
        TracingContext tracingContext = context.get(TracingContext.class);
        log.info("onStart {}", tracingContext.getSpan().context().traceId());
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
        log.info("onStop {}", tracingContext.getSpan().context().traceId());
    }
}
