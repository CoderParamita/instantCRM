<html>

<jsp:include page="WEB-INF/css/loginstyle.css"/>
<jsp:include page="WEB-INF/css/BasicTemplate.css"/>
<%@include file="WEB-INF/pages/template/header.jsp" %>
<%@include file="WEB-INF/pages/template/body2.jsp" %>
<script  type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script  type="text/javascript" src="js/validation.js"></script>

<body>

<div >
	<form method="post" action="./login">
		<div id="logindiv">
				     <div id="loginupdiv">
		    	 <span>Log In Page</span><br/>
                <label>Username</label><br/>
                <input type="text" id="uname" class="inputbox" name="username"/>
                <label>Password</label><br/>
                <input type="password" id="pass" class="inputbox" name="userpwd"/>
            </div>
            <div id="loginlowdiv">
                <input type="submit" id="loginbutton" class="button" value="LogIn">
                </div>
            </div>
	</form>
</div>
<%@include file="WEB-INF/pages/template/footer.jsp" %>

