<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring React</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/react/15.3.2/react.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react-dom/15.0.1/react-dom.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.24/browser.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.1.3/toastr.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.1.3/toastr.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.18.0/axios.min.js"></script>
<script type="text/babel" src="./App.js"></script>
<script>
	function resizeIframe(obj) {
		obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
	}
</script>
<style>
#app {
	height: 100vh;
}

.nav {
	padding: 10px 10px 0;
	background: #DAE8EB;
	color: #787F7D;
}
/*.nav-tabs > li > a {padding-top:1px !important; padding-bottom:1px !important;}*/
.is-visible {
	border: solid 1px red;
}

section {
	margin: 20px;
}

h2, p {
	margin: 0;
}

ul {
	list-style-type: none;
}
</style>
</head>
<body>
<div id="app"></div>

</body>
</html>