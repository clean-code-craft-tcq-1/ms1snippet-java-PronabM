# Charge Validation Tool

This is a tool to validate charging parameters.

Given a set of values, it checks if they have 'sudden jumps'.
Such jumps indicate a failed / noisy sensor.

## Tasks

1. The 'No Duplications' check is failing. Resolve the duplication.
1. Give a good name to the function `_give_me_a_good_name`.
It is a boolean function, used in `if` statements.
Ensure that the `if` statement reads like a sentence after you rename the function.
1. The `values` parameter, given to the `validate...` function can be null.
Currently, the code does not handle that.
Ensure the code ignores a call with a null-parameter and add a test for that.

## Assignment Approach

1. Method `validateSOCreadings` and `validateCurrentreadings` were the source of duplications thus the common part was separated into a method called `validateReadings`.
2. `_give_me_a_good_name` method checked if the delta was greater than the maximum allowed limit, thus the method was renamed to `deltaExceedsLimit` as it would return true if it does. While using with the `if` statement it makes the phrase *if delta exceeds limit* which coveys the meaning.
3. The `values` parameter can be null or additionally can be either empty or can contain a null value or can contain a NaN value; in all the cases the input is invalid and the process should be stopped. Created a method `isValid` that checks all the conditions and further processing happens only if returned true.

## Additional Changes

1. The starter logic only considered positive delta but as the problem statement states 'sudden jumps' we should include both positive and negative delta. Used the magnitude of the difference and added corresponding test-cases for Jump-Ups (Positive) and Jump-Downs (Negative).
2. Test-cases only included negative tests thus added positive test cases where the readings were of stable nature for more coverage.