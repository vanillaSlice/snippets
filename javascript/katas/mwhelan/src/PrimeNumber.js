/*
 * PROBLEM
 * Given a number n return if it is prime.
 */

'use strict';

const PrimeNumber = {

  isPrime: (n) => {
    if (n < 2) return false;
    for (let i = 2, mid = n / 2; i <= mid; i++) {
      if (n % i === 0) {
        return false;
      }
    }
    return true;
  }

};

module.exports = PrimeNumber;