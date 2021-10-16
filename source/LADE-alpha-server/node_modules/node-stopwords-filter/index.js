'use strict';

;(function() {

	/** Used as a safe reference for `undefined` in pre-ES5 environments. */
	var undefined;
	var root = this;
	var has_require = typeof require !== 'undefined';

	var Tokenizer = require('node-vntokenizer');
	var token = new Tokenizer();

	var StopwordFilter = function(options) {
		this.options = options || {};
		this.language = this.options.language || this.options.lang || 'en';

		this.stopwords = [];
		this.loadStopwordData(this.language);
	}

	StopwordFilter.prototype.loadStopwordData = function(lang) {
		var lang = lang || this.language || 'en';

		if (lang == 'vi' || lang == 'vn') {
			this.stopwords = require('vietnamese-stopwords');
		} else { // default: en
			this.stopwords = require('stopwords').english
		}
	}

	StopwordFilter.prototype.setStopwords = function(data) {
		this.stopwords = data;
	}

	StopwordFilter.prototype.setLanguage = function(lang) {
		this.language = lang;
		this.loadStopwordData();
	}

	StopwordFilter.prototype.filter = function(text, outputType) {
		var words = text;

		if (typeof text === 'string')
			words = token.tokenize(text);
		else if (typeof text !== 'array')
			throw Error("Input string must be String or Array. Current: " + (typeof text));

		var outputType = outputType || 'array';

        var keywords = [];
        for (var i = 0; i < words.length; i++) {
                var word = words[i].toLowerCase().trim();
                if (this.stopwords.indexOf(word) === -1 && keywords.indexOf(word) === -1) {
                        keywords.push(word);
                }
        }

        // String output
        if (outputType != 'array') {
        	return keywords.join(' ');
        }
    
        return keywords;
	}

	// Exports
	if( typeof exports !== 'undefined' ) {
		if( typeof module !== 'undefined' && module.exports ) {
			exports = module.exports = StopwordFilter;
		}
		exports.StopwordFilter = StopwordFilter;
	} else {
		root.StopwordFilter = StopwordFilter;
	}
}.call(this));