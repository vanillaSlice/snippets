var assert = require('assert');
var Anagrams = require('../src/Anagrams.js');

describe('Anagrams', function () {
  describe('#getAnagrams()', function () {
    it('\'\'\ should return [\'\']', function () {
      assert.equal('', Anagrams.getAnagrams(''));
    })
    it('\'a\' should return [\'a\']', function () {
      assert.equal('a', Anagrams.getAnagrams('a'));
    });
    it('\'ab\' should return [\'ab\',\'ba\']', function () {
      assert.equal('ab,ba', Anagrams.getAnagrams('ab'));
    });
    it('\'abc\' should return [\'abc\',\'acb\',\'bac\',\'bca\',\'cab\',\'cba\']', function () {
      assert.equal('abc,acb,bac,bca,cab,cba', Anagrams.getAnagrams('abc'));
    });
    it('\'aaa\' should return [\'aaa\',\'aaa\',\'aaa\',\'aaa\',\'aaa\',\'aaa\']', function () {
      assert.equal('aaa,aaa,aaa,aaa,aaa,aaa', Anagrams.getAnagrams('aaa'));
    });
  });
});