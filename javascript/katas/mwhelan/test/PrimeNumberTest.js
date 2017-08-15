var assert = require('assert');
var PrimeNumber = require('../src/PrimeNumber.js');

describe('PrimeNumber', function () {
  describe('#isPrime()', function () {
    it('-1 should return false', function () {
      assert.equal(false, PrimeNumber.isPrime(-1));
    });
    it('0 should return false', function () {
      assert.equal(false, PrimeNumber.isPrime(0));
    });
    it('1 should return false', function () {
      assert.equal(false, PrimeNumber.isPrime(1));
    });
    it('2 should return true', function () {
      assert.equal(true, PrimeNumber.isPrime(2));
    });
    it('3 should return true', function () {
      assert.equal(true, PrimeNumber.isPrime(3));
    });
    it('4 should return false', function () {
      assert.equal(false, PrimeNumber.isPrime(4));
    });
    it('5 should return true', function () {
      assert.equal(true, PrimeNumber.isPrime(5));
    });
    it('6 should return false', function () {
      assert.equal(false, PrimeNumber.isPrime(6));
    });
    it('7 should return true', function () {
      assert.equal(true, PrimeNumber.isPrime(7));
    });
    it('11 should return true', function () {
      assert.equal(true, PrimeNumber.isPrime(11));
    });
  });
});