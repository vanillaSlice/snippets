var assert = require('assert');
var WordCounter = require('../src/WordCounter.js');

describe('WordCounter', function () {
  describe('#count', function () {
    it('\'\' should return {}', function () {
      assert.deepEqual({}, WordCounter.count(''));
    });
    it('\'hello\' should return { hello: 1}', function () {
      assert.deepEqual({
        hello: 1
      }, WordCounter.count('hello'));
    });
    it('\'hello,world,hello\' should return { hello: 2, world: 1 }', function () {
      assert.deepEqual({
        hello: 2,
        world: 1
      }, WordCounter.count('hello,world,hello'));
    });
    it('\'this,that,the,other\' should return { this: 1, that: 1, the: 1, other: 1 }', function () {
      assert.deepEqual({
        this: 1,
        that: 1,
        the: 1,
        other: 1
      }, WordCounter.count('this,that,the,other'));
    });
    it('\',,,,,,,\' should return {}', function () {
      assert.deepEqual({}, WordCounter.count(''));
    });
    it('\'hello;world;hello\' with delimiter should return { hello: 2, world: 1 }', function () {
      assert.deepEqual({
        hello: 2,
        world: 1
      }, WordCounter.count('hello;world;hello', ';'));
    });
    it('\'hello;;,world;;,hello;\ should return { \'hello;;\': 1, \'world;;\': 1, \'hello;\': 1 }',
      function () {
        assert.deepEqual({
          "hello;;": 1,
          "world;;": 1,
          "hello;": 1
        }, WordCounter.count('hello;;,world;;,hello;'));
      });
    it('\'hello,,;world,,;hello,\' with delimiter should ' +
      'return { \'hello,,\': 1, \'world,,\': 1, \'hello,\': 1 }',
      function () {
        assert.deepEqual({
          "hello,,": 1,
          "world,,": 1,
          "hello,": 1
        }, WordCounter.count('hello,,;world,,;hello,', ';'));
      });
  });
});