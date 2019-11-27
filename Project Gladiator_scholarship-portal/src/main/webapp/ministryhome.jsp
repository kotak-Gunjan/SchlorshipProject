<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="app.css">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
    <script src="app/js/app.js"></script>
</head>


<body>
        <div class="login-page">
            <div class="form">
                <h2>National Scholarship Portal</h2>
                Ministry Home Page<br>
                Welcome, ${sessionScope.ministry.userName}
                <form  action="view1.lti" method="get" class="login-form" autocomplete="on">
<br>
                        <div class="row">
                                <div class="column">
                                    
                                    <a href="view1.lti">Click here to view Student Applications</a>
                                    </br>
                                    </br>
                                    <button onclick="window.location.href = 'home.jsp';">HOME</button> 
                                </div>
                                <div class="column">

                                </div>
                                <div class="column">
                                    
                                </div>
                              </div>
                    </form>
</div>
</div>
</body>
</html>