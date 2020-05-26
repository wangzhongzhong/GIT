layui.define(['table', 'form', 'layer', 'jquery', 'element'], function () {
    var $ = layui.$;
    var form = layui.form;
    var element = layui.element;
	element.init();
accessid = ''
accesskey = ''
host = ''
policyBase64 = ''
signature = ''
callbackbody = ''
filename = ''
key = ''
expire = 0
g_object_name = ''
g_object_name_type = ''
now = timestamp = Date.parse(new Date()) / 1000; 

/*var aliImgCount = $("#picCount").val();
var aliVideoCount = $("#videoCount").val();*/
var loading

function send_request(type)
{
    var xmlhttp = null;
    if (window.XMLHttpRequest)
    {
        xmlhttp=new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  
    if (xmlhttp!=null)
    {
    	//获取商户ID
    	var merchantId = document.getElementById('merchantOption').value;
        // serverUrl是 用户获取 '签名和Policy' 等信息的应用服务器的URL，请将下面的IP和Port配置为您自己的真实信息。
    	//serverUrl = 'http://192.168.2.13:9182/cloud-manager/ali/oss/getSign?type='+type+ "&merchantId=" +merchantId
        serverUrl = '../ali/oss/getSign?type='+type+ "&merchantId=" +merchantId
        //serverUrl = '${rc.contextPath}/ali/oss/getSign?type='+type
        xmlhttp.open( "GET", serverUrl, false );
        xmlhttp.send( null );
        return xmlhttp.responseText
    }
    else
    {
        alert("Your browser does not support XMLHTTP.");
    }
};

function check_object_radio() {
    var tt = document.getElementsByName('myradio');
    for (var i = 0; i < tt.length ; i++ )
    {
        if(tt[i].checked)
        {
            g_object_name_type = tt[i].value;
            break;
        }
    }
}

function get_signature(type)
{
    // 可以判断当前expire是否超过了当前时间， 如果超过了当前时间， 就重新取一下，3s 作为缓冲。
    now = timestamp = Date.parse(new Date()) / 1000; 
    if (expire < now + 3)
    {
        body = send_request(type)
        var obj = eval ("(" + body + ")");
        host = obj['host']
        policyBase64 = obj['policy']
        accessid = obj['accessid']
        signature = obj['signature']
        expire = parseInt(obj['expire'])
        callbackbody = obj['callback'] 
        key = obj['dir']
        return true;
    }
    return false;
};

function random_string(len) {
　　len = len || 32;
　　var chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';   
　　var maxPos = chars.length;
　　var pwd = '';
　　for (i = 0; i < len; i++) {
    　　pwd += chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return pwd;
}

function uuid() {
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4"; // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "-";

    var uuid = s.join("");
    return uuid;
}


function get_suffix(filename) {
    pos = filename.lastIndexOf('.')
    suffix = ''
    if (pos != -1) {
        suffix = filename.substring(pos)
    }
    return suffix;
}

function calculate_object_name(filename)

{
	if (g_object_name_type == 'local_name')
    {
		suffix = get_suffix(filename)
        g_object_name +=  uuid() + suffix
    }
    else if (g_object_name_type == 'random_name')
    {
        suffix = get_suffix(filename)
        g_object_name = key + random_string(10) + suffix
    }
    return ''
}

function get_uploaded_object_name(filename)
{
	if (g_object_name_type == 'local_name')
    {
        tmp_name = g_object_name
        tmp_name = tmp_name.replace("${filename}", filename);
        return tmp_name
    }
    else if(g_object_name_type == 'random_name')
    {
        return g_object_name
    }
}

function set_upload_param(up, filename, ret,type)
{
    if (ret == false)
    {
        ret = get_signature(type)
    }
    g_object_name = key;
    if (filename != '') { suffix = get_suffix(filename)
        calculate_object_name(filename)
    }
    new_multipart_params = {
        'key' : g_object_name,
        'policy': policyBase64,
        'OSSAccessKeyId': accessid, 
        'success_action_status' : '200', //让服务端返回200,不然，默认会返回204
	    /*'callback' : callbackbody,*/
        'signature': signature,
    };

    up.setOption({
        'url': host,
        'multipart_params': new_multipart_params
    });

    up.start();
}

//附件图片上传
var spuContentPicUploader = new plupload.Uploader({
	runtimes : 'html5,flash,silverlight,html4',
	browse_button : 'addPicAli', 
    //multi_selection: false,
	container: document.getElementById('spuContentPicContainer'),
	flash_swf_url : '${rc.contextPath}/lib/plupload-2.1.2/js/Moxie.swf',
	silverlight_xap_url : '${rc.contextPath}/lib/plupload-2.1.2/js/Moxie.xap',
    url : 'http://oss.aliyuncs.com',

    filters: {
        mime_types : [ //只允许上传图片
        { title : "Image files", extensions : "jpg,gif,png,bmp" }
        ],
        max_file_size : '10mb' //最大只能上传10mb的文件
      	//prevent_duplicates : true //不允许选取重复文件
    },

	init: {
		PostInit: function() {
			//上传图片
			document.getElementById('addPicAli').onclick = function() {
            set_upload_param(spuContentPicUploader, '', false,'image');
            return false;
			};
		},

		FilesAdded: function(up, files) {
			plupload.each(files, function(file) {
				g_object_name_type = 'local_name'
			    set_upload_param(up, file.name, true,'');
			});
		},

		BeforeUpload: function(up, file) {
            //check_object_radio();
			g_object_name_type = 'local_name'
            set_upload_param(up, file.name, true,'');
        },

		UploadProgress: function(up, file) {
		},

		FileUploaded: function(up, file, info) {
			console.log(info)
			var count = $("#count").val();
            if (info.status == 200)
            {
            		var objUrl = 'http://img.scanall-nrc.com/'+ get_uploaded_object_name(file.name)
                	//计数
                	var tr = '<tr id="upload-'+ count +'">'
		            +'<td style="text-align: center;"><img style="width:50px;height:50px;" src="'+objUrl+'">'+ file.name +'</td>'
		            +'<td style="text-align: center;"><span style="color: #5FB878;">上传成功</span><input type="hidden" id="img_'+count+'" value="'+objUrl+'"></td>'
		            +'<td style="text-align: center;">'
		              /*,'<button class="layui-btn layui-btn-mini test-upload-demo-reload layui-hide">重传</button>'*/
		              +'<button class="layui-btn layui-btn-mini layui-btn-danger test-upload-demo-delete" onclick="onEdit(1,'+count+')">删除</button>'
		            +'</td>'
		          +'</tr>';
                	$("#picTd").append(tr);
                	count++;
                	$("#count").val(count);
            }
            else if (info.status == 203)
            {
                document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '上传到OSS成功，但是oss访问用户设置的上传回调服务器失败，失败原因是:' + info.response;
            }
            else
            {
                document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = info.response;
            } 
		},

		Error: function(up, err) {
			console.log(err)
            if (err.code == -600) {
            	layer.msg("选择的文件太大了,请选择10mb以下的", {
                    icon: 2
                   ,time: 1000
                 })
                /*document.getElementById('console').appendChild(document.createTextNode("\n选择的文件太大了,可以根据应用情况，在upload.js 设置一下上传的最大大小"));*/
            }
            else if (err.code == -601) {
                	layer.msg("文件类型不符,请上传图片", {
                        icon: 2
                       ,time: 1000
                     })
               /* document.getElementById('console').appendChild(document.createTextNode("\n选择的文件后缀不对,可以根据应用情况，在upload.js进行设置可允许的上传文件类型"));*/
            }
            else if (err.code == -602) {
                document.getElementById('console').appendChild(document.createTextNode("\n这个文件已经上传过一遍了"));
            }
            else 
            {
                document.getElementById('console').appendChild(document.createTextNode("\nError xml:" + err.response));
            }
		}
	}
});

//商品内容管理视频
var spuContentVideoUploader = new plupload.Uploader({
	runtimes : 'html5,flash,silverlight,html4',
	browse_button : 'addPDFALi', 
    //multi_selection: false,
	container: document.getElementById('spuContentVideoContainer'),
	flash_swf_url : '${rc.contextPath}/lib/plupload-2.1.2/js/Moxie.swf',
	silverlight_xap_url : '${rc.contextPath}/lib/plupload-2.1.2/js/Moxie.xap',
    url : 'http://oss.aliyuncs.com',

    filters: {
        mime_types : [ //只允许上传图片和zip文件
        { title : "Image files", extensions : "jpg,gif,png,bmp" }, 
        /*{ title : "Zip files", extensions : "zip,rar" },*/
        { title : "PDF files", extensions : "pdf" },
        ],
        max_file_size : '200mb' //最大只能上传10mb的文件
      	//prevent_duplicates : true //不允许选取重复文件
    },

	init: {
		PostInit: function() {
			//上传视频
			document.getElementById('addPDFALi').onclick = function() {
            set_upload_param(spuContentVideoUploader, '', false,'video');
            return false;
			};
		},

		FilesAdded: function(up, files) {
			plupload.each(files, function(file) {
				g_object_name_type = 'local_name'
			    set_upload_param(up, file.name, true,'');
			});
			loading = layer.msg('loading...', {
	            icon:16,
	            shade:[0.1, '#fff'],
	            time:false  //取消自动关闭
	        }); 
		},

		BeforeUpload: function(up, file) {
            //check_object_radio();
			g_object_name_type = 'local_name'
            set_upload_param(up, file.name, true,'');
        },

		UploadProgress: function(up, file) {
		},

		FileUploaded: function(up, file, info) {
			layer.close(loading);
			console.log(info)
            if (info.status == 200)
            {
            	//计数
            	var tr = '<tr id="upload-'+ count +'">'
	            +'<td style="text-align: center;"><img style="width:50px;height:50px;" src="'+objUrl+'">'+ file.name +'</td>'
	            +'<td style="text-align: center;"><span style="color: #5FB878;">上传成功</span><input type="hidden" id="img_'+count+'" value="'+objUrl+'"></td>'
	            +'<td style="text-align: center;">'
	              /*,'<button class="layui-btn layui-btn-mini test-upload-demo-reload layui-hide">重传</button>'*/
	              +'<button class="layui-btn layui-btn-mini layui-btn-danger test-upload-demo-delete" onclick="onEdit(1,'+count+')">删除</button>'
	            +'</td>'
	          +'</tr>';
            	$("#picTd").append(tr);
            	count++;
            	$("#count").val(count);
            }
            else if (info.status == 203)
            {
                document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '上传到OSS成功，但是oss访问用户设置的上传回调服务器失败，失败原因是:' + info.response;
            }
            else
            {
                document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = info.response;
            } 
		},

		Error: function(up, err) {
			console.log(err)
            if (err.code == -600) {
            	layer.msg("选择的文件太大了,请选择200m以下的", {
                    icon: 2
                   ,time: 1000
                 })
                /*document.getElementById('console').appendChild(document.createTextNode("\n选择的文件太大了,可以根据应用情况，在upload.js 设置一下上传的最大大小"));*/
            }
            else if (err.code == -601) {
                	layer.msg("文件类型不符，请上传PDF或图片", {
                        icon: 2
                       ,time: 1000
                     })
                /*document.getElementById('console').appendChild(document.createTextNode("\n选择的文件后缀不对,可以根据应用情况，在upload.js进行设置可允许的上传文件类型"));*/
            }
            else if (err.code == -602) {
                document.getElementById('console').appendChild(document.createTextNode("\n这个文件已经上传过一遍了"));
            }
            else 
            {
                document.getElementById('console').appendChild(document.createTextNode("\nError xml:" + err.response));
            }
		}
	}
});

spuContentPicUploader.init();
spuContentVideoUploader.init();

})