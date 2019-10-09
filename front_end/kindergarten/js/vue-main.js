axios.defaults.baseURL = '/manager';
if (localStorage.length > 0 && sessionStorage.length <= 0) {

	sessionStorage.setItem("userId", resultdata.data.userInfo.id);
	sessionStorage.setItem("userInfo", resultdata.data.userInfo);
	sessionStorage.setItem("accessToken", resultdata.data.accessToken);
}

// http request 拦截器
axios.interceptors.request.use(
	config => {

		if (sessionStorage.accessToken) { // 判断是否存在token，如果存在的话，则每个http header都加上token
			config.headers.accessToken = sessionStorage.accessToken;
		}
		return config;
	},
	err => {
		return Promise.reject(err);
	});

// http response 拦截器
axios.interceptors.response.use(
	response => {
		return response;
	},
	error => {
		if (error.response) {
			console.log('axios:' + error.response.status);
			switch (error.response.status) {
				case 401:
					logout();
					parent.location.href = "../../login.html?returnUrl=" + top.location.href;
					break;
				case 202:
					layer.alert("无权访问");
					break;
				default:
					if (error.response.data.message) {
						layer.alert(error.response.data.message);
					} else {
						layer.alert("出错啦");
					}
					break;
			}
		}
		return Promise.reject(error.response.data); // 返回接口返回的错误信息
	});

Vue.prototype.$http = axios;

function logout() {
	sessionStorage.clear();
	localStorage.clear();
}

function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) return unescape(r[2]);
	return null;
}
