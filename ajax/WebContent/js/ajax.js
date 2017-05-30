         function Ajax() {
	var xhr = null;
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else {
		xhr = new ActiveXObject("Microsoft.XMLHttp");
	}
	this.get=function(url,fun,type){
		xhr.open("GET",url,true);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					if(typeof(fun)=='function'){
						var data = null;
						if(type=="xml"){
							data = xhr.responseXML;
						}else{
							data = xhr.responseText;
							if(type=="json"){
								data = eval("("+data+")");
							}
						}
						fun(data);//回调
					}
				}
			}
		};
		xhr.send();
	};
	this.post=function(url,fun,type){
		xhr.open("POST",url,true);
		xhr.setRequestHeader("Context-type","application/x-www-form-urlencoded");
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					if(typeof(fun)=='function'){
						var data=null;
					if(type=="xml"){
						data =xhr.responseXML;
					}else{
						data =xhr.responseText;
					if(type=="json"){
							data =eval("("+data+")")
						}					
					  }
					fun(data);
					}
				}
			}
		};
		
		xhr.send();
	};
}