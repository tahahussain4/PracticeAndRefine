'use strict';

// var greet = require("../src/greet")

// describe('greet',function(){

// 	it("greets person passed in function",function(){
// 		expect(greet('joe')).toEqual("hello joe !");    
// 	});

// 	it("greets defaul message if name is not defined",function(){
// 		expect(greet()).toEqual("hello savious !");
// 	});
// });


var greet = require('../src/greet'); 

describe("greet", function() {

	it('should greet the given name', function() { 
		expect(greet('Joe')).toEqual('Hello Joe!');
	});

	it('should greet no-one special if no name is given', function() { 
		expect(greet()).toEqual('Hello World!');
	}); 

});
