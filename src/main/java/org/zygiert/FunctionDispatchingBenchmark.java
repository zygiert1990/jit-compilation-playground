package org.zygiert;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static org.zygiert.FunctionDispatching.*;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class FunctionDispatchingBenchmark {

    private Vehicle[] vehicles1;
    private Vehicle[] vehicles2;
    private Vehicle[] vehicles3;
    private Vehicle[] vehicles4;
    private Vehicle[] vehicles5;

    @Setup
    public void setup() {
        vehicles1 = initVehicleArray(1);
        vehicles2 = initVehicleArray(2);
        vehicles3 = initVehicleArray(3);
        vehicles4 = initVehicleArray(4);
        vehicles5 = initVehicleArray(5);
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 0)
    @Measurement(iterations = 1)
    public void benchmark_1_VehicleType_NoWarmup(Blackhole blackhole) {
        blackhole.consume(compute(vehicles1));
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 0)
    @Measurement(iterations = 1)
    public void benchmark_2_VehicleTypes_NoWarmup(Blackhole blackhole) {
        blackhole.consume(compute(vehicles2));
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 0)
    @Measurement(iterations = 1)
    public void benchmark_3_VehicleTypes_NoWarmup(Blackhole blackhole) {
        blackhole.consume(compute(vehicles3));
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 0)
    @Measurement(iterations = 1)
    public void benchmark_4_VehicleTypes_NoWarmup(Blackhole blackhole) {
        blackhole.consume(compute(vehicles4));
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 0)
    @Measurement(iterations = 1)
    public void benchmark_5_VehicleTypes_NoWarmup(Blackhole blackhole) {
        blackhole.consume(compute(vehicles5));
    }

    static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(FunctionDispatchingBenchmark.class.getSimpleName())
                .mode(Mode.AverageTime)
                .build();

        new Runner(opt).run();
    }
}