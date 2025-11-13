## Quick Start

To analyze all given example I used [JITWatch](https://github.com/AdoptOpenJDK/jitwatch) in `Sandbox` mode.
I was running it on macOS with aarch64.

## Inlining
1. To show version without Inlining: `Disable Inlining` and `-XX:TieredStopAtLevel=1`
2. To show version with Inlining: `-XX:TieredStopAtLevel=1`
3. To show version with unrolled loop: `-XX:TieredStopAtLevel=4`

## Bitwise
1. To show version with unrolled loop and bitwise operation (left shift): `-XX:TieredStopAtLevel=4`

## ConstantFolding
1. To show version with unrolled loop and constant folding: `-XX:TieredStopAtLevel=4`

## BranchElimination
1. To show version without branch elimination: `-XX:TieredStopAtLevel=1`
2. To show version with unrolled loop and branch elimination: `-XX:TieredStopAtLevel=4`
3. To show conditional select (csel) change condition to: `i % 2 == 0`

## Vectorization
1. To show version with unrolled loop and auto-vectorization: `-XX:TieredStopAtLevel=4`

## FunctionDispatching
1. Monomorphic dispatch with `initVehicleArray(1)`
2. Biomorphic dispatch with `initVehicleArray(2)`
3. Megamorphic dispatch with `initVehicleArray(3)`

## FunctionDispatchingFunctionalStyle
1. Dispatch with `initVehicleArray(3)`