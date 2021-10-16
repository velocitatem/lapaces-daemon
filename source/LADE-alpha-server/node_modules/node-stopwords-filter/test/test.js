var stopwordsFilter = require('../');
var f = new stopwordsFilter();

console.log();

var assert = require('assert');

describe('Stopword Filter', function() {
	it ('should by no error', function() {
		var f = new stopwordsFilter();
		assert.ok(f);
	});

	it ('should be filter out stopword in english', function() {
		var input1 = "a whole new category is good for me";
		var result = f.filter(input1);
		assert.deepEqual([ 'category', 'good' ], result);
		console.log();
		console.log(input1, " ==> " ,result);
	});

	it ('should be filter out stopword in vietnamse', function() {
		f.setLanguage('vi');

		var input2 = "Chủ tịch mảng thiết bị của BlackBerry, ông Ron Louks cho biết Android 6.0 sẽ cập bến thiết bị này vào khoảng năm mới, tức là vào đầu tháng một";
		var result = f.filter(input2);

		console.log(input2, " ==> " ,result);
	});
});