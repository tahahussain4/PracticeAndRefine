console.log("hello")

var http = require("http");
var fs = require("fs");
var url = require("url")
var router = require("./router")
var endpoints = require("./endpoints")
var formidable = require("formidable")


handle = {}
handle["/"] = endpoints.start
handle["/start"] = endpoints.start
handle["/upload"] = endpoints.upload
handle["/show"] = endpoints.show
//HTTP REQUEST CALLBACK
function onRequest(request,response){
	var pathname = url.parse(request.url).pathname;
	var postdata = ""
	var form = formidable.IncomingForm();

	console.log("pathname : " + pathname)

	router.route(pathname,handle,response,request)

}


http.createServer(onRequest).listen(8888);

// http.createServer(function(request, response) {
// 	fs.readFile('basic.html',function(err,data) {
//   		response.writeHead(200, {"Content-Type": "text/html"});
//   		response.write(data);
//   		response.end();
// 	});
// }).listen(8888);

