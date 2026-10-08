<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Portal - Login</title>

    <link rel="stylesheet" href="/JOB-Portal/css/style.css">
</head>

<body class="form-body">

    <nav class="navbar">

        <div class="logo">
            Job Portal
        </div>

        <div class="nav-links">
            <a href="./">Home</a>
            <a href="register">Register</a>
        </div>

    </nav>


    <div class="form-container">

        <div class="form-card">

            <h1>Welcome Back!</h1>

            <p class="form-subtitle">
                Login to access your Job Portal Dashboard.
            </p>

            <p class="error-message">
    ${errorMsg}
</p> 

            <form action="login" method="post">

                <div class="input-group">

                    <label>Email Address</label>

                    <input type="email"
                           name="email"
                           placeholder="Enter your email"
                           required>

                </div>


                <div class="input-group">

                    <label>Password</label>

                    <input type="password"
                           name="password"
                           placeholder="Enter your password"
                           required>

                </div>


                <button type="submit" class="btn form-btn">
                    Login
                </button>

            </form>


            <p class="bottom-text">
                Don't have an account?
                <a href="register">Register Here</a>
            </p>

        </div>

    </div>

</body>
</html>