
function route(pathname,handle,response,request){
	console.log("type of = " + typeof(pathname))
	console.log("about to route request for " + pathname);
	if(typeof(handle[pathname]) === 'function'){
		handle[pathname](response,request);
	}
}

exports.route = route		