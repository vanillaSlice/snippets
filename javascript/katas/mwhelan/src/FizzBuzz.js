/*
 * PROBLEM
 * Given a number i return:
 * - 'Fizz' if i is divisible by 3
 * - 'Buzz' if i is divisible by 5
 * - 'FizzBuzz' if i is divisible by 3 and 5
 * - i if i does not meet any of these conditions
 */

'use strict';

const FizzBuzz = {

  run: (i) => {
    let result = '';
    if (i % 3 === 0) result = 'Fizz';
    if (i % 5 === 0) result += 'Buzz';
    if (result === '') result = i;
    return result;
  }

};

module.exports = FizzBuzz;