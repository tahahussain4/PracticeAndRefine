// ROUTED FUNCTIONS

var exec = require("child_process").exec;
var fs = require("fs");
var formidable = require("formidable");
var querystring = require("querystring")

function start(response){

	var body = '<html>'+
					 '<head>'+
						 '<meta http-equiv="Content-Type" content="text/html"; '+
						 'charset=UTF-8" />'+
					 '</head>'+
					 '<body>'+
						 '<form action="/upload" enctype="multipart/form-data" method="post">'+
							 '<input type="file" name="upload" multiple="multiple">'+
							 '<input type="submit" value="Submit text" />'+
						 '</form>'+
					 '</body>'+
				'</html>';

	response.writeHead(200,{ "Content-Type" : "text/html" })
	response.write(body)
	response.end()

	console.log("startRequested")
}

function upload(response,request){

	var form = new formidable.IncomingForm();
	form.parse(request,function(error,field,files){
		console.log("parsing done")
		fs.rename(files.upload.path,"/tmp/test.png",function(error){
			if(error){
				console.log("error in renaming")
				fs.unlink("/tmp/test.png")
				fs.rename(files.upload.path, "/tmp/test.png");
			}
		})

	})

	response.writeHead(200,{ "Content-Type" : "text/html" })
    response.write("received image:<br/>");
    response.write("<img src='/show' />");
	response.end()
	
	console.log("uploadRequested")
}

function show(response) {
    console.log("Request handler 'show' was called.");
 	response.writeHead(200, {"Content-Type": "image/png"});
	fs.createReadStream("/tmp/test.png").pipe(response);
}

exports.start = start
exports.upload = upload
exports.show = show